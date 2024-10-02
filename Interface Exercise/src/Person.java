public class Person implements Comparable<Person> {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public int compareTo(Person other) {
        int surnameComparison = this.surname.compareTo(other.surname);
        if (surnameComparison != 0) {
            return surnameComparison;
        }
        return this.name.compareTo(other.name);
    }

    void printPerson() {
        System.out.println("Name: " + name + ", Surname: " + surname);
    }
}
