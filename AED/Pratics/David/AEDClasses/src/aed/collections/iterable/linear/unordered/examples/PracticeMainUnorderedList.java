package aed.collections.iterable.linear.unordered.examples;

import aed.collections.iterable.BidirectionalIterableIterator;
import aed.collections.iterable.linear.unordered.structures.UnorderedList;

public class PracticeMainUnorderedList {
    public static void main(String[] args) {
        UnorderedList<Integer> list, other;

        System.out.println("***************** TRANSFER TO BEGINNING *****************");
        System.out.println("=======================================");
        System.out.println("BOTH LISTS WITH ELEMENTS");
        list = new UnorderedList<>();
        list.insert(3);
        list.insert(1);
        list.insert(5);
        other = new UnorderedList<>();
        other.insert(4);
        other.insert(2);
        transferAndDisplay(list, other);

        System.out.println("=======================================");
        System.out.println("LIST WITH ELEMENTS AND OTHER EMPTY");
        list = new UnorderedList<>();
        list.insert(3);
        list.insert(1);
        list.insert(5);
        other = new UnorderedList<>();
        transferAndDisplay(list, other);

        System.out.println("=======================================");
        System.out.println("EMPTY LIST AND OTHER WITH ELEMENTS");
        list = new UnorderedList<>();
        other = new UnorderedList<>();
        other.insert(3);
        other.insert(1);
        other.insert(5);
        transferAndDisplay(list, other);

        System.out.println();
        System.out.println("***************** REMOVE LAST N *****************");
        System.out.println("=======================================");
        System.out.println("n <= elementCount");
        list = new UnorderedList<>();
        list.insert(4);
        list.insert(2);
        list.insert(3);
        list.insert(1);
        list.insert(5);
        removeAndDisplay(list, 2);
        System.out.println("=======================================");
        System.out.println("n > elementCount");
        list = new UnorderedList<>();
        list.insert(4);
        list.insert(2);
        removeAndDisplay(list, 5);
        System.out.println("=======================================");
        System.out.println("n == 0");
        list = new UnorderedList<>();
        list.insert(4);
        list.insert(2);
        list.insert(3);
        list.insert(1);
        list.insert(5);
        removeAndDisplay(list, 0);
        System.out.println("=======================================");
        System.out.println("elementCount = 0");
        list = new UnorderedList<>();
        removeAndDisplay(list, 1);

    }

    private static void transferAndDisplay(UnorderedList<Integer> list, UnorderedList<Integer> other) {
        System.out.println("Lists before transferring");
        System.out.println("LIST => " + list);
        System.out.println("OTHER => " + other);

        list.transferToBeginning(other);
        System.out.println("Lists after transferring");
        System.out.println("LIST => " + list);
        System.out.println("OTHER => " + other);

        System.out.println("LIST elements in reverse order");
        BidirectionalIterableIterator<Integer> customIterator = list.getIterator();
        while (customIterator.canRetreat()) {
            System.out.println(customIterator.retreat());
        }
    }

    private static void removeAndDisplay(UnorderedList<Integer> list, int n) {
        System.out.println("List before removing " + n + " elements");
        System.out.println("LIST => " + list);

        UnorderedList<Integer> resultValue = list.removeFromEnd(n);
        System.out.println("Lists after removing " + n + " elements");
        System.out.println("LIST => " + list);
        System.out.println("RESULT => " + resultValue);

        System.out.println("LIST elements in reverse order");
        BidirectionalIterableIterator<Integer> customIterator = list.getIterator();
        while (customIterator.canRetreat()) {
            System.out.println(customIterator.retreat());
        }
    }
}
