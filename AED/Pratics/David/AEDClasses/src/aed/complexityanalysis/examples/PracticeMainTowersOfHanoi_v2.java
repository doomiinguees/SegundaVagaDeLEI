package aed.complexityanalysis.examples;

import aed.complexityanalysis.algorithms.TowersOfHanoi_v2;
import aed.recursion.algorithms.TowersOfHanoi;

public class PracticeMainTowersOfHanoi_v2 {

    public static void main(String[] args) {

        int[] ns = {3};

        for (int n : ns) {
            TowersOfHanoi_v2.display(n);
        }
    }
}
