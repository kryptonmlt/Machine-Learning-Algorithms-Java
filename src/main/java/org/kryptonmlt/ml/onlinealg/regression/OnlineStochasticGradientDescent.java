package org.kryptonmlt.ml.onlinealg.regression;

import java.util.List;
import org.kryptonmlt.ml.onlinealg.utils.LearningUtils;
import org.kryptonmlt.ml.Learning;

/**
 *
 * @author Kurt
 */
public class OnlineStochasticGradientDescent implements Learning {

    private double[] weights = new double[3];
    private double alpha;

    public OnlineStochasticGradientDescent(double alpha) {
        this.alpha = alpha;
    }

    @Override
    public double predict(double x1, double x2) {
        return LearningUtils.hypothesis(weights, x1, x2);
    }

    @Override
    public void learn(List<float[]> data) {
        for (float[] point : data) {
            learn(point[0], point[1], point[2]);
        }
    }

    @Override
    public void learn(double x1, double x2, double y) {
        double[] thetaTemp = new double[weights.length];
        double[] x = {1, x1, x2};
        int[] p = {0, 1, 1};
        for (int i = 0; i < weights.length; i++) {
            double value = (predict(x1, x2) - y) * Math.pow(x[i], p[i]);
            thetaTemp[i] = weights[i] - (alpha * value);
        }
        weights = thetaTemp;
    }

    @Override
    public double[] getWeights() {
        return weights;
    }

    @Override
    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    @Override
    public double getAlpha() {
        return alpha;
    }

    @Override
    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

}
