package aed.collections.iterable.linear.ordered.structures;

import aed.Comparison;
import aed.collections.iterable.IterableCollection;
import aed.collections.iterable.linear.ordered.OrderedLinearIterableCollection;

public class DistinctOrderSortedList<T> extends SortedList<T> {
    private static final long serialVersionUID = 1L;

    public DistinctOrderSortedList(Comparison<T> cp) {
        super(cp);
    }

    public DistinctOrderSortedList(Comparison<T> cp, OrderedLinearIterableCollection<T> collection) {
        super(cp, collection);
    }

    public DistinctOrderSortedList(Comparison<T> cp, IterableCollection<T> collection) {
        super(cp, collection);
    }

    @Override
    public void insert(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node node = getNodeByOrder(item);
        if (node.compareElement(item) == 0) {
            throw new IllegalArgumentException("Duplicate element!");
        }

        new ElementNode(item, node);
        elementCount++;
    }

    public T getDistinct(T item) {
        Node node = getNodeByOrder(item);
        return node.compareElement(item) == 0 ? node.element : null;
    }
}
