import java.awt.desktop.AppEvent;

public class Main {
    public static void main(String[] args) {
        Box boxApple1 = new Box<>();
        boxApple1.add(new Apple());
        boxApple1.add(new Apple());
        boxApple1.add(new Apple());
        boxApple1.add(new Apple());
        boxApple1.add(new Apple());
        System.out.println("Box 1 weight: " + boxApple1.getWeight());

        Box boxApple2 = new Box<>();
        boxApple2.add(new Apple());
        boxApple2.add(new Apple());
        boxApple2.add(new Apple());
        System.out.println("Box 2 weight: " + boxApple2.getWeight());

        Box boxOrange = new Box<>();
        boxOrange.add(new Orange());
        boxOrange.add(new Orange());

        boxApple1.merge(boxApple2);
        System.out.println("Box 1 weight after merge: " + boxApple1.getWeight());
        System.out.println("Box 2 weight after merge: " + boxApple2.getWeight());
    }
}