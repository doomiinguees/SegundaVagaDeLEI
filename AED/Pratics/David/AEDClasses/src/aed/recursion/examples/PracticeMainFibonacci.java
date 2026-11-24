package aed.recursion.examples;

import aed.recursion.algorithms.Fibonacci;

public class PracticeMainFibonacci {

    public static void main(String[] args) {
        int[] ns = {5, 0, -10, 40, 45};
        for (int n : ns) {
            Fibonacci.display(n);
        }


       /* for (int i = 5; i < 31; i += 5) {
            Fibonacci.display(i);
        }*/
    }
}
