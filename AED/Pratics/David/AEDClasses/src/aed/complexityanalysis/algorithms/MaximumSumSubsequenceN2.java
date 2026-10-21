package aed.complexityanalysis.algorithms;

import aed.utils.Pair;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MaximumSumSubsequenceN2 extends MaximumSumSubsequence {

    @Override
    public long execute(Pair<Integer, Integer> startAndEndIndices, int... elements) {
        long maximumSum = 0, currentSum;
        int start = 0, end = 0;
        int lastPositive = getLastPositive(elements);
        for (int i = 0; i <= lastPositive; i++) {
            if (elements[i] <= 0) {
                continue;
            }
            currentSum = 0;
            for (int j = i; j <= lastPositive; j++) {
                currentSum += elements[j];
                if (currentSum > maximumSum) {
                    start = i;
                    end = j;
                    maximumSum = currentSum;
                }
            }
        }
        startAndEndIndices.setFirst(start);
        startAndEndIndices.setSecond(end);
        return maximumSum;
    }
}
