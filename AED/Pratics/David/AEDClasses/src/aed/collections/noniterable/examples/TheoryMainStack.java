package aed.collections.noniterable.examples;

import aed.collections.noniterable.structures.Stack;
import aed.model.people.Person;

public class TheoryMainStack {

    public static void main(String[] args) {
        Stack<Person> people = new Stack<>();

        people.insert(new Person(3, "B"));
        people.insert(new Person(1, "C"));
        people.insert(new Person(2, "A"));

        System.out.println("People\n" + people);

        people.remove();
        System.out.println("People\n" + people);

        System.out.println(people.get());

        people.remove();
        System.out.println("People\n" + people);
    }
}
