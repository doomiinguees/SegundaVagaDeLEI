package aed.modelo.pessoas.comparadores;


import aed.Comparacao;
import aed.modelo.pessoas.Pessoa;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public enum ComparacaoPessoasPorBIAsc implements Comparacao<Pessoa> {
    COMPARATOR;

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        return Long.compare(o1.getIdNumber(), o2.getIdNumber());
    }
}
