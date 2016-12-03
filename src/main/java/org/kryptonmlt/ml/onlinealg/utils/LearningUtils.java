package org.kryptonmlt.ml.onlinealg.utils;

import java.util.ArrayList;
import java.util.List;
import org.kryptonmlt.ml.Learning;

/**
 *
 * @author Kurt
 */
public class LearningUtils {

    private LearningUtils() {

    }

    public static double hypothesis(double[] weights, double x1, double x2) {
        return weights[0] + (weights[1] * x1) + (weights[2] * x2);
    }

    public static List<float[]> computeLine(List<float[]> points, Learning gd) {
        List lineStrip = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            float z = (float) gd.predict(points.get(i)[0], points.get(i)[1]);
            float[] c = {points.get(i)[0], points.get(i)[1], z};
            lineStrip.add(c);
        }
        return lineStrip;
    }
}
