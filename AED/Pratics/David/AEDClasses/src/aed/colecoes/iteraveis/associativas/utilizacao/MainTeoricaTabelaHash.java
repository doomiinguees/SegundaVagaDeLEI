package aed.colecoes.iteraveis.associativas.utilizacao;

import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.associativas.estruturas.Associacao;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHash;
import aed.modelo.pessoas.Pessoa;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainTeoricaTabelaHash {

    public static void main(String[] args) {
        TabelaHash<Long, Pessoa> peopleByIdNumber = new TabelaHash<>(5);

        peopleByIdNumber.insert(3L, new Pessoa(3, "B"));
        peopleByIdNumber.insert(2L, new Pessoa(2, "C"));
        peopleByIdNumber.remove(3L);
        System.out.println("\nPessoas por BI\n" + peopleByIdNumber);
        peopleByIdNumber.insert(7L, new Pessoa(7, "C"));
        peopleByIdNumber.insert(13L, new Pessoa(13, "A"));

        System.out.println("Pessoas por BI\n" + peopleByIdNumber);

        System.out.println("\nConsultar Chave: 2 " + peopleByIdNumber.get(2L));
        System.out.println("\nConsultar Chave: 12 " + peopleByIdNumber.get(12L));

        peopleByIdNumber.insert(12L, new Pessoa(12, "F"));
        peopleByIdNumber.insert(23L, new Pessoa(23, "H"));
        System.out.println("\nPessoas por BI\n" + peopleByIdNumber);

        peopleByIdNumber.remove(2L);
        System.out.println("\nPessoas por BI\n" + peopleByIdNumber);

        System.out.println("\nConsultar Chave: 13 " + peopleByIdNumber.get(13L));

        IteradorIteravel<Associacao<Long, Pessoa>> customIterator = peopleByIdNumber.getIterator();

        System.out.println("\nPessoas com nome < C");
        Associacao<Long, Pessoa> a;
        while (customIterator.canAdvance()) {
            a = customIterator.advance();
            if (a.getValue().getName().compareTo("C") < 0) {
                System.out.println(customIterator.current());
            }
        }

        System.out.println("\nPessoas por BI");
        for (Pessoa person : peopleByIdNumber.getValueIterator()) {
            System.out.println(person);
        }

        System.out.println("\nBIs");
        for (Long idNumber : peopleByIdNumber.getKeyIterator()) {
            System.out.println(idNumber);
        }

        customIterator.reset();
        System.out.println("\nPrimeira associação");
        System.out.println(customIterator.advance());
    }
}
