package aed.analisecomplexidade.algoritmos;

import aed.utils.Par;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class SubsequenciaSomaMaximaDeOrdemNLog2N extends SubsequenciaSomaMaxima {

    @Override
    public long execute(Par<Integer, Integer> startAndEndIndices, int... elements) {
        return executeRecursive(startAndEndIndices, elements, getFirstPositive(elements), getLastPositive(elements));
    }

    private long executeRecursive(Par<Integer, Integer> startAndEndIndices, int[] elements, int leftBound, int rightBound) {
        long maximumSum = 0;
        int start, end;
        if (leftBound == rightBound) {
            startAndEndIndices.setFirst(leftBound);
            startAndEndIndices.setSecond(rightBound);
            start = end = leftBound;
            maximumSum = elements[leftBound] > 0 ? elements[leftBound] : 0;
            return maximumSum = 0;
        }

        int middle = (leftBound + rightBound) / 2;
        Par<Integer, Integer> leftStartAndEndIndices = new Par<>(0, 0);
        Par<Integer, Integer> rightStartAndEndIndices = new Par<>(0, 0);
        long leftMaximumSum = executeRecursive(leftStartAndEndIndices, elements, leftBound, middle);
        long rightMaximumSum = executeRecursive(rightStartAndEndIndices, elements, middle + 1, rightBound);
        int leftStart = leftStartAndEndIndices.getFirst();
        int leftEnd = leftStartAndEndIndices.getSecond();
        int rightStart = rightStartAndEndIndices.getFirst();
        int rightEnd = rightStartAndEndIndices.getSecond();
        long middleLeftMaximumSum = 0, currentMiddleLeftSum = 0;
        int crossStart = middle + 1;
        for (int i = middle; i >= leftBound; i--) {
            currentMiddleLeftSum += elements[i];
            if (currentMiddleLeftSum > middleLeftMaximumSum) {
                crossStart = i;
                middleLeftMaximumSum = currentMiddleLeftSum;
            }
        }

        long middleRightMaximumSum = 0, currentMiddleRightSum = 0;
        int crossEnd = middle;
        for (int i = middle + 1; i <= rightBound; i++) {
            currentMiddleRightSum += elements[i];
            if (currentMiddleRightSum > middleRightMaximumSum) {
                crossEnd = i;
                middleRightMaximumSum = currentMiddleRightSum;
            }
        }

        long crossMaximumSum = middleLeftMaximumSum + middleRightMaximumSum;
        if (leftMaximumSum >= rightMaximumSum && leftMaximumSum >= crossMaximumSum) {
            start = leftStart;
            end = leftEnd;
            startAndEndIndices.setFirst(start);
            startAndEndIndices.setSecond(end);
            maximumSum = leftMaximumSum;
            return maximumSum;
        }
        if (rightMaximumSum >= crossMaximumSum) {
            start = rightStart;
            end = rightEnd;
            startAndEndIndices.setFirst(start);
            startAndEndIndices.setSecond(end);
            maximumSum = rightMaximumSum;
            return maximumSum;
        }
        start = crossStart;
        end = crossEnd;
        startAndEndIndices.setFirst(start);
        startAndEndIndices.setSecond(end);
        maximumSum = crossMaximumSum;
        return maximumSum;
    }

}
