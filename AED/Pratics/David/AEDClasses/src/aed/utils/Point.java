package aed.utils;

import java.awt.geom.Point2D;

/**
 * Ponto cartesiano apresentado no formato (x, y).
 */
public class Point extends Point2D.Double {
    public Point(double x, double y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "\n\t(" + getX() + ", " + getY() + ")";
    }
}
