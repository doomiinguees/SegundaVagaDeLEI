package aed.collections.iterable.linear.ordered.structures;

import aed.Comparison;
import aed.collections.iterable.IterableCollection;
import aed.collections.iterable.IterableIterator;
import aed.collections.iterable.linear.ordered.OrderedLinearIterableCollection;
import aed.collections.noniterable.structures.Queue;
import aed.collections.noniterable.structures.Stack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class BinaryTree<T> implements OrderedLinearIterableCollection<T> {
    private static final long serialVersionUID = 1L;

    protected SentinelNode base;
    protected Comparison<T> comparator;
    protected int elementCount;

    public BinaryTree(Comparison<T> cp) {
        comparator = cp;
        new SentinelNode();
    }

    public BinaryTree(Comparison<T> cp, OrderedLinearIterableCollection<T> collection) {
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

    public BinaryTree(Comparison<T> cp, IterableCollection<T> collection) {
        this(cp);

        for (T element : collection) {
            insert(element);
        }
    }

    @Override
    public void insert(T item) {
        new ElementNode(item);
    }


    @Override
    public T remove(T item) {
        Node parent = base;
        Node child = parent.left; // Raiz
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
        Node parent = base;
        Node child = parent.left; // Raíz
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

        FullInOrderIterator inOrderIterator = new FullInOrderIterator();
        do {
            inOrderIterator.advance();
        } while (inOrderIterator.canAdvance() && index-- > 0);

        return inOrderIterator.current();
    }

    @Override
    public IterableIterator<T> get(T startItem, T endItem) {
        return new RangeInOrderIterator(startItem, endItem);
    }

    @Override
    public boolean containsOrder(T item) {
        return get(item).canAdvance();
    }

    @Override
    public boolean contains(T item) {
        IterableIterator<T> customIterator = get(item);

        while (customIterator.canAdvance()) {
            if (customIterator.advance().equals(item)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsReference(T item) {
        IterableIterator<T> customIterator = get(item);

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
    public IterableIterator<T> getIterator() {
        return getInOrderIterator();
    }

    public IterableIterator<T> getPreOrderIterator() {
        return new PreOrderIterator();
    }

    public IterableIterator<T> getInOrderIterator() {
        return new FullInOrderIterator();
    }

    public IterableIterator<T> getPostOrderIterator() {
        return new PostOrderIterator();
    }

    public IterableIterator<T> getLevelOrderIterator() {
        return new LevelOrderIterator();
    }

    @Override
    public Comparison<T> getComparator() {
        return comparator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Binary Tree = {\n");
        for (T item : this) {
            sb.append(item).append("\n");
        }
        sb.append("}\n");

        return sb.toString();
    }


    protected abstract class Node implements Serializable {
        private static final long serialVersionUID = 1L;

        protected T element;
        protected Node left;
        protected Node right;

        protected abstract T remove(Node parent);

        protected abstract int compareElement(T item);
    }

    protected class SentinelNode extends Node {
        protected SentinelNode() {
            element = null;
            left = right = null;
            base = this;
            elementCount = 0;
        }

        protected T remove(Node parent) {
            return null;
        }

        protected int compareElement(T item) {
            return 1;
        }
    }

    protected class ElementNode extends Node {
        public ElementNode(T item) {
            if (item == null) {
                throw new IllegalArgumentException();
            }

            element = item;
            right = left = null;

            Node parent = base;
            Node child = null;
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

        protected T remove(Node parent) {
            elementCount--;
            Node newChild;
            if (right != null) {
                if (left != null) { // this tem nó esquerdo e nó direito
                    T removedElement = element;
                    Node smallestElementParent = this;
                    Node smallestElement = smallestElementParent.right;
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

    protected abstract class CustomIterator implements IterableIterator<T> {
        protected Node current;

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


    protected abstract class DepthFirstIterator extends CustomIterator {

        protected Stack<Node> stack;

        @Override
        public void reset() {
            super.reset();
            stack = new Stack<>();
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


    protected class PreOrderIterator extends DepthFirstIterator {

        public PreOrderIterator() {
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


    protected abstract class InOrderIterator extends DepthFirstIterator {
        @Override
        protected void updateStack() {
            if (current.right != null) {
                insertLeft(current.right);
            }
        }

        protected abstract void insertLeft(Node node);
    }


    protected class FullInOrderIterator extends InOrderIterator {

        public FullInOrderIterator() {
            reset();
        }

        @Override
        public void reset() {
            super.reset();

            if (base.left != null) {
                insertLeft(base.left);
            }
        }

        protected void insertLeft(Node node) {
            do {
                stack.insert(node);
                node = node.left;
            } while (node != null);
        }

    }

    protected class RangeInOrderIterator extends InOrderIterator {
        protected T startElement;
        protected T endElement;

        protected RangeInOrderIterator(T startItem, T endItem) {
            this.startElement = startItem;
            this.endElement = endItem;
            reset();
        }

        @Override
        public void reset() {
            super.reset();

            // desprezar os elementos inferiores ao elementoInicial
            Node first = base.left;
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

        protected void insertLeft(Node node) {
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

    protected class PostOrderIterator extends DepthFirstIterator {

        protected PostOrderIterator() {
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
                Node top = stack.get();
                // Se acabei de tirar o nó da esquerda põe o da direita
                if (top.left == current && top.right != null) {
                    insertLeftRight(top.right);
                }
            }
        }

        private void insertLeftRight(Node node) {
            do {
                stack.insert(node);
                node = (node.left != null) ? node.left : node.right;
            } while (node != null);
        }
    }

    protected class LevelOrderIterator extends CustomIterator {

        protected Queue<Node> queue;

        protected LevelOrderIterator() {
            reset();
        }

        @Override
        public void reset() {
            super.reset();
            queue = new Queue<>();
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
