package aed.recursion.examples;

import aed.recursion.algorithms.Fibonacci;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class PracticeMainFibonacci {

    public static void main(String[] args) {
        int[] ns = {5, 0, -10, 40, 45};
        for (int n : ns) {
            Fibonacci.display(n);
        }


       /* for (int i = 5; i < 31; i += 5) {
            Fibonacci.display(i);
        }*/
    }
}
