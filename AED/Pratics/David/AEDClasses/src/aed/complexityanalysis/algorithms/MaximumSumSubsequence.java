package aed.complexityanalysis.algorithms;

import aed.utils.Pair;
import aed.utils.IntegerArray;

import java.util.Arrays;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public abstract class MaximumSumSubsequence {

    public abstract long execute(Pair<Integer, Integer> startAndEndIndices, int... elements);

    public void display(int displayElementCount, int... elements) {
        Pair<Integer, Integer> startAndEndIndices = new Pair<>(0, 0);
        System.out.println("Maximum sum subsequence calculated using " + getClass().getSimpleName() + "of sequence: ");
        IntegerArray.display(displayElementCount, elements);
        long resultValue = execute(startAndEndIndices, elements);
        System.out.println("Start index = " + startAndEndIndices.getFirst() +
                " End index = " + startAndEndIndices.getSecond() +
                " Sum = " + resultValue);
        IntegerArray.display(displayElementCount,
                Arrays.copyOfRange(elements, startAndEndIndices.getFirst(), startAndEndIndices.getSecond() + 1));
    }

    protected int getFirstPositive(int[] elements) {
        int firstPositive = -1;
        while (++firstPositive < elements.length && elements[firstPositive] <= 0) ;
        return firstPositive;
    }

    protected int getLastPositive(int[] elements) {
        int lastPositive = elements.length;
        while (--lastPositive >= 0 && elements[lastPositive] <= 0) ;
        return lastPositive;
    }
}
