package aed.colecoes.iteraveis.lineares.ordenadas.estruturas;

import aed.Comparacao;
import aed.colecoes.iteraveis.ColecaoIteravel;
import aed.colecoes.iteraveis.lineares.ordenadas.ColecaoIteravelLinearOrdenada;

public class ListaOrdenadaOrdemDistinta<T> extends ListaOrdenada<T> {
    private static final long serialVersionUID = 1L;

    public ListaOrdenadaOrdemDistinta(Comparacao<T> cp) {
        super(cp);
    }

    public ListaOrdenadaOrdemDistinta(Comparacao<T> cp, ColecaoIteravelLinearOrdenada<T> collection) {
        super(cp, collection);
    }

    public ListaOrdenadaOrdemDistinta(Comparacao<T> cp, ColecaoIteravel<T> collection) {
        super(cp, collection);
    }

    @Override
    public void insert(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        No node = getNodeByOrder(item);
        if (node.compareElement(item) == 0) {
            throw new IllegalArgumentException("Elemento duplicado!");
        }

        new NoComElemento(item, node);
        elementCount++;
    }

    public T getDistinct(T item) {
        No node = getNodeByOrder(item);
        return node.compareElement(item) == 0 ? node.element : null;
    }
}
