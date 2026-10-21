package aed.collections.iterable.linear.ordered.examples;

import aed.model.contacts.Contact;
import aed.model.contacts.Date;
import aed.model.contacts.ContactManager;

public class PracticeMainContactManager {

    public static void main(String[] args) {

        Contact[] originalContacts = new Contact[]{
                new Contact("Ana", "Silva", 950000000, "Rua de Leiria", new Date(1, 10, 1990)),
                new Contact("Ana", "Rita", 990000000, "Travessa 25 de Abril", new Date(15, 6, 2000)),
                new Contact("Hugo", "Santos", 971234567, "Avenida 1º de Maio", new Date(18, 3, 1994)),
                new Contact("Teresa", "Silva", 950000001, "Rua de Leiria", new Date(2, 10, 1990)),
                new Contact("Eça", "Queiroz", 100000000, "Praça do Almada", new Date(25, 11, 1845)),
                new Contact("Ana", "Queiroz", 100000000, "Praça do Almada", new Date(15, 6, 2000)),
                new Contact("Teresa", "Santos", 100050000, "Praça do Almada", new Date(18, 3, 1994)),
                new Contact("Teresa", "Santos", 100100000, "Rua de Leiria", new Date(18, 3, 1994)),
        };

        for (Contact contact : originalContacts) {
            ContactManager.INSTANCE.insert(contact);
        }

        Date date1 = new Date(18, 3, 1994);
        System.out.println("Contacts for date: " + date1);
        for (Contact contact : ContactManager.INSTANCE.get(date1)) {
            System.out.println(contact);
        }

        Date date2 = new Date(15, 6, 2000);
        System.out.println("Contacts between date: " + date1 + " and date: " + date2);
        for (Contact contact : ContactManager.INSTANCE.get(date1, date2)) {
            System.out.println(contact);
        }

        Date date3 = new Date(10, 1, 2000);
        System.out.println("Contacts for date: " + date3);
        for (Contact contact : ContactManager.INSTANCE.get(date3)) {
            System.out.println(contact);
        }

        Date date4 = new Date(11, 2, 2000);
        System.out.println("Contacts between date: " + date3 + " and date: " + date4);
        for (Contact contact : ContactManager.INSTANCE.get(date3, date4)) {
            System.out.println(contact);
        }

        Date date5 = new Date(25, 11, 1845);
        System.out.println("Contacts between date: " + date5 + " and date: " + date2);
        for (Contact contact : ContactManager.INSTANCE.get(date5, date2)) {
            System.out.println(contact);
        }

        ContactManager.INSTANCE.remove(date1);
        System.out.println("Contacts for date after removal: " + date1);
        for (Contact contact : ContactManager.INSTANCE.get(date1)) {
            System.out.println(contact);
        }

        Contact contactToRemove = originalContacts[1];
        System.out.println("Contacts for date: " + contactToRemove.getBirthDate());
        for (Contact contact : ContactManager.INSTANCE.get(contactToRemove.getBirthDate())) {
            System.out.println(contact);
        }

        ContactManager.INSTANCE.remove(contactToRemove);
        System.out.println("Contacts for date: " + contactToRemove.getBirthDate() + " after removing " + contactToRemove);
        for (Contact contact : ContactManager.INSTANCE.get(contactToRemove.getBirthDate())) {
            System.out.println(contact);
        }
    }
}
