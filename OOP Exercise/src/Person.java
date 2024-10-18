import java.util.ArrayList;
import java.util.List;

public class Person {
    private String licenseNo;
    private String name;
    private String surname;
    private String address;
    protected List<Vehicle> vehicles; // Protected list of vehicles

    public Person(String licenseNo, String name, String surname, String address) {
        this.licenseNo = licenseNo;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.vehicles = new ArrayList<>();
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public boolean removeVehicle(Vehicle vehicle) {
        return vehicles.remove(vehicle); // Return true if vehicle was removed
    }

    public List<String> calculateTax() {
        List<String> taxDetails = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            double tax = vehicle.calculateTax();
            taxDetails.add(name + " " + surname + " owns " + vehicle.getMake() + " " + vehicle.getModel() + " with a tax of: " + tax);
        }
        return taxDetails;
    }
}
