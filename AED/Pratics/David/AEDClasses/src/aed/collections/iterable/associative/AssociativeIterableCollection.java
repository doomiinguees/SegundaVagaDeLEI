package aed.collections.iterable.associative;

import aed.collections.iterable.IterableCollection;
import aed.collections.iterable.IterableIterator;
import aed.collections.iterable.associative.structures.Association;

public interface AssociativeIterableCollection<C, V> extends IterableCollection<Association<C, V>> {

    /**
     * Insere uma associação (chave, valor) sem duplicação
     */
    void insert(C key, V value);

    /**
     * Remove a associação correspondente à chave e devolve o valor correspondente
     */
    V remove(C key);

    /**
     * Devolve o valor correspondente à chave ou null
     */
    V get(C key);

    /**
     * Verifica se chave pertence à tabela
     */
    boolean contains(C key);

    /**
     * Devolve um iterador das chaves da tabela
     */
    IterableIterator<C> getKeyIterator();

    /**
     * Devolve um iterador dos valores da tabela
     */
    IterableIterator<V> getValueIterator();

}
