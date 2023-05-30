package strategy;

import strategy.calculate.CalculateAreaStrategy;

public class Figure {
    private FigureType figureType;
    private double a;
    private double b;
    private CalculateAreaStrategy calculateArea;

    public Figure(FigureType figureType, double a, double b) {
        this.figureType = figureType;
        this.a = a;
        this.b = b;
    }

    public double calculateArea() {
        return calculateArea.area(this.a, this.b);
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public CalculateAreaStrategy getCalculateArea() {
        return calculateArea;
    }

    public void setCalculateArea(CalculateAreaStrategy calculateArea) {
        this.calculateArea = calculateArea;
    }
}
