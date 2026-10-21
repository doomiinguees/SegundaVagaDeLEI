package aed.collections.iterable.associative.structures;

import aed.Comparison;
import aed.collections.iterable.BidirectionalIterableIterator;
import aed.collections.iterable.associative.AssociativeIterableCollection;

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
public class OrderedHashTable<C, V> implements AssociativeIterableCollection<C, V> {
    private static final long serialVersionUID = 1L;

    protected SentinelNode base;
    protected Comparison<C> comparator;
    protected HashTableWithOptimizedRehash nodeByKey;

    public OrderedHashTable(Comparison<C> cp, int size) {
        comparator = cp;
        nodeByKey = new HashTableWithOptimizedRehash(size);
        new SentinelNode();
    }

    public void removeAll() {
        base.nextNode = base.previous = base;
        nodeByKey.removeAll();
    }

    private Node getNodeByOrder(C key) {
        Node currentNode = nodeByKey.get(key);
        if (currentNode != null) {
            return currentNode;
        }

        if (nodeByKey.getElementCount() == 0 ||
                base.previous.compareElement(key) < 0) {
            return base;
        }

        currentNode = base.nextNode;
        while (currentNode.compareElement(key) < 0) {
            currentNode = currentNode.nextNode;
        }

        return currentNode;
    }

    private Node getNodeByIndex(int index) {
        int elementCount = nodeByKey.getElementCount();
        if (index < 0 || index >= elementCount) {
            throw new IndexOutOfBoundsException();
        }

        Node current;
        if (index < elementCount / 2) {
            current = base.nextNode;

            while (index-- > 0) {
                current = current.nextNode;
            }
        } else {
            current = base.previous;

            while (++index < elementCount) {
                current = current.previous;
            }
        }

        return current;
    }


    @Override
    public void insert(C key, V value) {
        new ElementNode(key, value);
    }


    @Override
    public V remove(C key) {
        Node node = nodeByKey.remove(key);
        return node != null ? node.remove() : null;
    }


    public V removeByIndex(int index) {
        return nodeByKey.remove(getNodeByIndex(index).element.getKey()).remove();
    }

    @Override
    public V get(C key) {
        Node node = nodeByKey.get(key);
        return node != null ? node.element.getValue() : null;
    }

    public V getByIndex(int index) {
        return getNodeByIndex(index).element.getValue();
    }

    public BidirectionalIterableIterator<Association<C, V>> get(C startKey, C endKey) {
        return new CustomIterator(startKey, endKey);
    }

    public BidirectionalIterableIterator<C> getKeys(C startKey, C endKey) {
        return new KeyIterator(startKey, endKey);
    }

    public BidirectionalIterableIterator<V> getValues(C startKey, C endKey) {
        return new ValueIterator(startKey, endKey);
    }

    @Override
    public int getElementCount() {
        return nodeByKey.getElementCount();
    }

    @Override
    public boolean contains(C key) {
        return nodeByKey.contains(key);
    }

    public boolean containsOrder(C key) {
        return contains(key);
    }

    public boolean containsReference(C key) {
        return contains(key);
    }

    public Comparison<C> getComparator() {
        return comparator;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Hash table ordered by ");
        s.append(comparator.getClass().getSimpleName()).append(" = {\n");
        Node aux = base.nextNode;
        while (aux != base) {
            s.append(aux.element).append("\n");
            aux = aux.nextNode;
        }
        s.append("}\n");
        return s.toString();
    }

    @Override
    public BidirectionalIterableIterator<Association<C, V>> getIterator() {
        return new CustomIterator();
    }

    @Override
    public BidirectionalIterableIterator<C> getKeyIterator() {
        return new KeyIterator();
    }

    @Override
    public BidirectionalIterableIterator<V> getValueIterator() {
        return new ValueIterator();
    }

    private class HashTableWithOptimizedRehash extends HashTable<C, Node> {

        public HashTableWithOptimizedRehash(int size) {
            super(size);
        }

        @Override
        protected void reHash() {
            table = new Entry[nextPrime(table.length * 2)];
            elementCount = inactiveElementCount = 0;
            Node node = base.nextNode;
            while (node != base) {
                insert(node.element.getKey(), node);
                node = node.nextNode;
            }
        }
    }


    public abstract class Node implements Serializable {
        private static final long serialVersionUID = 1L;
        protected Association<C, V> element;
        protected Node previous;
        protected Node nextNode;

        protected abstract V remove();

        protected abstract int compareElement(C key);
    }

    protected class SentinelNode extends Node {
        protected SentinelNode() {
            element = null;
            nextNode = previous = base = this;
        }

        protected V remove() {
            return null;
        }

        protected int compareElement(C key) {
            return 1;
        }
    }

    protected class ElementNode extends Node {
        protected ElementNode(C key, V value) {
            if (key == null || value == null) {
                throw new IllegalArgumentException();
            }
            if (nodeByKey.contains(key)) {
                throw new IllegalArgumentException("Key " + key + " duplicated");
            }
            Node nextLink = getNodeByOrder(key);
            element = new Association<>(key, value);
            previous = nextLink.previous;
            nextNode = nextLink;
            previous.nextNode = nextNode.previous = this;
            nodeByKey.insert(key, this);
        }

        protected V remove() {
            nextNode.previous = previous;
            previous.nextNode = nextNode;
            V value = element.getValue();
            element = null;
            return value;
        }

        protected int compareElement(C key) {
            return comparator.compare(element.getKey(), key);
        }
    }

    public class CustomIterator implements BidirectionalIterableIterator<Association<C, V>> {
        protected Node beforeFirst;
        protected Node previous;
        protected Node current;
        protected Node afterLast;

        protected CustomIterator() {
            afterLast = beforeFirst = base;
            reset();
        }

        protected CustomIterator(C startKey, C endKey) {
            if (comparator.compare(startKey, endKey) > 0) {
                throw new IllegalArgumentException();
            }
            beforeFirst = getNodeByOrder(startKey).previous;
            if (base.previous.compareElement(endKey) <= 0) {
                afterLast = base;
            } else {
                Node node = nodeByKey.get(endKey);
                if (node != null) {
                    afterLast = node.nextNode;
                } else {
                    afterLast = beforeFirst.nextNode;

                    while (afterLast.compareElement(endKey) <= 0) {
                        afterLast = afterLast.nextNode;
                    }
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
        public Association<C, V> current() {
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
        public Association<C, V> advance() {
            if (!hasNext()) {
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
        public Association<C, V> retreat() {
            if (!canRetreat()) {
                throw new NoSuchElementException();
            }

            current = previous;
            previous = previous.previous;
            return current.element;
        }
    }

    protected abstract class PartialIterator<KeyOrValue> implements BidirectionalIterableIterator<KeyOrValue> {

        protected BidirectionalIterableIterator<Association<C, V>> iterator;

        public PartialIterator() {
            iterator = new CustomIterator();
        }

        public PartialIterator(C startKey, C endKey) {
            iterator = new CustomIterator(startKey, endKey);
        }

        @Override
        public void reset() {
            iterator.reset();
        }

        @Override
        public boolean canAdvance() {
            return iterator.canAdvance();
        }

        public abstract KeyOrValue getKeyOrValue(Association<C, V> association);

        @Override
        public KeyOrValue advance() {
            return getKeyOrValue(iterator.advance());
        }

        @Override
        public KeyOrValue current() {
            return getKeyOrValue(iterator.current());
        }

        @Override
        public boolean canRetreat() {
            return iterator.canRetreat();
        }

        @Override
        public KeyOrValue retreat() {
            return getKeyOrValue(iterator.retreat());
        }
    }

    protected class KeyIterator extends PartialIterator<C> {
        public KeyIterator() {
        }

        public KeyIterator(C startKey, C endKey) {
            super(startKey, endKey);
        }

        @Override
        public C getKeyOrValue(Association<C, V> association) {
            return association.getKey();
        }
    }

    protected class ValueIterator extends PartialIterator<V> {
        public ValueIterator() {
        }

        public ValueIterator(C startKey, C endKey) {
            super(startKey, endKey);
        }

        @Override
        public V getKeyOrValue(Association<C, V> association) {
            return association.getValue();
        }
    }

}