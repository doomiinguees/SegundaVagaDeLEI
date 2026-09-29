package aed.colecoes.naoiteraveis.utilizacao;

import aed.colecoes.naoiteraveis.estruturas.Fila;
import aed.modelo.pessoas.Pessoa;

public class MainTeoricaFila {

    public static void main(String[] args) {
        Fila<Pessoa> people = new Fila<>();

        people.insert(new Pessoa(3, "B"));
        people.insert(new Pessoa(1, "C"));
        people.insert(new Pessoa(2, "A"));

        System.out.println("Pessoas\n" + people);

        people.remove();
        System.out.println("Pessoas\n" + people);

        System.out.println(people.get());

        people.remove();
        System.out.println("Pessoas\n" + people);
    }
}
