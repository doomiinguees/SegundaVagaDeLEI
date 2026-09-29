package aed.colecoes.iteraveis.lineares.naoordenadas;


import aed.colecoes.iteraveis.lineares.ColecaoIteravelLinear;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public interface ColecaoIteravelLinearNaoOrdenada<T> extends ColecaoIteravelLinear<T> {
    void insertAtBeginning(T item);

    void insertAtEnd(T item);

    void insertByIndex(int index, T item);

    @Override
    default void insert(T item) {
        insertAtEnd(item);
    }

    T removeFromBeginning();

    T removeFromEnd();
}
