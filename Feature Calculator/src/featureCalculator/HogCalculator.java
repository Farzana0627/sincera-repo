package featureCalculator;

import matrixUtils.MatUtils;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;

import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;

public class HogCalculator extends AbsFeatureCalculator {

    private int binCount;

    public HogCalculator(int binCount) {
        this.binCount = binCount;
        horizontalBlocks = 40;
        verticalBlocks = 40;
        setTrainingParams();
    }

    public HogCalculator() {
        this(36);
    }

    private void setTrainingParams() {
        featureSpecificTrainingParams.put("g", .0001);
        featureSpecificTrainingParams.put("c", 100);
    }

    @Override
    public Mat calculate(Mat src) {
        Size blockSize = new Size(5,5);
        return this.calculateHogWithOpenCv(src, blockSize, this.binCount);
    }

    private Mat calculateHogWithOpenCv(Mat img, Size blockSize, int binCount) {
        HOGDescriptor hogDescriptor = new HOGDescriptor(img.size(), blockSize,
                blockSize, blockSize, binCount);

        MatOfFloat descriptors = new MatOfFloat();
        hogDescriptor.compute(img, descriptors);
        return MatUtils.straightenMatrix(descriptors);
    }

    private Mat calculateHog(Mat origImg, int horizontalBlockCount,
                             int verticalBlockCount, Mat convolutionMatrix) {
        final double pi = 3.1416;
        final int histogramBinCount = 9;
        Mat grayImage = new Mat();

        if (origImg.channels() > 1) {
            Imgproc.cvtColor(origImg, grayImage, Imgproc.COLOR_RGB2GRAY);
        } else {
            grayImage = origImg;
        }

        grayImage.convertTo(grayImage, CvType.CV_32FC1);
        int imageHeiht = origImg.height();
        int imageWidth = origImg.width();
        Mat hogMatrix = MatUtils.createMatrixWithZero(1, horizontalBlockCount
                * verticalBlockCount * histogramBinCount);
        float horizontalPixelPerBlock = imageWidth / (horizontalBlockCount + 1);
        float verticalPixelPerBlock = imageHeiht / (verticalBlockCount + 1);
        int cont = 0;

        Mat transposedConvolutionMatrix = MatUtils.transpose(convolutionMatrix,
                true);

        Mat xConvolutedImage = new Mat();
        Imgproc.filter2D(grayImage, xConvolutedImage, grayImage.depth(),
                convolutionMatrix, new Point(2, 0), 0);
        Mat yConvolutedImage = new Mat();
        Imgproc.filter2D(grayImage, yConvolutedImage, grayImage.depth(),
                transposedConvolutionMatrix, new Point(0, 2), 0);
        Mat angles = atan2(yConvolutedImage, xConvolutedImage);
        Mat magnits = magnitude(yConvolutedImage, xConvolutedImage);

        try {
            writeToFile("grayImage: \n" + grayImage.dump() + "\n angles: \n"
                    + angles.dump() + "\nmagnits: \n" + magnits.dump()
                    + "\nconvolutionMat:\n" + convolutionMatrix.dump()
                    + "\n transposedConvolution Matrix\n"
                    + transposedConvolutionMatrix.dump() + "\nxconvoluted\n"
                    + xConvolutedImage.dump() + "\nyconvoluted\n"
                    + yConvolutedImage.dump());

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int n = 0; n < verticalBlockCount; n++) {
            for (int m = 0; m < horizontalBlockCount; m++) {
                cont++;

                int x1 = (int) (n * verticalPixelPerBlock);
                int x2 = (int) ((n + 2) * verticalPixelPerBlock);
                int y1 = (int) (m * horizontalPixelPerBlock);
                int y2 = (int) ((m + 2) * horizontalPixelPerBlock);
                Mat subAngles = angles.submat(x1, x2, y1, y2);

                Mat subMagnits = magnits.submat(x1, x2, y1, y2);
                Mat straightenAngles = MatUtils.straightenMatrix(subAngles);
                Mat straightenMagnits = MatUtils.straightenMatrix(subMagnits);
                int straightenArrayLength = straightenAngles.width();
                int bin = 0;
                Mat blockHog = MatUtils.createMatrixWithZero(1,
                        histogramBinCount);

                for (double angLim = -pi + 2 * pi / histogramBinCount; angLim < pi; angLim += 2
                        * pi / histogramBinCount) {
                    for (int k = 0; k < straightenArrayLength; k++) {
                        if (straightenAngles.get(0, k)[0] < angLim) {

                            straightenAngles.put(0, k, 100);
                            blockHog.put(0, bin, blockHog.get(0, bin)[0]
                                    + straightenMagnits.get(0, k)[0]);
                        }
                    }
                    bin++;
                }

                double norm = calculateNorm(blockHog);
                for (int i = (cont - 1) * histogramBinCount, j = 0; i < cont
                        * histogramBinCount; i++, j++) {
                    hogMatrix.put(0, i, blockHog.get(0, j)[0] / (norm + 0.01));
                }
            }
        }
        System.out.println(hogMatrix.dump());
        return hogMatrix;
    }

    private Mat atan2(Mat yArr, Mat xArr) {
        int xCol = xArr.width();
        int xRow = xArr.height();
        int yCol = yArr.width();
        int yRow = yArr.height();
        if (xCol == yCol && xRow == yRow && xArr.type() == yArr.type()) {

            Mat result = new Mat(xRow, xCol, xArr.type());

            for (int r = 0; r < xRow; r++) {
                for (int c = 0; c < xCol; c++) {
                    double d = Math.atan2(yArr.get(r, c)[0], xArr.get(r, c)[0]);
                    result.put(r, c, d);
                }
            }
            return result;
        }
        throw new InvalidParameterException(
                "Both matrix should have same size and type");
    }

    private Mat magnitude(Mat xArr, Mat yArr) {
        int xHeight = xArr.height();
        int yHeight = yArr.height();
        int xWidth = xArr.width();
        int yWidth = yArr.width();

        if (xHeight == yHeight && xWidth == yWidth
                && xArr.type() == yArr.type()) {
            Mat resultMat = new Mat(xHeight, xWidth, xArr.type());
            for (int r = 0; r < xHeight; r++) {
                for (int c = 0; c < xWidth; c++) {
                    double data = (Math.sqrt(Math.pow(xArr.get(r, c)[0], 2)
                            + Math.pow(yArr.get(r, c)[0], 2)));
                    resultMat.put(r, c, data);
                }
            }

            return resultMat;
        }
        throw new InvalidParameterException(
                "Both matrix should have same size and type");
    }

    private double calculateNorm(Mat mat) {
        double resultVal = 0;
        for (int r = 0; r < mat.height(); r++) {
            for (int c = 0; c < mat.width(); c++) {
                resultVal += Math.pow(mat.get(r, c)[0], 2);
            }
        }
        return resultVal;
    }

    private void writeToFile(String s) throws IOException {
        FileWriter writer = new FileWriter("F:\\output.java.debug.txt");
        writer.write(s);
        writer.close();
    }
}
