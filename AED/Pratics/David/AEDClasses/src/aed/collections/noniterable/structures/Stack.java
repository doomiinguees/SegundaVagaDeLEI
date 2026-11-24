package aed.collections.noniterable.structures;

import aed.collections.noniterable.NonIterableCollection;

import java.io.Serializable;

public class Stack<T> implements NonIterableCollection<T> {
    private static final long serialVersionUID = 1L;

    protected Node topNode;

    public Stack() {
        topNode = null;
    }

    @Override
    public void insert(T item) {
        new Node(item);
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }

        T aux = topNode.element;
        topNode = topNode.nextNode;
        return aux;
    }

    @Override
    public T get() {
        return isEmpty() ? null : topNode.element;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    public void clear() {
        topNode = null;
    }

    /**
     * Lista todos os elementos da pilha desde o seu topo.
     */
    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        list.append("Stack = {\n");
        Node aux = topNode;
        while (aux != null) {
            list.append(aux.element).append("\n");
            aux = aux.nextNode;
        }
        list.append("}\n");
        return list.toString();
    }

    public class Node implements Serializable {
        private static final long serialVersionUID = 1L;

        protected T element;
        protected Node nextNode;

        // Criação de nó com elem e inserção antes do nó topo
        protected Node(T item) {
            element = item;
            nextNode = topNode;
            topNode = this;
        }
    }

}
