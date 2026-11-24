package aed.complexityanalysis.examples;

import aed.complexityanalysis.algorithms.MaximumSumSubsequence;
import aed.complexityanalysis.algorithms.MaximumSumSubsequenceNLog2N;

public class TheoryMainMaximumSumSubsequenceNLog2N {

    public static void main(String[] args) {
        MaximumSumSubsequence maximumSumSubsequence = new MaximumSumSubsequenceNLog2N();
        maximumSumSubsequence.display(10, -2, 11, -4, 5, 7, -3, 13, 7, -5, 3);
        maximumSumSubsequence.display(10, -1, 4, -10, 3, 5, -9, 6);
    }
}
