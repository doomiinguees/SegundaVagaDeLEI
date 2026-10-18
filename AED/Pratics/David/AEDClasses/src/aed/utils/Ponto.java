package aed.utils;

import java.awt.geom.Point2D;

/**
 * Ponto cartesiano apresentado no formato (x, y).
 */
public class Ponto extends Point2D.Double {
    public Ponto(double x, double y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "\n\t(" + getX() + ", " + getY() + ")";
    }
}
