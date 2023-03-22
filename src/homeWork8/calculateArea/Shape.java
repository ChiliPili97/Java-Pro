package homeWork8.calculateArea;

public interface Shape {

    double calculateArea();

    static double calculateTotalArea(Shape[] shapes) {

        double totalArea = 0;

        for (Shape figure : shapes) {
            totalArea = totalArea + figure.calculateArea();
        }
        return totalArea;
    }
}
