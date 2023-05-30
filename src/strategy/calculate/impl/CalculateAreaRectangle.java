package strategy.calculate.impl;

import strategy.calculate.CalculateAreaStrategy;

public class CalculateAreaRectangle implements CalculateAreaStrategy {
    @Override
    public double area(double a, double b) {
        return a * b;
    }
}
