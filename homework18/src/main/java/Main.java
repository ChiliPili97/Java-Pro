import java.awt.desktop.AppEvent;

public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(apple1);
        appleBox1.addFruit(apple2);

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addFruit(orange1);
        orangeBox1.addFruit(orange2);

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());

        System.out.println("Apple Box 1 Weight: " + appleBox1.getWeight());
        System.out.println("Orange Box 1 Weight: " + orangeBox1.getWeight());
        System.out.println("Apple Box 2 Weight: " + appleBox2.getWeight());

        System.out.println("Comparing Apple Box 1 and Orange Box 1: " + appleBox1.compare(orangeBox1));
        System.out.println("Comparing Apple Box 1 and Apple Box 2: " + appleBox1.compare(appleBox2));

        appleBox1.merge(appleBox2);

        System.out.println("Apple Box 1 Weight after merge: " + appleBox1.getWeight());
        System.out.println("Apple Box 2 Weight after merge: " + appleBox2.getWeight());
    }
}