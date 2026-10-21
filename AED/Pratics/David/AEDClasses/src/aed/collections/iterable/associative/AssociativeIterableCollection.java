package aed.collections.iterable.associative;

import aed.collections.iterable.IterableCollection;
import aed.collections.iterable.IterableIterator;
import aed.collections.iterable.associative.structures.Association;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
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
