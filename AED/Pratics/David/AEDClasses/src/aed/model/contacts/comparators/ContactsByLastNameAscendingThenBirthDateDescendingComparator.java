package aed.model.contacts.comparators;

import aed.Comparison;
import aed.model.contacts.Contact;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public enum ContactsByLastNameAscendingThenBirthDateDescendingComparator implements Comparison<Contact> {
    COMPARATOR;

    @Override
    public int compare(Contact o1, Contact o2) {
        int comparison = o1.getLastName().compareTo(o2.getLastName());
        if (comparison != 0) {
            return comparison;
        }

        comparison = Integer.compare(o2.getBirthDate().getYear(), o1.getBirthDate().getYear());
        if (comparison != 0) {
            return comparison;
        }

        comparison = Integer.compare(o2.getBirthDate().getMonth(), o1.getBirthDate().getMonth());
        if (comparison != 0) {
            return comparison;
        }

        return Integer.compare(o2.getBirthDate().getDay(), o1.getBirthDate().getDay());
    }
}
