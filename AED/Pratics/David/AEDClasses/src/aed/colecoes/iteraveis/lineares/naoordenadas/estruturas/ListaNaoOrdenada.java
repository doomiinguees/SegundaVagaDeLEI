package aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import aed.colecoes.iteraveis.ColecaoIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;

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
public class ListaNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {
    private static final long serialVersionUID = 1L;

    protected NoBase base;
    protected int elementCount;

    public ListaNaoOrdenada() {
        new NoBase();
    }

    public ListaNaoOrdenada(ColecaoIteravel<T> collection) {
        this();
        for (T item : collection) {
            new NoComElemento(item, base);
        }
        elementCount = collection.getElementCount();
    }

    public void transferToBeginning(ListaNaoOrdenada<T> other) {
        // todo Ficha Prática 4 - 1
        if (other == this || other == null || other.isEmpty()) {
            return;
        }

        // Inicialização de variáveis auxiliares
        No otherBase = other.base;
        No otherEnd = otherBase.previous;
        No thisStart = base.nextNode;
        No otherStart = otherBase.nextNode;

        // ligar o fim da outra ao início desta (this)
        otherEnd.nextNode = thisStart;
        thisStart.previous = otherEnd;

        // colocar o início da outra como sendo o início desta
        base.nextNode = otherStart;
        otherStart.previous = base;

        // atualizar base da outra
        otherBase.previous = otherBase.nextNode = otherBase;

        // atualizar número de elementos
        elementCount += other.elementCount;
        other.elementCount = 0;
    }

    public ListaNaoOrdenada<T> removeFromEnd(int n) {
        // todo Ficha Prática 4 - 2
        ListaNaoOrdenada<T> resultValue = new ListaNaoOrdenada<>();
        if (n <= 0 || elementCount == 0) {
            return resultValue;
        }
        if (n > elementCount) {
            n = elementCount;
        }

        // Inicialização de variáveis auxiliares
        No thisEnd = elementCount == n ? base : getNodeByIndex(elementCount - n - 1);
        No resultStart = thisEnd.nextNode;
        No resultEnd = base.previous;
        NoBase resultBase = resultValue.base;

        // atualizar esta
        thisEnd.nextNode = base;
        base.previous = thisEnd;
        elementCount -= n;

        // atualizar resultado
        resultBase.nextNode = resultStart;
        resultBase.previous = resultEnd;
        resultEnd.nextNode = resultStart.previous = resultBase;
        resultValue.elementCount = n;

        return resultValue;
    }


    protected No getNode(T item) {
        No currentNode = base.nextNode;
        while (!currentNode.isElementEqual(item)) {
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    protected No getNodeByReference(T item) {
        No currentNode = base.nextNode;
        while (!currentNode.isElementEqualByReference(item)) {
            currentNode = currentNode.nextNode;
        }

        return currentNode;
    }

    protected No getNodeByIndex(int index) {
        if (index < 0 || index >= elementCount) {
            throw new IndexOutOfBoundsException();
        }

        No currentNode;
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
        new NoComElemento(item, base.nextNode);
    }

    @Override
    public void insertAtEnd(T item) {
        new NoComElemento(item, base);
    }

    @Override
    public void insertByIndex(int index, T item) {
        if (index == elementCount) {
            new NoComElemento(item, base);
        } else {
            new NoComElemento(item, getNodeByIndex(index));
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
    public IteradorIteravelDuplo<T> getIterator() {
        return new Iterador();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Lista Não Ordenada = {\n");
        No aux = base.nextNode;
        while (aux != base) {
            s.append(aux.element).append("\n");
            aux = aux.nextNode;
        }
        s.append("}\n");
        return s.toString();
    }

    public abstract class No implements Serializable {
        private static final long serialVersionUID = 1L;

        protected T element;
        protected No previous;
        protected No nextNode;

        protected abstract T remove();

        protected abstract boolean isElementEqual(T item);

        protected abstract boolean isElementEqualByReference(T item);

    }

    public class NoBase extends No {

        protected NoBase() {
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

    public class NoComElemento extends No {

        protected NoComElemento(T item, No nextLink) {
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


    public class Iterador implements IteradorIteravelDuplo<T> {
        protected No current;

        protected Iterador() {
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
