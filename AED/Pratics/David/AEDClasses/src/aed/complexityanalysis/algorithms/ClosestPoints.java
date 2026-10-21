package aed.complexityanalysis.algorithms;

import aed.utils.Pair;

import java.awt.geom.Point2D;
import java.util.Arrays;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class ClosestPoints {
    public static Pair<Point2D, Point2D> execute(Point2D... points) {
        if (points == null || points.length < 2) {
            throw new IllegalArgumentException("At least two points are required.");
        }
        for (Point2D point : points) {
            if (point == null) {
                throw new IllegalArgumentException("Points cannot be null.");
            }
        }

        Point2D first = points[0];
        Point2D second = points[1];
        double minimumDistance = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double px = points[i].getX();
                px -= points[j].getX();
                double py = points[i].getY();
                py -= points[j].getY();
                double distance = Math.sqrt(px * px + py * py);
                if (distance < minimumDistance) {
                    minimumDistance = distance;
                    first = points[i];
                    second = points[j];
                }

            }
        }
        return new Pair<>(first, second);
    }

    public static void display(Point2D... points) {
        Pair<Point2D, Point2D> pair = execute(points);
        System.out.println(
                "\nSequence of " + points.length + " points: " +
                Arrays.stream(points)
                    .map(Point2D::toString)
                    .collect(java.util.stream.Collectors.joining())
        );
        System.out.println("Closest points: " + pair.toString().replace("\n\t(", "\n\t\t("));
        double px = pair.getFirst().getX();
        px -= pair.getSecond().getX();
        double py = pair.getFirst().getY();
        py -= pair.getSecond().getY();
        System.out.println("Distance => " + Math.sqrt(px * px + py * py));
        long comparisonCount = (long) points.length * (points.length - 1) / 2;
        System.out.println("Point comparisons = " + comparisonCount + "\n");
        System.out.println();
    }
}
