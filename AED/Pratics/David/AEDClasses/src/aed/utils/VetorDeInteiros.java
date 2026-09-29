package aed.utils;

import java.util.Random;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class VetorDeInteiros {
    public static Integer[] createRandomInteger(int size, int minimum, int maximum, boolean randomSeed) {
        Integer[] resultValue = new Integer[size];
        Random rnd = randomSeed ? new Random() : new Random(1);
        for (int i = 0; i < size; i++) {
            resultValue[i] = rnd.nextInt(maximum - minimum + 1) + minimum;
        }
        return resultValue;
    }

    public static int[] createRandomInt(int size, int minimum, int maximum, boolean randomSeed) {
        int[] resultValue = new int[size];
        Random rnd = randomSeed ? new Random() : new Random(1);
        for (int i = 0; i < size; i++) {
            resultValue[i] = rnd.nextInt(maximum - minimum + 1) + minimum;
        }
        return resultValue;
    }

    public static int[] createRandomInt(int size, boolean randomSeed) {
        int[] resultValue = new int[size];
        Random rnd = randomSeed ? new Random() : new Random(1);
        for (int i = 0; i < size; i++) {
            resultValue[i] = rnd.nextInt();
        }
        return resultValue;
    }

    public static long maximum(long... values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Pelo menos um valor");
        }
        long maximum = values[0];
        for (int i = 1; i < values.length; i++) {
            if (maximum < values[i]) {
                maximum = values[i];
            }
        }
        return maximum;
    }

    public static void display(int limit, int... elements) {
        int size = elements.length < limit ? elements.length : limit;

        System.out.print("[");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(elements[i] + ", ");
        }
        System.out.print(elements[size - 1]);
        if (limit < elements.length) {
            System.out.println("...");
        } else {
            System.out.println("]");
        }
    }


}
