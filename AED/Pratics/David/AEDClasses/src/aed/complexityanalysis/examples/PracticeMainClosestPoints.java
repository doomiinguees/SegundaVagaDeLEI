package aed.complexityanalysis.examples;

import aed.complexityanalysis.algorithms.ClosestPoints;
import aed.utils.Point2DArray;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class PracticeMainClosestPoints {

    public static void main(String[] args) {
        int[] ns = {4};
        for (int n : ns) {
            ClosestPoints.display(Point2DArray.createRandom(n));
        }

        System.out.println("\nFor 30 points: 30 * 29 / 2 = 435 comparisons.");
        System.out.println("C(n) = (n - 1) + (n - 2) + ... + 1 = n(n - 1)/2.");
        System.out.println("Time complexity: Theta(n^2). Extra space: O(1).");
    }
}
