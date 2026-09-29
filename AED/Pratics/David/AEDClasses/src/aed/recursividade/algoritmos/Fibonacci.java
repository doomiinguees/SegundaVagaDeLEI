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
public class Fibonacci {

    public static long execute(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci(" + n + ")-> Argument should be positive");
        }
        return recursiveExecute(n);
    }

    public static long recursiveExecute(int n){
        if (n < 2) {
            return n;
        }

        return recursiveExecute(n - 2) + recursiveExecute(n - 1);
    }

    public static void display(int n) {
        try {
            System.out.println("Fibonacci(" + n + ") = " + execute(n));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}