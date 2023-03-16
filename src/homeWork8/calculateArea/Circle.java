package homeWork8.calculateArea;

import homeWork8.calculateArea.CalculateArea;

public class Circle implements CalculateArea {

    private final double pi = 3.14;
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double calculateArea() {
        return this.pi * this.r * 2;
    }
}
