package featureCalculator;

import matrixUtils.MatUtils;
import org.opencv.core.*;

import java.util.ArrayList;

public class LbpCalculator extends AbsFeatureCalculator {

    float[] xArr, yArr;
    int[] fxArr, fyArr, cxArr, cyArr;
    float[] txArr, tyArr, w1Arr, w2Arr, w3Arr, w4Arr;

    protected int[] uniformPattern59 = new int[]{
            1, 2, 3, 4, 5, 59, 6, 7, 8, 59, 59, 59, 9, 59, 10, 11,
            12, 59, 59, 59, 59, 59, 59, 59, 13, 59, 59, 59, 14, 59, 15, 16,
            17, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59,
            18, 59, 59, 59, 59, 59, 59, 59, 19, 59, 59, 59, 20, 59, 21, 22,
            23, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59,
            59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59,
            24, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59,
            25, 59, 59, 59, 59, 59, 59, 59, 26, 59, 59, 59, 27, 59, 28, 29,
            30, 31, 59, 32, 59, 59, 59, 33, 59, 59, 59, 59, 59, 59, 59, 34,
            59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 35,
            59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59,
            59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 36,
            37, 38, 59, 39, 59, 59, 59, 40, 59, 59, 59, 59, 59, 59, 59, 41,
            59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 59, 42,
            43, 44, 59, 45, 59, 59, 59, 46, 59, 59, 59, 59, 59, 59, 59, 47,
            48, 49, 59, 50, 59, 59, 59, 51, 52, 53, 59, 54, 55, 56, 57, 58
    };


    protected int neighbors;
    protected int radius;
    protected static float epsilon = (float) (1.0 / 100000000000.0);

    public LbpCalculator(int radius, int neighbors) {
        this.radius = radius;
        this.neighbors = neighbors;
        horizontalBlocks = 6;
        verticalBlocks = 6;
        initializeInterpolationValues();
        setTrainingParams();
    }

    public LbpCalculator() {
        this(2, 8);
    }

    private void setTrainingParams() {
        featureSpecificTrainingParams.put("g", .000001);
        featureSpecificTrainingParams.put("c", 10);
    }

    private void initializeInterpolationValues() {
        xArr = new float[neighbors];
        yArr = new float[neighbors];
        fxArr = new int[neighbors];
        fyArr = new int[neighbors];
        cxArr = new int[neighbors];
        cyArr = new int[neighbors];
        txArr = new float[neighbors];
        tyArr = new float[neighbors];
        w1Arr = new float[neighbors];
        w2Arr = new float[neighbors];
        w3Arr = new float[neighbors];
        w4Arr = new float[neighbors];

        for (int n = 0; n < neighbors; n++) {
            xArr[n] = (float) ((radius) * Math.cos(2.0 * Math.PI * n / neighbors));
            yArr[n] = (float) ((radius) * -Math.sin(2.0 * Math.PI * n / neighbors));
            // relative indices
            fxArr[n] = (int) Math.floor(xArr[n]);
            fyArr[n] = (int) Math.floor(yArr[n]);
            cxArr[n] = (int) Math.ceil(xArr[n]);
            cyArr[n] = (int) Math.ceil(yArr[n]);
            // fractional part
            tyArr[n] = yArr[n] - fyArr[n];
            txArr[n] = xArr[n] - fxArr[n];
            // set interpolation weights
            w1Arr[n] = (1 - txArr[n]) * (1 - tyArr[n]);
            w2Arr[n] = txArr[n] * (1 - tyArr[n]);
            w3Arr[n] = (1 - txArr[n]) * tyArr[n];
            w4Arr[n] = txArr[n] * tyArr[n];
        }
    }

    @Override
    public Mat calculate(Mat src) {
        return getBlockwiseLbpHistogram(src, horizontalBlocks, verticalBlocks);
    }

    public Mat getBlockwiseLbpHistogram(Mat src, int horizontalBlocks, int verticalBlocks) {
        ArrayList<Rect> blockRects = getBlockRects(src.size(), horizontalBlocks, verticalBlocks);
        ArrayList<Mat> hists = new ArrayList<Mat>();
        src = MatUtils.getPaddedImage(src, radius);
        for (Rect rect : blockRects) {
            Rect rect1 = new Rect(rect.x, rect.y, rect.width + 2 * radius, rect.height + 2 * radius);
            Mat submat = src.submat(rect1);
            Mat lbpImage = getLbpImage(submat);

/*
            System.out.println(submat.dump());
            System.out.println(lbpImage.dump());
*/

            Mat histogram = calculateUniformLbpHistogram(lbpImage);
            hists.add(histogram);
        }
        Mat lbpHist = new Mat();
        Core.hconcat(hists, lbpHist);
        lbpHist.convertTo(lbpHist, CvType.CV_32FC1);
/*
        Mat hist = filter(lbpHist);
        System.out.println(lbpHist.dump());
*/

        return lbpHist;
    }

    protected Mat calculateUniformLbpHistogram(Mat mat) {

        Mat hist = Mat.zeros(1, 59, CvType.CV_16UC1);

        for (int r = 0; r < mat.rows(); r++) {
            for (int c = 0; c < mat.cols(); c++) {
                int pixelValue = (int) mat.get(r, c)[0];
                int binNum = uniformPattern59[pixelValue];
                hist.put(0, binNum - 1, hist.get(0, binNum - 1)[0] + 1);
            }
        }

        return hist;
    }


    private ArrayList<Rect> getBlockRects(Size srcSize, int horizontalBlocks, int verticalBlocks) {
        ArrayList<Rect> blockRects = new ArrayList<Rect>();

        int horizontalPixelsPerBlock = (int) (srcSize.width / horizontalBlocks);
        int verticalPixelsPerBlock = (int) (srcSize.height / verticalBlocks);

        for (int h = 0; h < horizontalBlocks; h++) {
            for (int v = 0; v < verticalBlocks; v++) {
                int x = horizontalPixelsPerBlock * h;
                int y = verticalPixelsPerBlock * v;
                blockRects.add(new Rect(x, y, horizontalPixelsPerBlock, verticalPixelsPerBlock));
            }
        }

        return blockRects;
    }

    private Mat getLbpImage(Mat src) {
        Mat dst = Mat.zeros(src.rows() - 2 * radius, src.cols() - 2 * radius, CvType.CV_32SC2);
        for (int r = radius; r < src.rows() - radius; r++) {
            for (int c = radius; c < src.cols() - radius; c++) {
                calculateLbpCodeForPixel(src, dst, r, c);
            }
        }
        return dst;
    }

    protected void calculateLbpCodeForPixel(Mat src, Mat dst, int r, int c) {
        for (int n = 0; n < neighbors; n++) {
            double t = w1Arr[n] * src.get(r + fyArr[n], c + fxArr[n])[0]
                    + w2Arr[n] * src.get(r + fyArr[n], c + cxArr[n])[0]
                    + w3Arr[n] * src.get(r + cyArr[n], c + fxArr[n])[0]
                    + w4Arr[n] * src.get(r + cyArr[n], c + cxArr[n])[0];

            int pixelVal = (int) dst.get(r - radius, c - radius)[0];
            double v = src.get(r, c)[0];
            boolean b = (t > v) && (Math.abs(t - v) > epsilon);
            pixelVal += (b ? 1 : 0) << n;
            dst.put(r - radius, c - radius, pixelVal, 1);
        }
    }

    public int getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(int neighbors) {
        this.neighbors = neighbors;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

/*
    private final ArrayList<Integer> columnValuesFromAdaboostOutput;

    private Mat filter(Mat lbpHist) {
        Mat mat = Mat.zeros(1, columnValuesFromAdaboostOutput.size(), lbpHist.type());
        int count = 0;
        for (Integer integer : columnValuesFromAdaboostOutput) {
            double v = lbpHist.get(0, integer)[0];
            mat.put(0, count, v);
            count++;
        }
        return mat;
    }

    private ArrayList<Integer> getColumnValuesFromAdaboostOutput(String filePath) {
        ArrayList<Integer> columnNumbers = new ArrayList<Integer>();
        try {
            File file = new File(filePath);
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            if (doc.hasChildNodes()) {
                columnNumbers.addAll(getColumnValuesFromAdaboostOutput(doc.getChildNodes()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return columnNumbers;
    }


    private ArrayList<Integer> getColumnValuesFromAdaboostOutput(NodeList nodeList) {
        ArrayList<Integer> columnNumbers = new ArrayList<Integer>();
        for (int count = 0; count < nodeList.getLength(); count++) {

            Node tempNode = nodeList.item(count);

            if (tempNode.getNodeType() == Node.ELEMENT_NODE && tempNode.getNodeName() == "column") {
                columnNumbers.add(Integer.parseInt(tempNode.getTextContent()));
            }
            if (tempNode.hasChildNodes()) {
                columnNumbers.addAll(getColumnValuesFromAdaboostOutput(tempNode.getChildNodes()));
            }
        }
        return columnNumbers;
    }

    public Mat getElbp(Mat src) {

        Mat spoints = Mat.zeros(neighbors, 2, CvType.CV_32FC1);
        if (this.radius < 2) {
            int r = 0;
            for (int x = -1; x < 2; x++) {
                for (int y = -1; y < 2; y++) {
                    if (x == 0 && y == 0) {
                        continue;
                    }
                    spoints.put(r, 0, x);
                    spoints.put(r, 1, y);
                    r++;
                }
            }
        } else {
            double a = 2 * Math.PI / this.neighbors;
            for (int n = 0; n < this.neighbors; n++) {
                spoints.put(n, 0, (-radius) * Math.sin((n - 1) * a));
                spoints.put(n, 1, (radius) * Math.cos((n - 1) * a));
            }
        }

        Core.MinMaxLocResult minMaxLocResultX = Core.minMaxLoc(spoints.col(0));
        Core.MinMaxLocResult minMaxLocResultY = Core.minMaxLoc(spoints.col(1));
        int minX = (int) minMaxLocResultX.minVal;
        int minY = (int) minMaxLocResultY.minVal;
        int maxX = (int) minMaxLocResultX.maxVal;
        int maxY = (int) minMaxLocResultY.maxVal;

        int origX = (int) (1 - Math.floor(Math.min(minX, 0)));
        int origY = (int) (1 - Math.floor(Math.min(minY, 0)));


        Mat dst = Mat.zeros(src.size(), src.type());

        for (int n = 0; n < neighbors; n++) {

            float x = (float) (spoints.get(n, 0)[0] + origX);
            float y = (float) (spoints.get(n, 1)[0] + origY);

*/
/*
            float x = (float) ((-radius) * Math.sin(2 * Math.PI / neighbors));
            float y = (float) ((radius) * Math.cos(2 * Math.PI / neighbors));
*//*


            int fx = (int) (Math.floor(x));
            int fy = (int) (Math.floor(y));
            int cx = (int) (Math.ceil(x));
            int cy = (int) (Math.ceil(y));
            int rx = Math.round(x);
            int ry = Math.round(y);

            // fractional part
            float ty = y - fy;
            float tx = x - fx;

            // set interpolation weights
            float w1 = (1 - tx) * (1 - ty);
            float w2 = tx * (1 - ty);
            float w3 = (1 - tx) * ty;
            float w4 = tx * ty;

            for (int i = radius; i < src.rows() - radius; i++) {
                for (int j = radius; j < src.cols() - radius; j++) {

                    if ((Math.abs(x - rx) < 1e-6) && (Math.abs(y - ry) < 1e-6)) {
                        System.out.println("Interpolation not needed");
                    } else {
                        // calculate interpolated value
                        float t = (float) (w1 * (float) src.get(i + fy, j + fx)[0]
                                + w2 * (float) src.get(i + fy, j + cx)[0] + w3
                                * (float) src.get(i + cy, j + fx)[0] + w4
                                * (float) src.get(i + cy, j + cx)[0]);

                        // floating point precision, so check some machine-dependent
                        // epsilon
                        float value = (float) dst.get(i - radius, j - radius)[0];
                        value += ((t > src.get(i, j)[0]) || (Math.abs(t
                                - src.get(i, j)[0]) < epsilon)) ? 1 : 0 << n;

                        dst.put(i - radius, j - radius, value);
                    }
                }
            }
        }
        return dst;
    }
*/
}
