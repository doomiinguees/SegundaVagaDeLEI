package aed.colecoes.iteraveis.associativas.estruturas;

import aed.Comparacao;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.ColecaoIteravelAssociativa;

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
public class TabelaHashOrdenada<C, V> implements ColecaoIteravelAssociativa<C, V> {
    private static final long serialVersionUID = 1L;

    protected NoBase base;
    protected Comparacao<C> comparator;
    protected TabelaHashComReHashOtimizado nodeByKey;

    public TabelaHashOrdenada(Comparacao<C> cp, int size) {
        comparator = cp;
        nodeByKey = new TabelaHashComReHashOtimizado(size);
        new NoBase();
    }

    public void removeAll() {
        base.nextNode = base.previous = base;
        nodeByKey.removeAll();
    }

    private No getNodeByOrder(C key) {
        No currentNode = nodeByKey.get(key);
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

    private No getNodeByIndex(int index) {
        int elementCount = nodeByKey.getElementCount();
        if (index < 0 || index >= elementCount) {
            throw new IndexOutOfBoundsException();
        }

        No current;
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
        new NoComElemento(key, value);
    }


    @Override
    public V remove(C key) {
        No node = nodeByKey.remove(key);
        return node != null ? node.remove() : null;
    }


    public V removeByIndex(int index) {
        return nodeByKey.remove(getNodeByIndex(index).element.getKey()).remove();
    }

    @Override
    public V get(C key) {
        No node = nodeByKey.get(key);
        return node != null ? node.element.getValue() : null;
    }

    public V getByIndex(int index) {
        return getNodeByIndex(index).element.getValue();
    }

    public IteradorIteravelDuplo<Associacao<C, V>> get(C startKey, C endKey) {
        return new Iterador(startKey, endKey);
    }

    public IteradorIteravelDuplo<C> getKeys(C startKey, C endKey) {
        return new IteradorChaves(startKey, endKey);
    }

    public IteradorIteravelDuplo<V> getValues(C startKey, C endKey) {
        return new IteradorValores(startKey, endKey);
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

    public Comparacao<C> getComparator() {
        return comparator;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Tabela de Hash Ordenada por ");
        s.append(comparator.getClass().getSimpleName()).append(" = {\n");
        No aux = base.nextNode;
        while (aux != base) {
            s.append(aux.element).append("\n");
            aux = aux.nextNode;
        }
        s.append("}\n");
        return s.toString();
    }

    @Override
    public IteradorIteravelDuplo<Associacao<C, V>> getIterator() {
        return new Iterador();
    }

    @Override
    public IteradorIteravelDuplo<C> getKeyIterator() {
        return new IteradorChaves();
    }

    @Override
    public IteradorIteravelDuplo<V> getValueIterator() {
        return new IteradorValores();
    }

    private class TabelaHashComReHashOtimizado extends TabelaHash<C, No> {

        public TabelaHashComReHashOtimizado(int size) {
            super(size);
        }

        @Override
        protected void reHash() {
            table = new Entrada[nextPrime(table.length * 2)];
            elementCount = inactiveElementCount = 0;
            No node = base.nextNode;
            while (node != base) {
                insert(node.element.getKey(), node);
                node = node.nextNode;
            }
        }
    }


    public abstract class No implements Serializable {
        private static final long serialVersionUID = 1L;
        protected Associacao<C, V> element;
        protected No previous;
        protected No nextNode;

        protected abstract V remove();

        protected abstract int compareElement(C key);
    }

    protected class NoBase extends No {
        protected NoBase() {
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

    protected class NoComElemento extends No {
        protected NoComElemento(C key, V value) {
            if (key == null || value == null) {
                throw new IllegalArgumentException();
            }
            if (nodeByKey.contains(key)) {
                throw new IllegalArgumentException("Chave " + key + " duplicada");
            }
            No nextLink = getNodeByOrder(key);
            element = new Associacao<>(key, value);
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

    public class Iterador implements IteradorIteravelDuplo<Associacao<C, V>> {
        protected No beforeFirst;
        protected No previous;
        protected No current;
        protected No afterLast;

        protected Iterador() {
            afterLast = beforeFirst = base;
            reset();
        }

        protected Iterador(C startKey, C endKey) {
            if (comparator.compare(startKey, endKey) > 0) {
                throw new IllegalArgumentException();
            }
            beforeFirst = getNodeByOrder(startKey).previous;
            if (base.previous.compareElement(endKey) <= 0) {
                afterLast = base;
            } else {
                No node = nodeByKey.get(endKey);
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
        public Associacao<C, V> current() {
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
        public Associacao<C, V> advance() {
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
        public Associacao<C, V> retreat() {
            if (!canRetreat()) {
                throw new NoSuchElementException();
            }

            current = previous;
            previous = previous.previous;
            return current.element;
        }
    }

    protected abstract class IteradorParcial<KeyOrValue> implements IteradorIteravelDuplo<KeyOrValue> {

        protected IteradorIteravelDuplo<Associacao<C, V>> iterator;

        public IteradorParcial() {
            iterator = new Iterador();
        }

        public IteradorParcial(C startKey, C endKey) {
            iterator = new Iterador(startKey, endKey);
        }

        @Override
        public void reset() {
            iterator.reset();
        }

        @Override
        public boolean canAdvance() {
            return iterator.canAdvance();
        }

        public abstract KeyOrValue getKeyOrValue(Associacao<C, V> association);

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

    protected class IteradorChaves extends IteradorParcial<C> {
        public IteradorChaves() {
        }

        public IteradorChaves(C startKey, C endKey) {
            super(startKey, endKey);
        }

        @Override
        public C getKeyOrValue(Associacao<C, V> association) {
            return association.getKey();
        }
    }

    protected class IteradorValores extends IteradorParcial<V> {
        public IteradorValores() {
        }

        public IteradorValores(C startKey, C endKey) {
            super(startKey, endKey);
        }

        @Override
        public V getKeyOrValue(Associacao<C, V> association) {
            return association.getValue();
        }
    }

}