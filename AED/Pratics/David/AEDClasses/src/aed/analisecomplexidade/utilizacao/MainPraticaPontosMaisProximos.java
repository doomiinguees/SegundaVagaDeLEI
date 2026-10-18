package aed.analisecomplexidade.utilizacao;

import aed.analisecomplexidade.algoritmos.PontosMaisProximos;
import aed.utils.VetorDePoint2D;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainPraticaPontosMaisProximos {

    public static void main(String[] args) {
        int[] ns = {4};
        for (int n : ns) {
            PontosMaisProximos.display(VetorDePoint2D.createRandom(n));
        }

        System.out.println("\nPara 30 pontos: 30 * 29 / 2 = 435 comparações.");
        System.out.println("C(n) = (n - 1) + (n - 2) + ... + 1 = n(n - 1)/2.");
        System.out.println("Complexidade temporal: Theta(n^2). Espaço extra: O(1).");
    }
}
