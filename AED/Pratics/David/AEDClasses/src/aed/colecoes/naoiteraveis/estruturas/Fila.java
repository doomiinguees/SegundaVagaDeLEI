package aed.colecoes.naoiteraveis.estruturas;

import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaNaoOrdenada;
import aed.colecoes.naoiteraveis.ColecaoNaoIteravel;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class Fila<T> implements ColecaoNaoIteravel<T> {
    private static final long serialVersionUID = 1L;

    protected ListaNaoOrdenada<T> elements;

    public Fila() {
        elements = new ListaNaoOrdenada<>();
    }

    @Override
    public void insert(T item) {
        elements.insertAtEnd(item);
    }

    @Override
    public T remove() {
        return elements.removeFromBeginning();
    }

    @Override
    public T get() {
        try {
            return elements.getByIndex(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Fila = {\n");
        for (T element : elements) {
            s.append(element).append("\n");
        }
        s.append("}\n");
        return s.toString();
    }
}
