package aed.collections.iterable.linear.ordered;

import aed.Comparison;
import aed.collections.iterable.IterableIterator;
import aed.collections.iterable.linear.LinearIterableCollection;

public interface OrderedLinearIterableCollection<T> extends LinearIterableCollection<T> {

    Comparison<T> getComparator();

    // Devolve um iterador de todos os elementos que tenham a mesma ordem que elem
    default IterableIterator<T> get(T item) {
        return get(item, item);
    }

    // Devolve um iterador dos elementos de ordem
    // superior ou igual à ordem de elemInicial e
    // menor ou igual à ordem de elemFinal
    IterableIterator<T> get(T startItem, T endItem);

    boolean containsOrder(T item);
}
