package homeWork8.calculateArea;

import homeWork8.calculateArea.CalculateArea;

public class Square implements CalculateArea {

    private int a;

    public Square(int a) {
        this.a = a;
    }

    @Override
    public double calculateArea() {
        return this.a * this.a;
    }
}
