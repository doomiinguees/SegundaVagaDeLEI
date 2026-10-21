package aed.collections.iterable.linear.ordered.examples;

import aed.collections.iterable.BidirectionalIterableIterator;
import aed.collections.iterable.linear.unordered.structures.UnorderedList;
import aed.model.people.Person;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class TheoryMainUnorderedList {


    static void main(String[] args) {
        Person p;
        UnorderedList<Person> people = new UnorderedList<>();

        p = new Person(3, "B");
        people.insertAtEnd(p);

        p = new Person(1, "C");
        people.insertAtBeginning(p);

        p = new Person(1, "C");
        people.insert(p);

        p = new Person(2, "A");
        people.insertByIndex(2, p);
        System.out.println("People\n" + people);

        System.out.println("People with name < C");

        for (Person person : people) {
            if (person.getName().compareTo("C") < 0) {
                System.out.println(person);
            }
        }
        System.out.println("\nPeople");
        BidirectionalIterableIterator<Person> customIterator = people.getIterator();

        while (customIterator.canAdvance()) {
            customIterator.advance();

            System.out.println(customIterator.current());
        }
        System.out.println("\nPeople in reverse order");
        customIterator.reset();

        while (customIterator.canRetreat()) {
            customIterator.retreat();

            System.out.println(customIterator.current());
        }
        people.removeByReference(people.getByIndex(3));
        people.removeByIndex(1);

        people.removeFromBeginning();
        people.removeFromEnd();

        System.out.println("People\n" + people);
    }
}
