package aed.colecoes.iteraveis.associativas.estruturas;

import aed.colecoes.iteraveis.IteradorIteravel;
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
public class TabelaHash<C, V> implements ColecaoIteravelAssociativa<C, V> {

    private static final long serialVersionUID = 1L;

    protected Entrada<C, V>[] table;  // Parametrização devido a vetor desse tipo
    protected int increment;
    protected int elementCount;
    protected int inactiveElementCount;
    private int prime;
    private int previousTableSize;

    public TabelaHash(int size) {
        table = new Entrada[nextPrime(size)];
        increment = 0;
        inactiveElementCount = elementCount = 0;
        calculatePreviousPrime();
    }

    public static int nextPrime(int n) {
        if (n < 2) {
            return 2;
        }
        if (n % 2 == 0) {
            ++n;
        }

        do {
            for (int i = 3; n % i != 0; i += 2) {
                if (i * i > n) {
                    return n;
                }
            }

            n += 2;
        } while (true);
    }

    private void calculatePreviousPrime() {
        int n = table.length;
        do {
            prime = TabelaHash.nextPrime(n /= 2);
        } while (prime >= table.length);
        previousTableSize = table.length;
    }

    private int getNextIndex(int i, int initial) {
        int index = (i + increment) % table.length;
        if (index == initial) {
            throw new RuntimeException("Sondagem circular de toda a tabela");
        }
        return index;
    }

    // Devolve o índice do primeiro null  ou  índice da chave  ou  o índice do primeiro inativo
    private int getTableIndex(C key) {
        int i = Math.abs(key.hashCode()) % table.length, inactive, initial = i;
        if (previousTableSize != table.length) {
            calculatePreviousPrime();
        }
        increment = prime - (Math.abs(key.hashCode()) % prime);

        do {
            if (table[i] == null) {
                return i; // Devolve o índice do primeiro null
            }

            if (table[i].getKey().equals(key)) {
                return i; // Devolve índice da chave
            }

            if (!table[i].isActive()) {
                inactive = i; // Encontrou o primeiro inativo no índice i
                break;
            }

            i = getNextIndex(i, initial);
        } while (true);

        do {
            i = getNextIndex(i, initial);

            if (table[i] == null) {
                return inactive; // Devolve o índice do primeiro inativo
            }

            if (table[i].getKey().equals(key)) {
                return i; // Devolve o índice da chave
            }
        } while (true);
    }

    @Override
    public void insert(C key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
        int i = getTableIndex(key);
        if (table[i] != null) {
            if (table[i].isActive()) { // implica tabela[i].getChave().equals(chave)
                throw new IllegalArgumentException("Chave " + key + " duplicada");
            }
            inactiveElementCount--;
        }
        table[i] = new Entrada(key, value);
        elementCount++;
        if (loadFactor() >= 0.5) {
            reHash();
        }
    }

    private float loadFactor() {
        return (elementCount + inactiveElementCount) / (float) table.length;
    }

    protected void reHash() {
        int length = nextPrime(table.length * 2);
        Entrada<C, V>[] oldTable = table;
        table = new Entrada[length];
        elementCount = inactiveElementCount = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null && oldTable[i].isActive()) {
                insert(oldTable[i].getKey(), oldTable[i].getValue());
            }
        }
    }

    @Override
    public V remove(C key) {
        int i = getTableIndex(key);
        if (table[i] == null || !table[i].isActive()) {
            return null;
        }
        table[i].deactivate();
        inactiveElementCount++;
        elementCount--;
        return table[i].getValue();
    }

    public void removeAll() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        elementCount = inactiveElementCount = 0;
    }

    @Override
    public V get(C key) {
        int i = getTableIndex(key);
        return table[i] != null && table[i].isActive() ? table[i].getValue() : null;
    }

    @Override
    public int getElementCount() {
        return elementCount;
    }

    @Override
    public boolean contains(C key) {
        return get(key) != null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Tabela de tamanho ");
        s.append(table.length);
        s.append(" = {\n");
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                s.append("Tabela[" + i + "]==> ");
                s.append(table[i]);
                s.append("\n");
            }
        }
        s.append("}\n");
        return s.toString();
    }

    @Override
    public IteradorIteravel<Associacao<C, V>> getIterator() {
        return new Iterador();
    }

    @Override
    public IteradorIteravel<C> getKeyIterator() {
        return new IteradorChaves();
    }

    @Override
    public IteradorIteravel<V> getValueIterator() {
        return new IteradorValores();
    }


    public class Entrada<C, V> implements Serializable {

        private static final long serialVersionUID = 1L;

        protected Associacao<C, V> association;
        protected boolean active;

        protected Entrada(C key, V value) {
            association = new Associacao<>(key, value);
            active = true;
        }

        public C getKey() {
            return association.getKey();
        }

        public V getValue() {
            return association.getValue();
        }

        public void setValue(V value) {
            association.setValue(value);
        }

        public Associacao<C, V> getAssociation() {
            return association;
        }

        public boolean isActive() {
            return active;
        }

        public void deactivate() {
            active = false;
        }

        @Override
        public String toString() {
            return (isActive() ? "" : "X ") + association;
        }
    }


    public class Iterador implements IteradorIteravel<Associacao<C, V>> {

        protected int current;
        protected int nextNode;

        protected Iterador() {
            reset();
        }

        @Override
        public void reset() {
            current = table.length;
            if (isEmpty()) {
                nextNode = current;
            } else {
                nextNode = -1;
                nextNode = nextActive();
            }
        }

        @Override
        public Associacao<C, V> current() {
            if (current == table.length) {
                throw new NoSuchElementException();
            }
            return table[current].getAssociation();
        }

        private int nextActive() {
            if (nextNode == table.length) {
                return nextNode;
            }
            while (++nextNode != table.length && (table[nextNode] == null || !table[nextNode].isActive())) {
                // Empty
            }
            return nextNode;
        }

        @Override
        public boolean canAdvance() {
            return nextNode != table.length;
        }

        @Override
        public Associacao<C, V> advance() {
            if (!canAdvance()) {
                throw new NoSuchElementException();
            }
            current = nextNode;
            nextNode = nextActive();
            return table[current].getAssociation();
        }
    }


    public abstract class IteradorParcial<KeyOrValue> implements IteradorIteravel<KeyOrValue> {

        protected IteradorIteravel<Associacao<C, V>> customIterator;

        protected IteradorParcial() {
            customIterator = getIterator();
        }

        @Override
        public void reset() {
            customIterator.reset();
        }

        @Override
        public boolean canAdvance() {
            return customIterator.canAdvance();
        }

        protected abstract KeyOrValue getKeyOrValue(Associacao<C, V> a);

        @Override
        public KeyOrValue advance() {
            return getKeyOrValue(customIterator.advance());
        }

        @Override
        public KeyOrValue current() {
            return getKeyOrValue(customIterator.current());
        }
    }


    public class IteradorChaves extends IteradorParcial<C> {

        @Override
        protected C getKeyOrValue(Associacao<C, V> a) {
            return a.getKey();
        }
    }


    public class IteradorValores extends IteradorParcial<V> {

        @Override
        protected V getKeyOrValue(Associacao<C, V> a) {
            return a.getValue();
        }
    }
}
