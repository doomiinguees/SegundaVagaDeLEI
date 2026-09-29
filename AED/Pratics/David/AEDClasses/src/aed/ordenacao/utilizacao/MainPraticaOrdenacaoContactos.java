package aed.ordenacao.utilizacao;

import aed.modelo.contactos.Contacto;
import aed.modelo.contactos.Data;
import aed.modelo.contactos.comparadores.ComparacaoContactosPorNumeroTelefoneDes;
import aed.modelo.contactos.comparadores.ComparacaoContactosPorUltimoNomeAscSegPorDataNascimentoDes;
import aed.ordenacao.algoritmos.AlgoritmoOrdenacao;
import aed.ordenacao.algoritmos.InsertionSort;

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
public class MainPraticaOrdenacaoContactos {

    public static void main(String[] args) {

        Contacto[] originalContacts = new Contacto[]{
                new Contacto("Ana", "Silva", 950000000, "Rua de Leiria", new Data(1, 10, 1990)),
                new Contacto("Ana", "Rita", 990000000, "Travessa 25 de Abril", new Data(15, 6, 2000)),
                new Contacto("Hugo", "Santos", 971234567, "Avenida 1º de Maio", new Data(18, 3, 1994)),
                new Contacto("Teresa", "Silva", 950000001, "Rua de Leiria", new Data(2, 10, 1990)),
                new Contacto("Eça", "Queiroz", 100000000, "Praça do Almada", new Data(25, 11, 1845))
        };

        AlgoritmoOrdenacao<Contacto> algorithm1 =
                new InsertionSort<>(ComparacaoContactosPorNumeroTelefoneDes.COMPARATOR);
        AlgoritmoOrdenacao<Contacto> algorithm2 =
                new InsertionSort<>(ComparacaoContactosPorUltimoNomeAscSegPorDataNascimentoDes.COMPARATOR);

        Contacto[] copy1 = Arrays.copyOf(originalContacts, originalContacts.length);
        Contacto[] copy2 = Arrays.copyOf(originalContacts, originalContacts.length);

        algorithm1.display(20, copy1);
        algorithm2.display(20, copy2);
    }
}
