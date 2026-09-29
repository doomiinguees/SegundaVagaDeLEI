package aed.colecoes.iteraveis.lineares.ordenadas.utilizacao;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaOrdenada;
import aed.modelo.pessoas.Pessoa;
import aed.modelo.pessoas.comparadores.ComparacaoPessoasPorBIAsc;
import aed.modelo.pessoas.comparadores.ComparacaoPessoasPorNomeAsc;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainTeoricaListaOrdenada {

    public static void main(String[] args) {
        Pessoa p;
        ListaOrdenada<Pessoa> peopleByIdNumber = new ListaOrdenada<>(
                ComparacaoPessoasPorBIAsc.COMPARATOR);
        ListaOrdenada<Pessoa> peopleByName = new ListaOrdenada<>(
                ComparacaoPessoasPorNomeAsc.COMPARATOR);

        p = new Pessoa(3, "B");
        peopleByIdNumber.insert(p);
        peopleByName.insert(p);
        p = new Pessoa(7, "C");
        peopleByIdNumber.insert(p);
        peopleByName.insert(p);
        p = new Pessoa(5, "G");
        peopleByIdNumber.insert(p);
        peopleByName.insert(p);
        p = new Pessoa(1, "C");
        peopleByIdNumber.insert(p);
        peopleByName.insert(p);

        System.out.println("Pessoas por BI\n" + peopleByIdNumber);
        System.out.println("Pessoas por Nome\n" + peopleByName);

        System.out.println("Pessoas de nome < C");
        for (Pessoa person : peopleByIdNumber) {
            if (person.getName().compareTo("C") < 0) {
                System.out.println(person);
            }
        }

        System.out.println("\nPessoas de nome C");
        IteradorIteravelDuplo<Pessoa> customIterator = peopleByName.get(new Pessoa(0, "C"));
        while (customIterator.canAdvance()) {
            customIterator.advance();
            System.out.println(customIterator.current());
        }

        peopleByIdNumber.remove(p);

        System.out.println("\nPessoas de nome entre A e E inclusive");
        for (Pessoa person : peopleByName.get(new Pessoa(0, "A"), new Pessoa(0, "E"))) {
            System.out.println(person);
        }

        System.out.println("\nPessoas de BI entre 2 e 6 inclusive por ordem inversa");
        customIterator = peopleByIdNumber.get(new Pessoa(2, ""), new Pessoa(6, ""));
        while (customIterator.canRetreat()) {
            System.out.println(customIterator.retreat());
        }

        peopleByName.removeByIndex(1);

        System.out.println("\nPessoas por BI\n" + peopleByIdNumber);
        System.out.println("Pessoas por nome\n" + peopleByName);

        System.out.println(peopleByIdNumber.getByIndex(1));
    }
}
