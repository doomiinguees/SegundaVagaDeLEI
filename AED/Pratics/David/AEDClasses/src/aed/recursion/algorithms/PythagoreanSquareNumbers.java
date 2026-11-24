package aed.recursion.algorithms;

public class PythagoreanSquareNumbers {
    public static long execute(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("q(" + n + ") = invalid argument: must be >= 1");
        }
        return executeRecursive(n);
    }

    private static long executeRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return executeRecursive(n - 1) + 2 * n - 1;
    }

    public static void display(int n) {
        try {
            System.out.println("q(" + n + ") = " + execute(n));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
