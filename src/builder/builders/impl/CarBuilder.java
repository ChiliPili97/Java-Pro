package builder.builders.impl;

import builder.components.CarType;
import builder.components.EngineType;
import builder.builders.Builder;
import builder.Car;

public class CarBuilder implements Builder {

    private CarType carType;
    private int seats;
    private EngineType engineType;

    @Override
    public void setCarType(CarType type) {
        this.carType = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngin(EngineType engineType) {
        this.engineType = engineType;
    }

    public Car getResult() {
        return new Car(carType, seats, engineType);
    }
}
