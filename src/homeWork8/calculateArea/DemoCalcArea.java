package homeWork8.calculateArea;

import java.util.Arrays;

public class DemoCalcArea {
    public static void main(String[] args) {

        CalculateArea triangle = new Triangle(2, 3, 4);
        CalculateArea circle = new Circle(12);
        CalculateArea square = new Square(5);

        var figures = Arrays.asList(triangle, circle, square);
        for (CalculateArea f : figures) {
            System.out.println(f.calculateArea());
        }
    }
}
