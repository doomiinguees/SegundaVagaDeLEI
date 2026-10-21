package aed.model.people.comparators;


import aed.Comparison;
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
public enum PeopleByIdNumberAscendingComparator implements Comparison<Person> {
    COMPARATOR;

    @Override
    public int compare(Person o1, Person o2) {
        return Long.compare(o1.getIdNumber(), o2.getIdNumber());
    }
}
