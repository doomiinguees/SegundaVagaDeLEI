package aed.complexityanalysis.algorithms;

public class TowersOfHanoi_v2 {

    private static long counter;

    public static void execute(int diskCount) {
        counter = 0;

        if (diskCount < 0) {
            throw new IllegalArgumentException("Disk number cannot be negative"
            );
        }

        Tower towerA = new Tower('A', diskCount);
        Tower towerB = new Tower('B', diskCount);
        Tower towerC = new Tower('C', diskCount);

        towerA.fill();

        recursiveExecute(diskCount, towerA, towerC, towerB);
    }

    private static void recursiveExecute(
            int diskCount, Tower source, Tower target, Tower aux) {

        if (diskCount == 1) {
            System.out.println("\t" + source.toString() + " -> " + target.toString());
            source.moveDisk(target);
            return;
        }


        recursiveExecute(diskCount - 1, source, aux, target);
        System.out.println("\t" + source.toString() + " -> " + target.toString());
        source.moveDisk(target);
        counter++;

        recursiveExecute(diskCount - 1, aux, target, source);
    }

    public static void display(int diskCount) {
        if (diskCount != 0) {
            System.out.println("\nHanoiTower game level " + diskCount);
            execute(diskCount);
            System.out.println("Moves Number: " + counter);
        }
    }
}
