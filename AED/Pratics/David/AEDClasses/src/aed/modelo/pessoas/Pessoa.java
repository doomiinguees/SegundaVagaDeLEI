package aed.modelo.pessoas;

import java.util.Objects;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class Pessoa {

    private final long ID_NUMBER;
    private String name;

    public Pessoa(long ID_NUMBER, String name) {
        this.ID_NUMBER = ID_NUMBER;
        this.name = name;
    }

    public long getIdNumber() {
        return ID_NUMBER;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pessoa person = (Pessoa) o;
        return ID_NUMBER == person.ID_NUMBER && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (ID_NUMBER ^ (ID_NUMBER >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BI: " + ID_NUMBER + " Nome: " + name;
    }
}
