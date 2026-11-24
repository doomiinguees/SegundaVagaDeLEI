package aed.recursion.algorithms;

public class Factorial {
    public static long execute(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial(" + n + ") -> Invalid argument : S    hould be >= 0");
        }
        return executeRecursive(n);
    }

    private static long executeRecursive(int n) {
        if (n < 2) {
            return 1;
        }
        return n * executeRecursive(n - 1);
    }

    public static void display(int n) {
        try {
            System.out.println("Factorial(" + n + ") = " + execute(n));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
