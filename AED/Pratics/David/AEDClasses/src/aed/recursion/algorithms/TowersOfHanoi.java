package aed.recursion.algorithms;

public class TowersOfHanoi {

    private static long counter;

    public static void execute(int diskCount) {
        counter = 0;

        if (diskCount < 0) {
            throw new IllegalArgumentException("Disk number cannot be negative"
            );
        }

        recursiveExecute(diskCount, 'A', 'C', 'B');
    }

    private static void recursiveExecute(
            int diskCount, char origin, char destiny, char aux) {

        if (diskCount == 0) {
            return;
        }

        recursiveExecute(diskCount - 1, origin, aux, destiny);

        System.out.println("\t" + origin + " -> " + destiny);
        counter++;

        recursiveExecute(diskCount - 1, aux, destiny, origin);
    }

    public static void display(int diskCount) {
        if (diskCount != 0) {
            System.out.println("\nHanoiTower game level " + diskCount);
            execute(diskCount);
            System.out.println("Moves Number: " + counter);
        }
    }
}
