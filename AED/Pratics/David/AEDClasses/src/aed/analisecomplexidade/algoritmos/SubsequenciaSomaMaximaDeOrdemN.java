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
public class SubsequenciaSomaMaximaDeOrdemN extends SubsequenciaSomaMaxima {

    @Override
    public long execute(Par<Integer, Integer> startAndEndIndices, int... elements) {
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
