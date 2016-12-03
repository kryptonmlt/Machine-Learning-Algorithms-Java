package org.kryptonmlt.ml.batchalg.regression;

import java.util.List;
import org.kryptonmlt.ml.onlinealg.utils.LearningUtils;
import org.kryptonmlt.ml.Learning;

/**
 *
 * @author Kurt
 */
public class BatchGradientDescent implements Learning {

    private double[] weights = new double[3];
    private double alpha = 0.05;

    public BatchGradientDescent(double alpha) {
        this.alpha = alpha;
    }

    @Override
    public double predict(double x1, double x2) {
        return LearningUtils.hypothesis(weights, x1, x2);
    }

    @Override
    public void learn(double x1, double x2, double y) {
        throw new UnsupportedOperationException("Use batch learn function!");
    }

    @Override
    public void learn(List<float[]> data) {
        int MAX = 10000;
        int[] p = {0, 1, 1};
        int runC = 0;
        do {
            double[] thetaTemp = new double[weights.length];
            for (int i = 0; i < weights.length; i++) {
                double summation = 0;
                for (int j = 0; j < data.size(); j++) {
                    double[] x = {1, data.get(j)[0], data.get(j)[1]};
                    summation = (predict(x[1], x[2]) - data.get(j)[2]) * Math.pow(x[i], p[i]);
                }
                double avg = summation / (float) data.size();
                thetaTemp[i] = weights[i] - (alpha * avg);
            }
            weights = thetaTemp;
            System.out.println(runC + " : " + calculateError(data));
            runC++;
        } while (runC < MAX);
    }

    public double calculateError(List<float[]> data) {
        double error = 0;
        for (float[] d : data) {
            double value = predict(d[0], d[1]) - d[2];
            error += value * value;
        }
        error = error / (data.size() * 2.0);
        return error;
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
