package aed.recursion.examples;

import aed.recursion.algorithms.TowersOfHanoi;

public class PracticeMainTowersOfHanoi {

    public static void main(String[] args) {
        int[] ns = {3, 0, 4, 5};

        for (int n : ns) {
            TowersOfHanoi.display(n);
        }
    }
}
