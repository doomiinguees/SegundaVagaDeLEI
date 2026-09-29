package aed.modelo.contactos;

import java.io.Serializable;
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
public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String firstName;
    private final String lastName;
    private final long phoneNumber;
    private final String address;
    private final Data birthDate;

    public Contacto(String firstName, String lastName,
                    long phoneNumber, String address,
                    Data birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Data getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Contacto contact = (Contacto) o;

        if (phoneNumber != contact.phoneNumber) {
            return false;
        }
        if (!Objects.equals(firstName, contact.firstName)) {
            return false;
        }
        if (!Objects.equals(lastName, contact.lastName)) {
            return false;
        }
        if (!Objects.equals(address, contact.address)) {
            return false;
        }
        return Objects.equals(birthDate, contact.birthDate);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +
                " - Nº: " + phoneNumber +
                " - " + birthDate +
                " - " + address + '\n';
    }

}
