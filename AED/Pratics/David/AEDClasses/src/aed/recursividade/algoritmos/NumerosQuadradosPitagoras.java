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
public class NumerosQuadradosPitagoras {
    public static long execute(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("q(" + n + ")= argumento inválido : deve ser >= 1");
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
