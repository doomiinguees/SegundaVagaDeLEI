package aed.collections.iterable.linear.unordered.structures;

import aed.collections.iterable.IterableCollection;
import aed.collections.iterable.BidirectionalIterableIterator;
import aed.collections.iterable.linear.unordered.UnorderedLinearIterableCollection;

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
public class UnorderedList<T> implements UnorderedLinearIterableCollection<T> {
    private static final long serialVersionUID = 1L;

    protected SentinelNode base;
    protected int elementCount;

    public UnorderedList() {
        new SentinelNode();
    }

    public UnorderedList(IterableCollection<T> collection) {
        this();
        for (T item : collection) {
            new ElementNode(item, base);
        }
        elementCount = collection.getElementCount();
    }

    public void transferToBeginning(UnorderedList<T> other) {
        // todo Ficha Prática 4 - 1

    }


    protected Node getNode(T item) {
        Node currentNode = base.nextNode;
        while (!currentNode.isElementEqual(item)) {
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    protected Node getNodeByReference(T item) {
        Node currentNode = base.nextNode;
        while (!currentNode.isElementEqualByReference(item)) {
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
    public void insertAtBeginning(T item) {
        new ElementNode(item, base.nextNode);
    }

    @Override
    public void insertAtEnd(T item) {
        new ElementNode(item, base);
    }

    @Override
    public void insertByIndex(int index, T item) {
        if (index == elementCount) {
            new ElementNode(item, base);
        } else {
            new ElementNode(item, getNodeByIndex(index));
        }
    }

    @Override
    public T removeFromBeginning() {
        return base.nextNode.remove();
    }

    @Override
    public T removeFromEnd() {
        return base.previous.remove();
    }

    @Override
    public T remove(T item) {
        return getNode(item).remove();
    }

    @Override
    public T removeByReference(T item) {
        return getNodeByReference(item).remove();
    }

    @Override
    public T removeByIndex(int index) {
        return getNodeByIndex(index).remove();
    }

    @Override
    public T getByIndex(int index) {
        return getNodeByIndex(index).element;
    }

    @Override
    public boolean contains(T item) {
        return getNode(item) != base;
    }

    @Override
    public boolean containsReference(T item) {
        return getNodeByReference(item) != base;
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
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Unordered List = {\n");
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
            return true;
        }

        protected boolean isElementEqualByReference(T item) {
            return true;
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
    }


    public class CustomIterator implements BidirectionalIterableIterator<T> {
        protected Node current;

        protected CustomIterator() {
            reset();
        }

        @Override
        public void reset() {
            current = base;
        }

        @Override
        public T current() {
            if (current == base) {
                throw new NoSuchElementException();
            }
            return current.element;
        }

        @Override
        public boolean canAdvance() {
            return current.nextNode != base;
        }

        @Override
        public T advance() {
            if (!canAdvance()) {
                throw new NoSuchElementException();
            }
            current = current.nextNode;
            return current.element;
        }

        @Override
        public boolean canRetreat() {
            return current.previous != base;
        }

        @Override
        public T retreat() {
            if (!canRetreat()) {
                throw new NoSuchElementException();
            }
            current = current.previous;
            return current.element;
        }
    }
}
