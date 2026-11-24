package aed.recursion.examples;

import aed.recursion.algorithms.Factorial;

public class PracticeMainFactorial {

    public static void main(String[] args) {
        int[] ns = {5, 0, -5, 21};
        for (int n : ns) {
            Factorial.display(n);
        }

        /*for (int i = 1; i < 21; i++) {
            Fatorial.display(i);
        }*/
    }
}
