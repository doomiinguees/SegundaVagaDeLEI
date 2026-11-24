package aed.model.people.comparators;


import aed.Comparison;
import aed.model.people.Person;

public enum PeopleByNameAscendingComparator implements Comparison<Person> {
    COMPARATOR;

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
