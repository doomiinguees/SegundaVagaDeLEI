package aed.colecoes.iteraveis.lineares.ordenadas.utilizacao;

import aed.modelo.contactos.Contacto;
import aed.modelo.contactos.Data;
import aed.modelo.contactos.GestorContactos;

public class MainPraticaGestorContactos {

    public static void main(String[] args) {

        Contacto[] originalContacts = new Contacto[]{
                new Contacto("Ana", "Silva", 950000000, "Rua de Leiria", new Data(1, 10, 1990)),
                new Contacto("Ana", "Rita", 990000000, "Travessa 25 de Abril", new Data(15, 6, 2000)),
                new Contacto("Hugo", "Santos", 971234567, "Avenida 1º de Maio", new Data(18, 3, 1994)),
                new Contacto("Teresa", "Silva", 950000001, "Rua de Leiria", new Data(2, 10, 1990)),
                new Contacto("Eça", "Queiroz", 100000000, "Praça do Almada", new Data(25, 11, 1845)),
                new Contacto("Ana", "Queiroz", 100000000, "Praça do Almada", new Data(15, 6, 2000)),
                new Contacto("Teresa", "Santos", 100050000, "Praça do Almada", new Data(18, 3, 1994)),
                new Contacto("Teresa", "Santos", 100100000, "Rua de Leiria", new Data(18, 3, 1994)),
        };

        for (Contacto contact : originalContacts) {
            GestorContactos.INSTANCE.insert(contact);
        }

        Data date1 = new Data(18, 3, 1994);
        System.out.println("Contactos da data: " + date1);
        for (Contacto contact : GestorContactos.INSTANCE.get(date1)) {
            System.out.println(contact);
        }

        Data date2 = new Data(15, 6, 2000);
        System.out.println("Contactos entre a data: " + date1 + " e a data: " + date2);
        for (Contacto contact : GestorContactos.INSTANCE.get(date1, date2)) {
            System.out.println(contact);
        }

        Data date3 = new Data(10, 1, 2000);
        System.out.println("Contactos da data: " + date3);
        for (Contacto contact : GestorContactos.INSTANCE.get(date3)) {
            System.out.println(contact);
        }

        Data date4 = new Data(11, 2, 2000);
        System.out.println("Contactos entre a data: " + date3 + " e a data: " + date4);
        for (Contacto contact : GestorContactos.INSTANCE.get(date3, date4)) {
            System.out.println(contact);
        }

        Data date5 = new Data(25, 11, 1845);
        System.out.println("Contactos entre a data: " + date5 + " e a data: " + date2);
        for (Contacto contact : GestorContactos.INSTANCE.get(date5, date2)) {
            System.out.println(contact);
        }

        GestorContactos.INSTANCE.remove(date1);
        System.out.println("Contactos da data após remoção: " + date1);
        for (Contacto contact : GestorContactos.INSTANCE.get(date1)) {
            System.out.println(contact);
        }

        Contacto contactToRemove = originalContacts[1];
        System.out.println("Contactos da data: " + contactToRemove.getBirthDate());
        for (Contacto contact : GestorContactos.INSTANCE.get(contactToRemove.getBirthDate())) {
            System.out.println(contact);
        }

        GestorContactos.INSTANCE.remove(contactToRemove);
        System.out.println("Contactos da data: " + contactToRemove.getBirthDate() + " após remoção do " + contactToRemove);
        for (Contacto contact : GestorContactos.INSTANCE.get(contactToRemove.getBirthDate())) {
            System.out.println(contact);
        }
    }
}
