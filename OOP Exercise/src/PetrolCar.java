public class PetrolCar extends Vehicle {
    private double co2Emissions;

    public PetrolCar(String plateNo, String make, String model, double co2Emissions) {
        super(plateNo, make, model, "petrol");
        this.co2Emissions = co2Emissions;
    }

    @Override
    public double calculateTax() {
        return 1.4 * co2Emissions;
    }
}
