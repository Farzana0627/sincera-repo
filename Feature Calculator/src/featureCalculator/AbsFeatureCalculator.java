package featureCalculator;

import org.opencv.core.Mat;

import java.util.HashMap;
import java.util.Map;


public abstract class AbsFeatureCalculator {

    protected int horizontalBlocks, verticalBlocks;
    protected Map<String, Object> featureSpecificTrainingParams;

    protected AbsFeatureCalculator() {
        this.featureSpecificTrainingParams = new HashMap<String, Object>();
    }

    public abstract Mat calculate(Mat src);

    public Map<String, Object> getFeatureSpecificTrainingParams() {
        return featureSpecificTrainingParams;
    }
}
