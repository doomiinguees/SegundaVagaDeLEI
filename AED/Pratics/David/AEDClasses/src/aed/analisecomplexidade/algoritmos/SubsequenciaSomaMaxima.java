package aed.analisecomplexidade.algoritmos;

import aed.utils.Par;
import aed.utils.VetorDeInteiros;

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
public abstract class SubsequenciaSomaMaxima {

    public abstract long execute(Par<Integer, Integer> startAndEndIndices, int... elements);

    public void display(int displayElementCount, int... elements) {
        Par<Integer, Integer> startAndEndIndices = new Par<>(0, 0);
        System.out.println("Subsequência da soma máxima calculada com " + getClass().getSimpleName() + "da sequência: ");
        VetorDeInteiros.display(displayElementCount, elements);
        long resultValue = execute(startAndEndIndices, elements);
        System.out.println("Indice inicial = " + startAndEndIndices.getFirst() +
                " Indice final = " + startAndEndIndices.getSecond() +
                " Soma = " + resultValue);
        VetorDeInteiros.display(displayElementCount,
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
