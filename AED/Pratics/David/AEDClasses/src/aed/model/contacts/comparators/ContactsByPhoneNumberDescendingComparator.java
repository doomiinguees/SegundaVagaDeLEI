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
public enum ContactsByPhoneNumberDescendingComparator implements Comparison<Contact> {
    COMPARATOR;

    @Override
    public int compare(Contact c1, Contact c2) {
        //todo Ficha Prática 3 - 2.a)
        return 0;
    }
}
