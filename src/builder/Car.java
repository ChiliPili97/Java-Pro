package builder;

import builder.components.CarType;
import builder.components.EngineType;

public class Car {

    private CarType carType;
    private int seats;
    private EngineType engineType;

    public Car(CarType carType, int seats, EngineType engine) {
        this.carType = carType;
        this.seats = seats;
        this.engineType = engine;
    }

    public CarType getCarType() {
        return carType;
    }

    public int getSeats() {
        return seats;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carType=" + carType +
                ", seats=" + seats +
                ", engineType=" + engineType +
                '}';
    }
}
