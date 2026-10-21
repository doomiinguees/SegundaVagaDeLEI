package aed.complexityanalysis.examples;

import aed.complexityanalysis.algorithms.TowersOfHanoi_v2;
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
public class PracticeMainTowersOfHanoi_v2 {

    public static void main(String[] args) {

        int[] ns = {3};

        for (int n : ns) {
            TowersOfHanoi_v2.display(n);
        }
    }
}
