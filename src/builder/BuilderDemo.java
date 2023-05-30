package builder;

import builder.builders.impl.CarBuilder;

import java.util.logging.Logger;

public class BuilderDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(BuilderDemo.class.getName().toString());
        CarBuilder carBuilder = new CarBuilder();
        Director.createCityCar(carBuilder);

        Director.createCityCar(carBuilder);
        Car cityCar = carBuilder.getResult();
        logger.info("created city car: \n%s".formatted(cityCar));

        Director.createSportCar(carBuilder);
        Car sportCar = carBuilder.getResult();
        logger.info("created sport car: \n%s".formatted(sportCar));
    }
}
