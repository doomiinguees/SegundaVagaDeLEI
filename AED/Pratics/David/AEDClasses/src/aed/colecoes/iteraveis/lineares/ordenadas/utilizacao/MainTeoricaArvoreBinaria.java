package aed.colecoes.iteraveis.lineares.ordenadas.utilizacao;

import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ArvoreBinaria;
import aed.modelo.pessoas.Pessoa;
import aed.modelo.pessoas.comparadores.ComparacaoPessoasPorNomeAsc;

public class MainTeoricaArvoreBinaria {

    public static void main(String[] args) {
        ArvoreBinaria<Pessoa> peopleByName = new ArvoreBinaria<>(ComparacaoPessoasPorNomeAsc.COMPARATOR);

        Pessoa[] people = {
                new Pessoa(3, "P"),
                new Pessoa(8, "F"),
                new Pessoa(2, "M"),
                new Pessoa(1, "T"),
                new Pessoa(7, "A"),
                new Pessoa(4, "R"),
                new Pessoa(10, "Q"),
                new Pessoa(5, "I"),
                new Pessoa(13, "X"),
                new Pessoa(11, "Z")
        };

        // Remoção de pessoa que não existe
        peopleByName.remove(new Pessoa(6, "D"));

        for (Pessoa person : people) {
            peopleByName.insert(person);
        }

        System.out.println("\nTodas as pessoas em pré-ordem:");
        for (Pessoa person : peopleByName.getPreOrderIterator()) {
            System.out.println(person);
        }

        System.out.println("\nTodas as pessoas em ordem:");
        for (Pessoa person : peopleByName.getInOrderIterator()) {
            System.out.println(person);
        }

        System.out.println("\nTodas as pessoas em ordem com nome entre B e R:");
        for (Pessoa person : peopleByName.get(new Pessoa(0, "B"), new Pessoa(0, "R"))) {
            System.out.println(person);
        }

        System.out.println("\nTodas as pessoas em pós-ordem:");
        for (Pessoa person : peopleByName.getPostOrderIterator()) {
            System.out.println(person);
        }

        System.out.println("\nTodas as pessoas por níveis:");
        for (Pessoa person : peopleByName.getLevelOrderIterator()) {
            System.out.println(person);
        }


        System.out.println("\nPessoa na 4ª posição: " + peopleByName.getByIndex(3));

        peopleByName.remove(new Pessoa(7, "A")); // Caso sem filhos
        peopleByName.remove(new Pessoa(2, "M")); // Caso apenas com filho à esquerda
        peopleByName.remove(new Pessoa(8, "F")); // Caso apenas com filho à direita
        peopleByName.remove(new Pessoa(3, "P")); // Caso com dois filhos em que paiMenorElemento != filho
        peopleByName.removeByReference(people[3]);     // Caso com dois filhos em que paiMenorElemento == filho

        System.out.println("\nTodas as pessoas em ordem:");
        for (Pessoa person : peopleByName.getInOrderIterator()) {
            System.out.println(person);
        }
    }
}
