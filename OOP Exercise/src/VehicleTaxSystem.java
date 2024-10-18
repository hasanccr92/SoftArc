import java.util.ArrayList;
import java.util.List;

public class VehicleTaxSystem {
    protected List<Person> personList; // Protected list of persons

    public VehicleTaxSystem() {
        personList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public boolean removePerson(String licenseNo) {
        return personList.removeIf(person -> person.getLicenseNo().equals(licenseNo)); // Remove by license number
    }

    public Person searchPerson(String licenseNo) {
        for (Person person : personList) {
            if (person.getLicenseNo().equals(licenseNo)) {
                return person;
            }
        }
        return null;
    }

    public boolean transferVehicle(String fromLicenseNo, String toLicenseNo, String vehiclePlateNo) {
        Person fromPerson = searchPerson(fromLicenseNo);
        Person toPerson = searchPerson(toLicenseNo);

        if (fromPerson != null && toPerson != null) {
            Vehicle vehicleToTransfer = null;
            for (Vehicle vehicle : fromPerson.getVehicles()) {
                if (vehicle.getPlateNo().equals(vehiclePlateNo)) {
                    vehicleToTransfer = vehicle;
                    break;
                }
            }

            if (vehicleToTransfer != null) {
                fromPerson.removeVehicle(vehicleToTransfer);
                toPerson.addVehicle(vehicleToTransfer);
                return true; // Transfer successful
            }
        }
        return false; // Transfer failed
    }

    public List<CalculatedTax> calculateAllTaxes() {
        List<CalculatedTax> calculatedTaxes = new ArrayList<>();
        for (Person person : personList) {
            List<String> taxes = person.calculateTax();
            calculatedTaxes.add(new CalculatedTax(taxes));
        }
        return calculatedTaxes;
    }
}
