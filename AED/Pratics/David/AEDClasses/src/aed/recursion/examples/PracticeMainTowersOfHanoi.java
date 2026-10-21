package aed.recursion.examples;

import aed.recursion.algorithms.TowersOfHanoi;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class PracticeMainTowersOfHanoi {

    public static void main(String[] args) {
        int[] ns = {3, 0, 4, 5};

        for (int n : ns) {
            TowersOfHanoi.display(n);
        }
    }
}
