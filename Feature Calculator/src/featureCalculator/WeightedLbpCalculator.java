package featureCalculator;


import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class WeightedLbpCalculator extends LbpCalculator {

    public WeightedLbpCalculator(int radius, int neighbors) {
        super(radius, neighbors);
        setTrainingParams();
    }

    public WeightedLbpCalculator() {
        this(2, 8);
    }

    private void setTrainingParams() {
        featureSpecificTrainingParams.put("g", .000000001);
        featureSpecificTrainingParams.put("c", 50);
    }

    @Override
    protected void calculateLbpCodeForPixel(Mat src, Mat dst, int r, int c) {
        double srcVal = src.get(r, c)[0];
        float[] diff = new float[neighbors];
        float max = 0, min = 255;
        for (int n = 0; n < neighbors; n++) {
            double t = w1Arr[n] * src.get(r + fyArr[n], c + fxArr[n])[0]
                    + w2Arr[n] * src.get(r + fyArr[n], c + cxArr[n])[0]
                    + w3Arr[n] * src.get(r + cyArr[n], c + fxArr[n])[0]
                    + w4Arr[n] * src.get(r + cyArr[n], c + cxArr[n])[0];

            diff[n] = (float) (srcVal - t);

            if (max < diff[n]) {
                max = diff[n];
            } else if (min > diff[n]) {
                min = diff[n];
            }
        }

        float threshold = (max - min) / 2;
        threshold *= Math.abs(min) > Math.abs(max) ? -1 : 1;
        int dstVal = 0;
        for (int i = 0; i < neighbors; i++) {
            dstVal += (diff[i] >= threshold ? 1 : 0) << i;
        }
        dst.put(r - radius, c - radius, dstVal, (max - min));
    }

    @Override
    protected Mat calculateUniformLbpHistogram(Mat mat) {
        Mat hist = Mat.zeros(1, 59, CvType.CV_16UC1);

        for (int r = 0; r < mat.rows(); r++) {
            for (int c = 0; c < mat.cols(); c++) {
                int pixelValue = (int) mat.get(r, c)[0];
                int binNum = uniformPattern59[pixelValue];
                hist.put(0, binNum - 1, hist.get(0, binNum - 1)[0] + mat.get(r, c)[1]);
            }
        }
        return hist;
    }
}
