package aed.model.contacts.comparators;

import aed.Comparison;
import aed.model.contacts.Contact;

public enum ContactsByPhoneNumberDescendingComparator implements Comparison<Contact> {
    COMPARATOR;

    @Override
    public int compare(Contact c1, Contact c2) {
        return Long.compare(c2.getPhoneNumber(), c1.getPhoneNumber());
    }
}
