public class Motorcycle extends Vehicle {
    private double engineDisplacement;

    public Motorcycle(String plateNo, String make, String model, double engineDisplacement) {
        super(plateNo, make, model, "motorcycle");
        this.engineDisplacement = engineDisplacement;
    }

    @Override
    public double calculateTax() {
        return 0.10 * engineDisplacement;
    }
}
