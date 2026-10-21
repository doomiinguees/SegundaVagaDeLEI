package aed.collections.iterable.linear.ordered.examples;

import aed.collections.iterable.linear.ordered.structures.BinaryTree;
import aed.model.people.Person;
import aed.model.people.comparators.PeopleByNameAscendingComparator;

public class TheoryMainBinaryTree {

    public static void main(String[] args) {
        BinaryTree<Person> peopleByName = new BinaryTree<>(PeopleByNameAscendingComparator.COMPARATOR);

        Person[] people = {
                new Person(3, "P"),
                new Person(8, "F"),
                new Person(2, "M"),
                new Person(1, "T"),
                new Person(7, "A"),
                new Person(4, "R"),
                new Person(10, "Q"),
                new Person(5, "I"),
                new Person(13, "X"),
                new Person(11, "Z")
        };

        // Remoção de pessoa que não existe
        peopleByName.remove(new Person(6, "D"));

        for (Person person : people) {
            peopleByName.insert(person);
        }

        System.out.println("\nAll people in preorder:");
        for (Person person : peopleByName.getPreOrderIterator()) {
            System.out.println(person);
        }

        System.out.println("\nAll people in order:");
        for (Person person : peopleByName.getInOrderIterator()) {
            System.out.println(person);
        }

        System.out.println("\nAll people in order with names between B and R:");
        for (Person person : peopleByName.get(new Person(0, "B"), new Person(0, "R"))) {
            System.out.println(person);
        }

        System.out.println("\nAll people in postorder:");
        for (Person person : peopleByName.getPostOrderIterator()) {
            System.out.println(person);
        }

        System.out.println("\nAll people in level order:");
        for (Person person : peopleByName.getLevelOrderIterator()) {
            System.out.println(person);
        }


        System.out.println("\nPerson in position 4: " + peopleByName.getByIndex(3));

        peopleByName.remove(new Person(7, "A")); // Caso sem filhos
        peopleByName.remove(new Person(2, "M")); // Caso apenas com filho à esquerda
        peopleByName.remove(new Person(8, "F")); // Caso apenas com filho à direita
        peopleByName.remove(new Person(3, "P")); // Caso com dois filhos em que paiMenorElemento != filho
        peopleByName.removeByReference(people[3]);     // Caso com dois filhos em que paiMenorElemento == filho

        System.out.println("\nAll people in order:");
        for (Person person : peopleByName.getInOrderIterator()) {
            System.out.println(person);
        }
    }
}
