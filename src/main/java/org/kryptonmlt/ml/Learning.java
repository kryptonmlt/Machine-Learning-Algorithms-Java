package org.kryptonmlt.ml;

import java.util.List;

/**
 *
 * @author Kurt
 */
public interface Learning {

    /**
     * returns the prediction from x1 and x2
     *
     * @param x1
     * @param x2
     * @return
     */
    double predict(double x1, double x2);
    
    /**
     * Used in batch learning algorithms
     * @param data 
     */
    void learn(List<float[]> data);
    
    /**
     * Used in Online Learning algorithms
     * @param x1
     * @param x2
     * @param y 
     */
    void learn(double x1, double x2, double y);

    /**
     * Gets the weights
     *
     * @return
     */
    double[] getWeights();

    /**
     * Sets the weights
     *
     * @param weights
     */
    void setWeights(double[] weights);

    /**
     * Gets the alpha (learning rate)
     *
     * @return
     */
    double getAlpha();

    /**
     * sets the alpha (learning rate)
     *
     * @param alpha
     */
    void setAlpha(double alpha);

}
