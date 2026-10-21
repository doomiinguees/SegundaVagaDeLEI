package aed.complexityanalysis.algorithms;

import java.util.NoSuchElementException;

public class Tower {
    //Attributes
    private int[] baseDisks;
    private int topIndex;
    private char name;

    //Constructors

    public Tower(char name, int disksNumber) {
        baseDisks = new int[disksNumber + 1];
        baseDisks[0] = disksNumber * 3;
        topIndex = 0;
        this.name = name;
    }

    //Methods
    public void fill() {
        int length = baseDisks.length;
        for(int i = 1; i < length; i++) {
            baseDisks[i] = length - i;
        }
        topIndex = length - 1;
    }

    public void moveDisk(Tower target) {

        if(this.topIndex == 0) {
            throw new NoSuchElementException("source tower is empty");
        }
        if (target.topIndex == target.baseDisks.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Target tower is full");
        }

        if(this == target) {
            throw new IllegalArgumentException("Source and target are the same");
        }

        if(this.baseDisks[this.topIndex] >= target.baseDisks[target.topIndex]) {
            throw new IllegalArgumentException("Target top disk can't support the source disk");
        }

        target.baseDisks[target.topIndex + 1] = this.baseDisks[topIndex];
        target.topIndex++;

        this.baseDisks[this.topIndex] = 0;
        this.topIndex--;

    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
