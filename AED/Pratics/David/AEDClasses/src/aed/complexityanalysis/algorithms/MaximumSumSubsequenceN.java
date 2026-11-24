package aed.complexityanalysis.algorithms;

import aed.utils.Pair;

public class MaximumSumSubsequenceN extends MaximumSumSubsequence {

    @Override
    public long execute(Pair<Integer, Integer> startAndEndIndices, int... elements) {
        long maximumSum = 0, currentSum = 0;
        int firstPositive = getFirstPositive(elements);
        int start, end, currentStart;
        start = end = currentStart = firstPositive;
        int lastPositive = getLastPositive(elements);
        for (int j = firstPositive; j <= lastPositive; j++) {
            currentSum += elements[j];
            if (currentSum < 0) {
                currentStart = j + 1;
                currentSum = 0;
            } else if (currentSum > maximumSum) {
                end = j;
                start = currentStart;
                maximumSum = currentSum;
            }
        }
        startAndEndIndices.setFirst(start);
        startAndEndIndices.setSecond(end);
        return maximumSum;
    }

}
