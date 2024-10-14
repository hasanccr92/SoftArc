import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the system
        VehicleTaxSystem vehicleTaxSystem = new VehicleTaxSystem();

        // Create some people
        Person person1 = new Person("L123", "John", "Doe", "123 Elm St");
        Person person2 = new Person("L456", "Jane", "Smith", "456 Oak St");

        // Create some vehicles
        Vehicle vehicle1 = new Vehicle("ABC123", "Yamaha", "MT-07", "motorcycle", 689, 0);
        Vehicle vehicle2 = new Vehicle("XYZ789", "Toyota", "Corolla", "petrol", 0, 150);
        Vehicle vehicle3 = new Vehicle("LMN456", "Ford", "Focus", "diesel", 0, 200);

        // Add vehicles to people
        person1.addVehicle(vehicle1); // John owns the Yamaha motorcycle
        person2.addVehicle(vehicle2); // Jane owns the Toyota petrol car
        person2.addVehicle(vehicle3); // Jane also owns the Ford diesel car

        // Add people to the system
        vehicleTaxSystem.addPerson(person1);
        vehicleTaxSystem.addPerson(person2);

        // Calculate taxes for all persons
        List<CalculatedTax> taxes = vehicleTaxSystem.calculateAllTaxes();

        // Print tax details
        for (CalculatedTax calculatedTax : taxes) {
            for (String taxDetail : calculatedTax.getTaxList()) {
                System.out.println(taxDetail);
            }
        }
    }
}
