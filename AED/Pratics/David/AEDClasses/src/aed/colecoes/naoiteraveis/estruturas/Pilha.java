package aed.colecoes.naoiteraveis.estruturas;

import aed.colecoes.naoiteraveis.ColecaoNaoIteravel;

import java.io.Serializable;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class Pilha<T> implements ColecaoNaoIteravel<T> {
    private static final long serialVersionUID = 1L;

    protected No topNode;

    public Pilha() {
        topNode = null;
    }

    @Override
    public void insert(T item) {
        new No(item);
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
        list.append("Pilha = {\n");
        No aux = topNode;
        while (aux != null) {
            list.append(aux.element).append("\n");
            aux = aux.nextNode;
        }
        list.append("}\n");
        return list.toString();
    }

    public class No implements Serializable {
        private static final long serialVersionUID = 1L;

        protected T element;
        protected No nextNode;

        // Criação de nó com elem e inserção antes do nó topo
        protected No(T item) {
            element = item;
            nextNode = topNode;
            topNode = this;
        }
    }

}
