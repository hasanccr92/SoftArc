public class HybridCar extends Vehicle {
    private double co2Emissions;

    public HybridCar(String plateNo, String make, String model, double co2Emissions) {
        super(plateNo, make, model, "hybrid");
        this.co2Emissions = co2Emissions;
    }

    @Override
    public double calculateTax() {
        return 1.2 * co2Emissions;
    }
}
