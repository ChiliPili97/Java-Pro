package strategy.calculate.impl;

import strategy.calculate.CalculateAreaStrategy;

public class CalculateAreaTriangle implements CalculateAreaStrategy {

    @Override
    public double area(double a, double b) {
        return (0.5 * a * b);
    }
}
