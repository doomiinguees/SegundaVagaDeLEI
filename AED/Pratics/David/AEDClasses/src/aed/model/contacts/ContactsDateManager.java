package aed.model.contacts;

import aed.collections.iterable.linear.ordered.structures.ListaOrdenada;

import java.io.Serializable;
import java.util.Objects;

public class ContactsDateManager implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date birthDate;
	private ListaOrdenada<Contact> contacts;

	public ContactsDateManager(Date birthDate, ListaOrdenada<Contact> contacts) {
		this.birthDate = birthDate;
		this.contacts = contacts;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ContactsDateManager obj = (ContactsDateManager) o;
		return Objects.equals(birthDate, obj.birthDate) && Objects.equals(contacts, obj.contacts);
	}

	@Override
	public int hashCode () {
		return Objects.hash(birthDate, contacts);
	}

	@Override
	public String toString() {
		return " (" + birthDate + ", " + contacts + ")";
	}
}