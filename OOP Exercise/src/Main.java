import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the system
        VehicleTaxSystem vehicleTaxSystem = new VehicleTaxSystem();

        // Create some people
        Person person1 = new Person("L123", "John", "Doe", "123 Elm St");
        Person person2 = new Person("L456", "Jane", "Smith", "456 Oak St");

        // Create some vehicles
        Vehicle vehicle1 = new Motorcycle("ABC123", "Yamaha", "MT-07", 689); // Motorcycle
        Vehicle vehicle2 = new PetrolCar("XYZ789", "Toyota", "Corolla", 150); // Petrol car
        Vehicle vehicle3 = new DieselCar("LMN456", "Ford", "Focus", 200); // Diesel car

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
