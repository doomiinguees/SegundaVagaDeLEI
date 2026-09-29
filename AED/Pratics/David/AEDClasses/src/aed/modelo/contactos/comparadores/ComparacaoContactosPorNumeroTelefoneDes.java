package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public enum ComparacaoContactosPorNumeroTelefoneDes implements Comparacao<Contacto> {
    COMPARATOR;

    @Override
    public int compare(Contacto c1, Contacto c2) {
        //todo Ficha Prática 3 - 2.a)
        return 0;
    }
}
