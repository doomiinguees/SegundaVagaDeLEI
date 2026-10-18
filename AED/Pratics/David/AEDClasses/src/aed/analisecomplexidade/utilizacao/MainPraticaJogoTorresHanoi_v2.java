package aed.analisecomplexidade.utilizacao;

import aed.analisecomplexidade.algoritmos.JogoTorresHanoi_v2;
import aed.recursividade.algoritmos.JogoTorresHanoi;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainPraticaJogoTorresHanoi_v2 {

    public static void main(String[] args) {

        int[] ns = {3};

        for (int n : ns) {
            JogoTorresHanoi_v2.display(n);
        }
    }
}
