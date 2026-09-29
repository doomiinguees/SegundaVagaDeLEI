package aed.modelo.contactos;

import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;

public enum GestorContactos {
    INSTANCE;

    GestorContactos() {
    }

    public void insert(Contacto contact) {
    }

    public Contacto remove(Contacto contact) {
        return null;
    }

    public IteradorIteravelDuplo<Contacto> remove(Data birthDate) {
        return null;
    }

    public IteradorIteravelDuplo<Contacto> get(Data birthDate) {
        return null;
    }

    public IteradorIteravelDuplo<Contacto> get(Data startBirthDate, Data endBirthDate) {
        // todo Apenas na Ficha Prática 6
        return null;
    }

    public Contacto get(long phoneNumber) {
        // todo Apenas na Ficha Prática 6
        return null;
    }


    public Contacto remove(long phoneNumber) {
        // todo Apenas na Ficha Prática 6
        return null;
    }

    public IteradorIteravelDuplo<Contacto> get(Data birthDate, String address) {
        // todo Apenas na Ficha Prática 6
        return null;
    }

    public IteradorIteravel<String> getAddresses(Data birthDate) {
        // todo Apenas na Ficha Prática 6
        return null;
    }
}
