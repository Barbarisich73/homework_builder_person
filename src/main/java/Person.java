import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = 0;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return this.age >= 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (this.hasAge()) {
            age++;
        }
    }

    PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAge(1).setAddress(address);
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", " +
                "Фамилия: " + surname + ", " +
                "Возраст: " + age + ", " +
                "Адрес: " + address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName())
                && Objects.equals(getSurname(), person.getSurname())
                && Objects.equals(getAddress(), person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getAddress());
    }
}