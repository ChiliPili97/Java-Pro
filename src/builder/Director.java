package builder;

import builder.builders.Builder;
import builder.components.CarType;
import builder.components.EngineType;

public class Director {
    public static void createSportCar(Builder builder) {
        builder.setCarType(CarType.SPORTS);
        builder.setEngin(EngineType.PETROL);
        builder.setSeats(2);
    }

    public static void createCityCar(Builder builder) {
        builder.setCarType(CarType.SEDAN);
        builder.setEngin(EngineType.ELECTRIC);
        builder.setSeats(4);
    }

    public static void createOffRoadCar(Builder builder) {
        builder.setCarType(CarType.CROSSOVER);
        builder.setEngin(EngineType.DIESEL);
        builder.setSeats(4);
    }
}
