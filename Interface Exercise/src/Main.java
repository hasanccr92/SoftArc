public class Main {
    public static void main(String[] args) {
        //5 Person objects
        Person[] persons = new Person[5];
        persons[0] = new Person("John", "Doe");
        persons[1] = new Person("Jane", "Smith");
        persons[2] = new Person("Alice", "Brown");
        persons[3] = new Person("Bob", "Doe");
        persons[4] = new Person("Charlie", "Smith");

        Sorter sorter = new Sorter();
        sorter.bubbleSort(persons);
        System.out.println("Sorted list of persons:");
        for (Person person : persons) {
            person.printPerson();
        }

        //rectangle objects
        Rectangle[] rectangles = new Rectangle[5];
        rectangles[0] = new Rectangle(5, 2);
        rectangles[1] = new Rectangle(3, 4);
        rectangles[2] = new Rectangle(2, 6);
        rectangles[3] = new Rectangle(4, 4);
        rectangles[4] = new Rectangle(1, 10);

        //rectangles
        sorter.bubbleSort(rectangles);

        System.out.println("Sorted rectangles by area:");
        for (Rectangle rectangle : rectangles) {
            rectangle.printRectangle();
        }
    }
}
