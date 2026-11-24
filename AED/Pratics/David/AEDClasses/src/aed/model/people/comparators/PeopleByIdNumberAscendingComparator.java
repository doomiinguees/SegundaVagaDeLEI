package aed.model.people.comparators;


import aed.Comparison;
import aed.model.people.Person;

public enum PeopleByIdNumberAscendingComparator implements Comparison<Person> {
    COMPARATOR;

    @Override
    public int compare(Person o1, Person o2) {
        return Long.compare(o1.getIdNumber(), o2.getIdNumber());
    }
}
