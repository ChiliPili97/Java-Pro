package strategy;

import strategy.calculate.impl.CalculateAreaRectangle;
import strategy.calculate.impl.CalculateAreaTriangle;

import java.util.logging.Logger;

public class CalculateAreaDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(CalculateAreaDemo.class.getName().toString());
        Figure figure = new Figure(FigureType.TRIANGLE, 10, 2.5);

        if (figure.getFigureType() == FigureType.RECTANGLE) {
            figure.setCalculateArea(new CalculateAreaRectangle());
        } else {
            figure.setCalculateArea(new CalculateAreaTriangle());
        }

        logger.info("Area = " + figure.calculateArea());
    }
}
