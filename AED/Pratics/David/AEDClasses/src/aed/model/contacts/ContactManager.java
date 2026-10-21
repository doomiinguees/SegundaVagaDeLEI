package aed.model.contacts;

import aed.collections.iterable.IterableIterator;
import aed.collections.iterable.BidirectionalIterableIterator;

public enum ContactManager {
    INSTANCE;

    ContactManager() {
    }

    public void insert(Contact contact) {
    }

    public Contact remove(Contact contact) {
        return null;
    }

    public BidirectionalIterableIterator<Contact> remove(Date birthDate) {
        return null;
    }

    public BidirectionalIterableIterator<Contact> get(Date birthDate) {
        return null;
    }

    public BidirectionalIterableIterator<Contact> get(Date startBirthDate, Date endBirthDate) {
        // todo Apenas na Ficha Prática 6
        return null;
    }

    public Contact get(long phoneNumber) {
        // todo Apenas na Ficha Prática 6
        return null;
    }


    public Contact remove(long phoneNumber) {
        // todo Apenas na Ficha Prática 6
        return null;
    }

    public BidirectionalIterableIterator<Contact> get(Date birthDate, String address) {
        // todo Apenas na Ficha Prática 6
        return null;
    }

    public IterableIterator<String> getAddresses(Date birthDate) {
        // todo Apenas na Ficha Prática 6
        return null;
    }
}
