package aed.colecoes.iteraveis.lineares.ordenadas.utilizacao;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaNaoOrdenada;
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
public class MainTeoricaListaNaoOrdenada {


    static void main(String[] args) {
        Pessoa p;
        ListaNaoOrdenada<Pessoa> people = new ListaNaoOrdenada<>();

        p = new Pessoa(3, "B");
        people.insertAtEnd(p);

        p = new Pessoa(1, "C");
        people.insertAtBeginning(p);

        p = new Pessoa(1, "C");
        people.insert(p);

        p = new Pessoa(2, "A");
        people.insertByIndex(2, p);
        System.out.println("Pessoas\n" + people);

        System.out.println("Pessoas de nome < C");

        for (Pessoa person : people) {
            if (person.getName().compareTo("C") < 0) {
                System.out.println(person);
            }
        }
        System.out.println("\nPessoas");
        IteradorIteravelDuplo<Pessoa> customIterator = people.getIterator();

        while (customIterator.canAdvance()) {
            customIterator.advance();

            System.out.println(customIterator.current());
        }
        System.out.println("\nPessoas inverso");
        customIterator.reset();

        while (customIterator.canRetreat()) {
            customIterator.retreat();

            System.out.println(customIterator.current());
        }
        people.removeByReference(people.getByIndex(3));
        people.removeByIndex(1);

        people.removeFromBeginning();
        people.removeFromEnd();

        System.out.println("Pessoas\n" + people);
    }
}
