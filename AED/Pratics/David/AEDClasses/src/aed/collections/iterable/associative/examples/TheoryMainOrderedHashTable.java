package aed.collections.iterable.associative.examples;

import aed.LongComparator;
import aed.collections.iterable.BidirectionalIterableIterator;
import aed.collections.iterable.associative.structures.Association;
import aed.collections.iterable.associative.structures.OrderedHashTable;
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
public class TheoryMainOrderedHashTable {

    public static void main(String[] args) {
        OrderedHashTable<Long, Person> peopleByIdNumber =
                new OrderedHashTable<>(LongComparator.COMPARATOR, 5);

        peopleByIdNumber.insert(3L, new Person(3, "B"));
        peopleByIdNumber.insert(2L, new Person(2, "C"));
        peopleByIdNumber.remove(3L);
        System.out.println("\nPeople by ID\n" + peopleByIdNumber);
        peopleByIdNumber.insert(7L, new Person(7, "C"));
        peopleByIdNumber.insert(13L, new Person(13, "A"));

        System.out.println("People by ID\n" + peopleByIdNumber);

        System.out.println("\nLook up key: 2 " + peopleByIdNumber.get(2L));
        System.out.println("\nLook up key: 12 " + peopleByIdNumber.get(12L));

        peopleByIdNumber.insert(12L, new Person(12, "F"));
        peopleByIdNumber.insert(23L, new Person(23, "H"));
        System.out.println("\nPeople by ID\n" + peopleByIdNumber);

        peopleByIdNumber.remove(2L);
        System.out.println("\nPeople by ID\n" + peopleByIdNumber);

        System.out.println("\nLook up key: 13 " + peopleByIdNumber.get(13L));

        BidirectionalIterableIterator<Association<Long, Person>> customIterator = peopleByIdNumber.getIterator();

        System.out.println("\nPeople with name < C");
        Association<Long, Person> a;
        while (customIterator.canAdvance()) {
            a = customIterator.advance();
            if (a.getValue().getName().compareTo("C") < 0) {
                System.out.println(customIterator.current());
            }
        }

        System.out.println("\nPeople");
        for (Person person : peopleByIdNumber.getValueIterator()) {
            System.out.println(person);
        }

        System.out.println("\nIDs");
        for (Long idNumber : peopleByIdNumber.getKeyIterator()) {
            System.out.println(idNumber);
        }

        customIterator.reset();
        System.out.println("\nFirst association");
        System.out.println(customIterator.advance());
    }
}
