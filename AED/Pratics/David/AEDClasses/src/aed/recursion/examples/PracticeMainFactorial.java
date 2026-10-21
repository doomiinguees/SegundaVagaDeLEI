package aed.recursion.examples;

import aed.recursion.algorithms.Factorial;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class PracticeMainFactorial {

    public static void main(String[] args) {
        int[] ns = {5, 0, -5, 21};
        for (int n : ns) {
            Factorial.display(n);
        }

        /*for (int i = 1; i < 21; i++) {
            Fatorial.display(i);
        }*/
    }
}
