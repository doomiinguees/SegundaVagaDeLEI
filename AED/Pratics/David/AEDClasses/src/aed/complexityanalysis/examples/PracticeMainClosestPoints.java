package aed.complexityanalysis.examples;

import aed.complexityanalysis.algorithms.ClosestPoints;
import aed.utils.Point2DArray;

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
