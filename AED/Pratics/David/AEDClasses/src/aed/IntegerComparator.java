package aed;

public enum IntegerComparator implements Comparison<Integer> {
    COMPARATOR;

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }

}
