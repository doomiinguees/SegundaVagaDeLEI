package aed.utils;

import java.awt.geom.Point2D;
import java.util.Random;

public class Point2DArray {
    public static Point2D[] createRandom(int size) {
        Point2D[] resultValue = new Point2D[size];
        Random rnd = new Random(1);
        for (int i = 0; i < size; i++) {
            resultValue[i] = new Point(rnd.nextInt(20), rnd.nextInt(20));
        }
        return resultValue;
    }
}
