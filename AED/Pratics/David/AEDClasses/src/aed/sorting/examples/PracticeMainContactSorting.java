package aed.sorting.examples;

import aed.model.contacts.Contact;
import aed.model.contacts.Date;
import aed.model.contacts.comparators.ContactsByPhoneNumberDescendingComparator;
import aed.model.contacts.comparators.ContactsByLastNameAscendingThenBirthDateDescendingComparator;
import aed.sorting.algorithms.SortingAlgorithm;
import aed.sorting.algorithms.InsertionSort;

import java.util.Arrays;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class PracticeMainContactSorting {

    public static void main(String[] args) {

        Contact[] originalContacts = new Contact[]{
                new Contact("Ana", "Silva", 950000000, "Rua de Leiria", new Date(1, 10, 1990)),
                new Contact("Ana", "Rita", 990000000, "Travessa 25 de Abril", new Date(15, 6, 2000)),
                new Contact("Hugo", "Santos", 971234567, "Avenida 1º de Maio", new Date(18, 3, 1994)),
                new Contact("Teresa", "Silva", 950000001, "Rua de Leiria", new Date(2, 10, 1990)),
                new Contact("Eça", "Queiroz", 100000000, "Praça do Almada", new Date(25, 11, 1845))
        };

        SortingAlgorithm<Contact> algorithm1 =
                new InsertionSort<>(ContactsByPhoneNumberDescendingComparator.COMPARATOR);
        SortingAlgorithm<Contact> algorithm2 =
                new InsertionSort<>(ContactsByLastNameAscendingThenBirthDateDescendingComparator.COMPARATOR);

        Contact[] copy1 = Arrays.copyOf(originalContacts, originalContacts.length);
        Contact[] copy2 = Arrays.copyOf(originalContacts, originalContacts.length);

        algorithm1.display(20, copy1);
        algorithm2.display(20, copy2);
    }
}
