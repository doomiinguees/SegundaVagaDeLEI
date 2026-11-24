package aed.model.people;

import java.util.Objects;

public class Person {

    private final long ID_NUMBER;
    private String name;

    public Person(long ID_NUMBER, String name) {
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
        Person person = (Person) o;
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
        return "ID: " + ID_NUMBER + " Name: " + name;
    }
}
