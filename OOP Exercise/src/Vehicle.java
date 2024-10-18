public abstract class Vehicle {
    protected String plateNo;
    protected String make;
    protected String model;
    protected String type; // "motorcycle", "petrol", "diesel", or "hybrid"

    public Vehicle(String plateNo, String make, String model, String type) {
        this.plateNo = plateNo;
        this.make = make;
        this.model = model;
        this.type = type;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateTax(); // Abstract method for tax calculation
}
