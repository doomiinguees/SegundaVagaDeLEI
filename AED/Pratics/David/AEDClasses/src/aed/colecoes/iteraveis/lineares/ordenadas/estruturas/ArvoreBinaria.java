package aed.colecoes.iteraveis.lineares.ordenadas.estruturas;

import aed.Comparacao;
import aed.colecoes.iteraveis.ColecaoIteravel;
import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.lineares.ordenadas.ColecaoIteravelLinearOrdenada;
import aed.colecoes.naoiteraveis.estruturas.Fila;
import aed.colecoes.naoiteraveis.estruturas.Pilha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class ArvoreBinaria<T> implements ColecaoIteravelLinearOrdenada<T> {
    private static final long serialVersionUID = 1L;

    protected NoBase base;
    protected Comparacao<T> comparator;
    protected int elementCount;

    public ArvoreBinaria(Comparacao<T> cp) {
        comparator = cp;
        new NoBase();
    }

    public ArvoreBinaria(Comparacao<T> cp, ColecaoIteravelLinearOrdenada<T> collection) {
        this(cp);
        ArrayList<T> elements = new ArrayList<>();
        for (T element : collection) {
            elements.add(element);
        }

        Collections.shuffle(elements);

        for (T element : elements) {
            insert(element);
        }
    }

    public ArvoreBinaria(Comparacao<T> cp, ColecaoIteravel<T> collection) {
        this(cp);

        for (T element : collection) {
            insert(element);
        }
    }

    @Override
    public void insert(T item) {
        new NoComElemento(item);
    }


    @Override
    public T remove(T item) {
        No parent = base;
        No child = parent.left; // Raiz
        int cp;

        while (child != null) {
            cp = child.compareElement(item);
            if (cp == 0) {
                if (item.equals(child.element)) { // O elemento a remover está no nó filho
                    return child.remove(parent);
                }

                // Só pode estar à direita - elementos de igual critério
                parent = child;
                child = child.right;
            } else {
                parent = child;
                child = cp > 0 ? child.left : child.right;
            }
        }

        // Não encontrou o elemento
        return null;
    }

    @Override
    public T removeByReference(T item) {
        No parent = base;
        No child = parent.left; // Raíz
        int cp;

        while (child != null) {
            cp = child.compareElement(item);
            if (cp == 0) {
                if (item == child.element) { // O elemento a remover está no nó filho
                    return child.remove(parent);
                }

                // Só pode estar à direita - elementos de igual critério
                parent = child;
                child = child.right;
            } else {
                parent = child;
                child = cp > 0 ? child.left : child.right;
            }
        }

        // Não encontrou o elemento
        return null;
    }

    @Override
    public T removeByIndex(int index) {
        return removeByReference(getByIndex(index));
    }

    @Override
    public T getByIndex(int index) {
        if (index < 0 || index >= elementCount) {
            throw new IllegalArgumentException();
        }

        IteradorEmOrdemCompleto inOrderIterator = new IteradorEmOrdemCompleto();
        do {
            inOrderIterator.advance();
        } while (inOrderIterator.canAdvance() && index-- > 0);

        return inOrderIterator.current();
    }

    @Override
    public IteradorIteravel<T> get(T startItem, T endItem) {
        return new IteradorEmOrdemNumIntervalo(startItem, endItem);
    }

    @Override
    public boolean containsOrder(T item) {
        return get(item).canAdvance();
    }

    @Override
    public boolean contains(T item) {
        IteradorIteravel<T> customIterator = get(item);

        while (customIterator.canAdvance()) {
            if (customIterator.advance().equals(item)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsReference(T item) {
        IteradorIteravel<T> customIterator = get(item);

        while (customIterator.canAdvance()) {
            if (customIterator.advance() == item) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int getElementCount() {
        return elementCount;
    }

    @Override
    public IteradorIteravel<T> getIterator() {
        return getInOrderIterator();
    }

    public IteradorIteravel<T> getPreOrderIterator() {
        return new IteradorPreOrdem();
    }

    public IteradorIteravel<T> getInOrderIterator() {
        return new IteradorEmOrdemCompleto();
    }

    public IteradorIteravel<T> getPostOrderIterator() {
        return new IteradorPosOrdem();
    }

    public IteradorIteravel<T> getLevelOrderIterator() {
        return new IteradorPorNiveis();
    }

    @Override
    public Comparacao<T> getComparator() {
        return comparator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Árvore Binária = {\n");
        for (T item : this) {
            sb.append(item).append("\n");
        }
        sb.append("}\n");

        return sb.toString();
    }


    protected abstract class No implements Serializable {
        private static final long serialVersionUID = 1L;

        protected T element;
        protected No left;
        protected No right;

        protected abstract T remove(No parent);

        protected abstract int compareElement(T item);
    }

    protected class NoBase extends No {
        protected NoBase() {
            element = null;
            left = right = null;
            base = this;
            elementCount = 0;
        }

        protected T remove(No parent) {
            return null;
        }

        protected int compareElement(T item) {
            return 1;
        }
    }

    protected class NoComElemento extends No {
        public NoComElemento(T item) {
            if (item == null) {
                throw new IllegalArgumentException();
            }

            element = item;
            right = left = null;

            No parent = base;
            No child = null;
            int cp;

            do {
                cp = parent.compareElement(item);
                if (cp > 0) {
                    child = parent.left;
                    if (child == null) {
                        parent.left = this;
                        break;
                    }
                } else {  // Elementos de critério maior ou *igual* são inseridos à direita
                    child = parent.right;
                    if (child == null) {
                        parent.right = this;
                        break;
                    }
                }
                parent = child;
            } while (true);
            elementCount++;
        }

        protected T remove(No parent) {
            elementCount--;
            No newChild;
            if (right != null) {
                if (left != null) { // this tem nó esquerdo e nó direito
                    T removedElement = element;
                    No smallestElementParent = this;
                    No smallestElement = smallestElementParent.right;
                    if (smallestElement.left == null) { // this à direita do paiMenorElemento
                        smallestElementParent.right = smallestElement.right;
                    }
                    else {
                        do {
                            smallestElementParent = smallestElement;
                            smallestElement = smallestElement.left;
                        } while (smallestElement.left != null);
                        smallestElementParent.left = smallestElement.right; // this está à esquerda do paiMenorElemento
                    }
                    element = smallestElement.element;
                    return removedElement;
                }
                newChild = right; // this só tem nó direito
            } else {
                newChild = left; // this só tem nó esquerdo ou nenhum
            }
            if (parent.compareElement(element) > 0) {
                parent.left = newChild;
            } else {
                parent.right = newChild;
            }
            return element;
        }

        protected int compareElement(T item) {
            return comparator.compare(element, item);
        }
    }

    protected abstract class Iterador implements IteradorIteravel<T> {
        protected No current;

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
    }


    protected abstract class IteradorEmProfundidade extends Iterador {

        protected Pilha<No> stack;

        @Override
        public void reset() {
            super.reset();
            stack = new Pilha<>();
        }

        @Override
        public boolean canAdvance() {
            return !stack.isEmpty();
        }

        @Override
        public T advance() {
            if (!canAdvance()) {
                throw new NoSuchElementException();
            }

            current = stack.remove();

            updateStack();

            return current.element;
        }

        protected abstract void updateStack();

    }


    protected class IteradorPreOrdem extends IteradorEmProfundidade {

        public IteradorPreOrdem() {
            reset();
        }

        @Override
        public void reset() {
            super.reset();

            if (base.left != null) {
                stack.insert(base.left);
            }
        }

        @Override
        protected void updateStack() {
            if (current.right != null) {
                stack.insert(current.right);
            }

            if (current.left != null) {
                stack.insert(current.left);
            }
        }
    }


    protected abstract class IteradorEmOrdem extends IteradorEmProfundidade {
        @Override
        protected void updateStack() {
            if (current.right != null) {
                insertLeft(current.right);
            }
        }

        protected abstract void insertLeft(No node);
    }


    protected class IteradorEmOrdemCompleto extends IteradorEmOrdem {

        public IteradorEmOrdemCompleto() {
            reset();
        }

        @Override
        public void reset() {
            super.reset();

            if (base.left != null) {
                insertLeft(base.left);
            }
        }

        protected void insertLeft(No node) {
            do {
                stack.insert(node);
                node = node.left;
            } while (node != null);
        }

    }

    protected class IteradorEmOrdemNumIntervalo extends IteradorEmOrdem {
        protected T startElement;
        protected T endElement;

        protected IteradorEmOrdemNumIntervalo(T startItem, T endItem) {
            this.startElement = startItem;
            this.endElement = endItem;
            reset();
        }

        @Override
        public void reset() {
            super.reset();

            // desprezar os elementos inferiores ao elementoInicial
            No first = base.left;
            int cp;
            do {
                if (first == null) {
                    return;
                }
                cp = first.compareElement(startElement);
                if (cp >= 0) {
                    insertLeft(first);
                    return;
                }

                first = first.right;
            } while (true);

        }

        protected void insertLeft(No node) {
            do {
                if (node.compareElement(endElement) <= 0) {
                    if (node.compareElement(startElement) < 0) {
                        break;
                    }
                    stack.insert(node);
                }

                if (node.left == null) {
                    break;
                }

                node = node.left;
            } while (true);
        }

    }

    protected class IteradorPosOrdem extends IteradorEmProfundidade {

        protected IteradorPosOrdem() {
            reset();
        }

        @Override
        public void reset() {
            super.reset();

            if (base.left != null) {
                insertLeftRight(base.left);
            }
        }

        @Override
        protected void updateStack() {
            if (!stack.isEmpty()) {
                No top = stack.get();
                // Se acabei de tirar o nó da esquerda põe o da direita
                if (top.left == current && top.right != null) {
                    insertLeftRight(top.right);
                }
            }
        }

        private void insertLeftRight(No node) {
            do {
                stack.insert(node);
                node = (node.left != null) ? node.left : node.right;
            } while (node != null);
        }
    }

    protected class IteradorPorNiveis extends Iterador {

        protected Fila<No> queue;

        protected IteradorPorNiveis() {
            reset();
        }

        @Override
        public void reset() {
            super.reset();
            queue = new Fila<>();
            if (base.left != null) {
                queue.insert(base.left);
            }
        }

        @Override
        public boolean canAdvance() {
            return !queue.isEmpty();
        }

        @Override
        public T advance() {
            if (!canAdvance()) {
                throw new NoSuchElementException();
            }
            current = queue.remove();

            if (current.left != null) {
                queue.insert(current.left);
            }

            if (current.right != null) {
                queue.insert(current.right);
            }

            return current.element;
        }
    }
}
