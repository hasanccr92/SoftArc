public class Worker {
    String name;
    double salary;
    double complement;
    static double totalSalary = 0;

    public Worker(String name, double salary, double complement) {
        this.name = name;
        this.salary = salary;
        this.complement = complement;
    }
    public static void main(String[] args) {
        Worker[] company = new Worker[2]; // Create an array of Workers

        // Create Worker objects and assign them to the array
        company[0] = new Worker("Alice", 234, 23);
        company[1] = new Worker("Bob", 3456, 243);



        for (int i = 0; i < 2; i++) {
            double total = company[i].salary + company[i].complement;
            totalSalary += total;
            System.out.println("Name: " + company[i].name +" Salary: " + company[i].salary +
                    " Complement: " + company[i].complement + " Total Salary: " + total);
        }
        System.out.println("Total Salary of all workers: "+totalSalary);
    }
}



