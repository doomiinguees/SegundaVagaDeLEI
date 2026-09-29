package aed.recursividade.algoritmos;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class Fatorial {
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
