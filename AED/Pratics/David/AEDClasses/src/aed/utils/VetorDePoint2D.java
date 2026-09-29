package aed.utils;

import java.awt.geom.Point2D;
import java.util.Random;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class VetorDePoint2D {
    public static Point2D[] createRandom(int size) {
        Point2D[] resultValue = new Point2D[size];
        Random rnd = new Random(1);
        for (int i = 0; i < size; i++) {
            resultValue[i] = new Point2D.Double(rnd.nextInt(10000), rnd.nextInt(10000));
        }
        return resultValue;
    }
}
