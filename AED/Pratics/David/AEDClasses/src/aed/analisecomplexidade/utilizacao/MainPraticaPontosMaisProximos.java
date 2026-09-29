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
        int[] ns = {5, 10, 15};
        for (int n : ns) {
            PontosMaisProximos.display(VetorDePoint2D.createRandom(n));
        }
    }
}