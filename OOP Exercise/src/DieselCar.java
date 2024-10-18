public class DieselCar extends Vehicle {
    private double co2Emissions;

    public DieselCar(String plateNo, String make, String model, double co2Emissions) {
        super(plateNo, make, model, "diesel");
        this.co2Emissions = co2Emissions;
    }

    @Override
    public double calculateTax() {
        return 1.8 * co2Emissions;
    }
}
