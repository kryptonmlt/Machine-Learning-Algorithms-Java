package org.kryptonmlt.ml;

import java.util.List;

public interface Clustering {

    List<double[]> getCentroids();

    /**
     * Update the centroid using the point
     *
     * @param point
     * @return cluster id the point is associated with
     */
    Integer update(double[] point);

    /**
     * Description of clustering technique example alpha and K or row
     *
     * @return
     */
    String getDescription();

    /**
     * Sets the centroids of the clustering technique. Can be used in
     * initialization
     *
     * @param centroids
     */
    void setCentroids(List<double[]> centroids);

    /**
     * Associate an error with centroid/cluster Should also be used to increment
     * the number of times used
     *
     * @param i
     * @param e
     */
    public void updateError(int i, double e);

    /**
     * Get list of errors with each centroid
     *
     * @return
     */
    public List<Double> getErrors();

    /**
     * Sets the errors of each centroid
     *
     * @param errors
     */
    public void setErrors(List<Double> errors);

    /**
     * Gets number of times each centroid was used
     *
     * @return
     */
    public List<Integer> getUsed();

    /**
     * Sets the number of times each centroid was used
     *
     * @param used
     */
    public void setUsed(List<Integer> used);

    /**
     * Gets the number of times used for each cluster but normalized
     *
     * @param total
     * @return
     */
    public List<Double> getUsedNormalized(Double total);

    /**
     * Gets the number of times used for each cluster but normalized
     *
     * @param total
     * @return
     */
    public List<Double> getErrorsNormalized(Double total);
}
