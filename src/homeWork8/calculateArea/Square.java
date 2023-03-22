package homeWork8.calculateArea;

public class Square implements Shape {

    private int a;

    public Square(int a) {
        this.a = a;
    }

    @Override
    public double calculateArea() {
        return this.a * this.a;
    }
}
