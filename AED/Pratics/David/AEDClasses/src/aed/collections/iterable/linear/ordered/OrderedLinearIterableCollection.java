package aed.collections.iterable.linear.ordered;

import aed.Comparison;
import aed.collections.iterable.IterableIterator;
import aed.collections.iterable.linear.LinearIterableCollection;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
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
