import java.util.List;

public class Vehicle {
    private String plateNo;
    private String make;
    private String model;
    private double engineDisplacement; // For motorcycles
    private double co2Emissions; // For petrol and diesel cars
    private String type; // "motorcycle", "petrol", "diesel", or "hybrid"

    public Vehicle(String plateNo, String make, String model, String type, double engineDisplacement, double co2Emissions) {
        this.plateNo = plateNo;
        this.make = make;
        this.model = model;
        this.type = type;
        this.engineDisplacement = engineDisplacement;
        this.co2Emissions = co2Emissions;
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

    public double getEngineDisplacement() {
        return engineDisplacement;
    }

    public double getCo2Emissions() {
        return co2Emissions;
    }
}
