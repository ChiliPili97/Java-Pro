package homeWork8.calculateArea;

import java.util.Arrays;

public class DemoCalcArea {
    public static void main(String[] args) {

        Shape[] figures = new Shape[3];
        figures[0] = new Triangle(2, 3, 4);
        figures[1] = new Circle(12);
        figures[2] = new Square(5);

        System.out.println("Total area = " + Shape.calculateTotalArea(figures));
    }
}
