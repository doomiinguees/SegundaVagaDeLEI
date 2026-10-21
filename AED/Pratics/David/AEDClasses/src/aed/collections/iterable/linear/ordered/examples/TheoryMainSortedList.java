package aed.collections.iterable.linear.ordered.examples;

import aed.collections.iterable.BidirectionalIterableIterator;
import aed.collections.iterable.linear.ordered.structures.SortedList;
import aed.model.people.Person;
import aed.model.people.comparators.PeopleByIdNumberAscendingComparator;
import aed.model.people.comparators.PeopleByNameAscendingComparator;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class TheoryMainSortedList {

    public static void main(String[] args) {
        Person p;
        SortedList<Person> peopleByIdNumber = new SortedList<>(
                PeopleByIdNumberAscendingComparator.COMPARATOR);
        SortedList<Person> peopleByName = new SortedList<>(
                PeopleByNameAscendingComparator.COMPARATOR);

        p = new Person(3, "B");
        peopleByIdNumber.insert(p);
        peopleByName.insert(p);
        p = new Person(7, "C");
        peopleByIdNumber.insert(p);
        peopleByName.insert(p);
        p = new Person(5, "G");
        peopleByIdNumber.insert(p);
        peopleByName.insert(p);
        p = new Person(1, "C");
        peopleByIdNumber.insert(p);
        peopleByName.insert(p);

        System.out.println("People by ID\n" + peopleByIdNumber);
        System.out.println("People by name\n" + peopleByName);

        System.out.println("People with name < C");
        for (Person person : peopleByIdNumber) {
            if (person.getName().compareTo("C") < 0) {
                System.out.println(person);
            }
        }

        System.out.println("\nPeople named C");
        BidirectionalIterableIterator<Person> customIterator = peopleByName.get(new Person(0, "C"));
        while (customIterator.canAdvance()) {
            customIterator.advance();
            System.out.println(customIterator.current());
        }

        peopleByIdNumber.remove(p);

        System.out.println("\nPeople with names between A and E inclusive");
        for (Person person : peopleByName.get(new Person(0, "A"), new Person(0, "E"))) {
            System.out.println(person);
        }

        System.out.println("\nPeople with IDs between 2 and 6 inclusive in reverse order");
        customIterator = peopleByIdNumber.get(new Person(2, ""), new Person(6, ""));
        while (customIterator.canRetreat()) {
            System.out.println(customIterator.retreat());
        }

        peopleByName.removeByIndex(1);

        System.out.println("\nPeople by ID\n" + peopleByIdNumber);
        System.out.println("People by name\n" + peopleByName);

        System.out.println(peopleByIdNumber.getByIndex(1));
    }
}
