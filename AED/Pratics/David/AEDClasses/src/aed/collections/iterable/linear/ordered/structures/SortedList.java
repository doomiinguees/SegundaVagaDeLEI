package aed.collections.iterable.linear.ordered.structures;

import aed.Comparison;
import aed.collections.iterable.IterableCollection;
import aed.collections.iterable.BidirectionalIterableIterator;
import aed.collections.iterable.linear.ordered.OrderedLinearIterableCollection;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class SortedList<T> implements OrderedLinearIterableCollection<T> {
    private static final long serialVersionUID = 1L;

    protected SentinelNode base;
    protected Comparison<T> comparator;
    protected int elementCount;

    public SortedList(Comparison<T> cp) {
        comparator = cp;
        new SentinelNode();
    }

    public SortedList(Comparison<T> cp, OrderedLinearIterableCollection<T> collection) {
        this(cp);

        if (cp.equals(collection.getComparator())) {
            for (T item : collection) {
                new ElementNode(item, base);
            }

            elementCount = collection.getElementCount();
        } else {
            insertAll(collection);
        }
    }

    public SortedList(Comparison<T> cp, IterableCollection<T> collection) {
        this(cp);

        insertAll(collection);
    }

    protected Node getNodeByOrder(T item) {
        if (elementCount == 0 || base.previous.compareElement(item) < 0) {
            return base;
        }

        Node currentNode = base.nextNode;

        while (currentNode.compareElement(item) < 0) {
            currentNode = currentNode.nextNode;
        }

        return currentNode;
    }

    protected Node getNode(T item) {
        Node currentNode = getNodeByOrder(item);

        while (currentNode.compareElement(item) == 0 && !currentNode.isElementEqual(item)) {
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    protected Node getNodeByReference(T item) {
        Node currentNode = getNodeByOrder(item);

        while (currentNode.compareElement(item) == 0 && !currentNode.isElementEqualByReference(item)) {
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }


    protected Node getNodeByIndex(int index) {
        if (index < 0 || index >= elementCount) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode;
        if (index < elementCount / 2) {
            currentNode = base.nextNode;

            while (index-- > 0) {
                currentNode = currentNode.nextNode;
            }
        } else {
            currentNode = base.previous;

            while (++index < elementCount) {
                currentNode = currentNode.previous;
            }
        }

        return currentNode;
    }

    @Override
    public void insert(T item) {
        new ElementNode(item, getNodeByOrder(item));
    }

    private void insertAll(IterableCollection<T> collection) {
        for (T element : collection) {
            insert(element);
        }
    }

    @Override
    public T remove(T item) {
        Node node = getNode(item);
        return node.isElementEqual(item) ? node.remove() : null;
    }

    @Override
    public T removeByReference(T item) {
        Node node = getNodeByReference(item);
        return node.isElementEqualByReference(item) ? node.remove() : null;
    }

    @Override
    public T removeByIndex(int index) {
        return getNodeByIndex(index).remove();
    }

    @Override
    public T getByIndex(int index) {
        return getNodeByIndex(index).element;
    }


    // É necessário de modo a evitar downcast externo de IteradorIteravel a IteradorIteravelDuplo
    @Override
    public BidirectionalIterableIterator<T> get(T item) {
        return new CustomIterator(item, item);
    }

    @Override
    public BidirectionalIterableIterator<T> get(T startItem, T endItem) {
        return new CustomIterator(startItem, endItem);
    }

    @Override
    public boolean containsOrder(T item) {
        return getNodeByOrder(item).compareElement(item) == 0;
    }

    @Override
    public boolean contains(T item) {
        return getNode(item).isElementEqual(item);
    }

    @Override
    public boolean containsReference(T item) {
        return getNodeByReference(item).isElementEqualByReference(item);
    }

    @Override
    public int getElementCount() {
        return elementCount;
    }

    @Override
    public BidirectionalIterableIterator<T> getIterator() {
        return new CustomIterator();
    }

    @Override
    public Comparison<T> getComparator() {
        return comparator;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("List sorted by ");
        s.append(comparator.getClass().getSimpleName()).append(" = {\n");
        Node aux = base.nextNode;
        while (aux != base) {
            s.append(aux.element).append("\n");
            aux = aux.nextNode;
        }
        s.append("}\n");
        return s.toString();
    }

    public abstract class Node implements Serializable {
        private static final long serialVersionUID = 1L;

        protected T element;
        protected Node previous;
        protected Node nextNode;

        protected abstract T remove();

        protected abstract boolean isElementEqual(T item);

        protected abstract boolean isElementEqualByReference(T item);

        protected abstract int compareElement(T item);
    }

    public class SentinelNode extends Node {

        protected SentinelNode() {
            element = null;
            nextNode = previous = base = this;
            elementCount = 0;
        }

        protected T remove() {
            return null;
        }

        protected boolean isElementEqual(T item) {
            return false;
        }

        protected boolean isElementEqualByReference(T item) {
            return false;
        }

        protected int compareElement(T item) {
            return 1;
        }
    }

    public class ElementNode extends Node {

        protected ElementNode(T item, Node nextLink) {
            if (item == null) {
                throw new IllegalArgumentException();
            }
            element = item;
            previous = nextLink.previous;
            nextNode = nextLink;
            previous.nextNode = nextNode.previous = this;
            elementCount++;
        }

        protected T remove() {
            nextNode.previous = previous;
            previous.nextNode = nextNode;
            elementCount--;
            return element;
        }

        protected boolean isElementEqual(T item) {
            return element.equals(item);
        }

        protected boolean isElementEqualByReference(T item) {
            return element == item;
        }

        protected int compareElement(T item) {
            return comparator.compare(element, item);
        }
    }


    public class CustomIterator implements BidirectionalIterableIterator<T> {
        protected Node beforeFirst;
        protected Node previous;
        protected Node current;
        protected Node afterLast;

        protected CustomIterator() {
            afterLast = beforeFirst = base;
            reset();
        }

        protected CustomIterator(T startItem, T endItem) {
            if (comparator.compare(startItem, endItem) > 0) {
                throw new IllegalArgumentException();
            }

            beforeFirst = getNodeByOrder(startItem).previous;

            if (base.previous.compareElement(endItem) <= 0) {
                afterLast = base;
            } else {

                afterLast = beforeFirst.nextNode;

                while (afterLast.compareElement(endItem) <= 0) {
                    afterLast = afterLast.nextNode;
                }
            }

            reset();
        }

        @Override
        public void reset() {
            previous = afterLast.previous;
            current = beforeFirst;
        }

        @Override
        public T current() {
            if (current == beforeFirst) {
                throw new NoSuchElementException();
            }
            return current.element;
        }

        @Override
        public boolean canAdvance() {
            return current.nextNode != afterLast;
        }

        @Override
        public T advance() {
            if (!canAdvance()) {
                throw new NoSuchElementException();
            }

            previous = current;
            current = current.nextNode;
            return current.element;
        }

        @Override
        public boolean canRetreat() {
            return previous != beforeFirst;
        }

        @Override
        public T retreat() {
            if (!canRetreat()) {
                throw new NoSuchElementException();
            }

            current = previous;
            previous = previous.previous;

            return current.element;
        }
    }

}