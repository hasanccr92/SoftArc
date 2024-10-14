import java.util.ArrayList;
import java.util.List;

public class Person {
    private String licenseNo;
    private String name;
    private String surname;
    private String address;
    private List<Vehicle> vehicles;

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

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public List<String> calculateTax() {
        List<String> taxDetails = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            double tax = 0.0;
            switch (vehicle.getType()) {
                case "motorcycle":
                    tax = 0.10 * vehicle.getEngineDisplacement();
                    break;
                case "petrol":
                    tax = 1.4 * vehicle.getCo2Emissions();
                    break;
                case "diesel":
                    tax = 1.8 * vehicle.getCo2Emissions();
                    break;
                case "hybrid":
                    tax = 1.2 * vehicle.getCo2Emissions();
                    break;
            }
            taxDetails.add(name + " " + surname + " owns " + vehicle.getMake() + " " + vehicle.getModel() + " with a tax of: " + tax);
        }
        return taxDetails;
    }
}
