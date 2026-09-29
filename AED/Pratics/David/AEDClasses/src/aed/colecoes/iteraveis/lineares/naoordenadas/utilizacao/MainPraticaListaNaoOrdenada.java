package aed.colecoes.iteraveis.lineares.naoordenadas.utilizacao;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaNaoOrdenada;

public class MainPraticaListaNaoOrdenada {
    public static void main(String[] args) {
        ListaNaoOrdenada<Integer> list, other;

        System.out.println("***************** TRANSFERIR PARA O INÍCIO *****************");
        System.out.println("=======================================");
        System.out.println("AMBAS AS LISTAS COM ELEMENTOS");
        list = new ListaNaoOrdenada<>();
        list.insert(3);
        list.insert(1);
        list.insert(5);
        other = new ListaNaoOrdenada<>();
        other.insert(4);
        other.insert(2);
        transferAndDisplay(list, other);

        System.out.println("=======================================");
        System.out.println("LISTA COM ELEMENTOS E OUTRA VAZIA");
        list = new ListaNaoOrdenada<>();
        list.insert(3);
        list.insert(1);
        list.insert(5);
        other = new ListaNaoOrdenada<>();
        transferAndDisplay(list, other);

        System.out.println("=======================================");
        System.out.println("LISTA VAZIA E OUTRA COM ELEMENTOS");
        list = new ListaNaoOrdenada<>();
        other = new ListaNaoOrdenada<>();
        other.insert(3);
        other.insert(1);
        other.insert(5);
        transferAndDisplay(list, other);

        System.out.println();
        System.out.println("***************** REMOVER N ÚLTIMOS *****************");
        System.out.println("=======================================");
        System.out.println("n <= numeroElementos");
        list = new ListaNaoOrdenada<>();
        list.insert(4);
        list.insert(2);
        list.insert(3);
        list.insert(1);
        list.insert(5);
        removeAndDisplay(list, 2);
        System.out.println("=======================================");
        System.out.println("n > numeroElementos");
        list = new ListaNaoOrdenada<>();
        list.insert(4);
        list.insert(2);
        removeAndDisplay(list, 5);
        System.out.println("=======================================");
        System.out.println("n == 0");
        list = new ListaNaoOrdenada<>();
        list.insert(4);
        list.insert(2);
        list.insert(3);
        list.insert(1);
        list.insert(5);
        removeAndDisplay(list, 0);
        System.out.println("=======================================");
        System.out.println("numeroElementos = 0");
        list = new ListaNaoOrdenada<>();
        removeAndDisplay(list, 1);

    }

    private static void transferAndDisplay(ListaNaoOrdenada<Integer> list, ListaNaoOrdenada<Integer> other) {
        System.out.println("Listas antes de transferir");
        System.out.println("LISTA => " + list);
        System.out.println("OUTRA => " + other);

        list.transferToBeginning(other);
        System.out.println("Listas depois de transferir");
        System.out.println("LISTA => " + list);
        System.out.println("OUTRA => " + other);

        System.out.println("Listagem dos elementos da LISTA por ordem inversa");
        IteradorIteravelDuplo<Integer> customIterator = list.getIterator();
        while (customIterator.canRetreat()) {
            System.out.println(customIterator.retreat());
        }
    }

    private static void removeAndDisplay(ListaNaoOrdenada<Integer> list, int n) {
        System.out.println("Lista antes de remover " + n + " elementos");
        System.out.println("LISTA => " + list);

        ListaNaoOrdenada<Integer> resultValue = list.removeFromEnd(n);
        System.out.println("Listas depois de remover " + n + " elementos");
        System.out.println("LISTA => " + list);
        System.out.println("RESULTADO => " + resultValue);

        System.out.println("Listagem dos elementos da LISTA por ordem inversa");
        IteradorIteravelDuplo<Integer> customIterator = list.getIterator();
        while (customIterator.canRetreat()) {
            System.out.println(customIterator.retreat());
        }
    }
}
