package aed.utils;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class Array {
    public static <T> void display(int limit, T... elements) {
        String closingSymbols;
        int size;

        if (elements.length == 0) {
            System.out.println("[]");
            return;
        }

        if (elements.length <= limit) {
            size = elements.length;
            closingSymbols = "]";
        } else {
            size = limit;
            closingSymbols = "...";
        }

        System.out.print("[");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(elements[i] + ", ");
        }
        System.out.println(elements[size - 1] + closingSymbols);
    }
}