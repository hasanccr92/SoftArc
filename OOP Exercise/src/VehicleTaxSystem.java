import java.util.ArrayList;
import java.util.List;

public class VehicleTaxSystem {
    private List<Person> personList;

    public VehicleTaxSystem() {
        personList = new ArrayList<>();
    }

    // Add a person to the system
    public void addPerson(Person person) {
        personList.add(person);
    }

    // Remove a person from the system
    public void removePerson(Person person) {
        personList.remove(person);
    }

    // Calculate taxes for all persons and return a list of CalculatedTax objects
    public List<CalculatedTax> calculateAllTaxes() {
        List<CalculatedTax> calculatedTaxes = new ArrayList<>();
        for (Person person : personList) {
            List<String> taxes = person.calculateTax();
            calculatedTaxes.add(new CalculatedTax(taxes));
        }
        return calculatedTaxes;
    }
}
