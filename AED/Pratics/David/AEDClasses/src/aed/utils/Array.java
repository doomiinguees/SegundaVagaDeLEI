package aed.utils;

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