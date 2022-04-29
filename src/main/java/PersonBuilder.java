public class PersonBuilder {

    private String name;
    private String surname;
    private int age = 0;
    private String address;

    public PersonBuilder setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Имя некорректное или отсутствует");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Фамилия некорректная или отсутствует!");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalStateException("Возраст не может быть меньше 0!");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalStateException("Не введены имя или фамилия!");
        }
        if (age <= 0) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
            person.setAddress(address);
        }
        return person;
    }

}