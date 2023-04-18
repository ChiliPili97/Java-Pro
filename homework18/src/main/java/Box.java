import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addFruits(List<T> fruits) {
        this.fruits.addAll(fruits);
    }

    public float getWeight() {
        float totalWeight = 0.0F;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001;
    }

    public void merge(Box<T> otherBox) {
        if (this == otherBox) {
            return;
        }
        if (this.fruits.size() == 0) {
            this.fruits.addAll(otherBox.fruits);
            otherBox.fruits.clear();
        } else if (this.fruits.get(0).getClass() == otherBox.fruits.get(0).getClass()) {
            this.fruits.addAll(otherBox.fruits);
            otherBox.fruits.clear();
        } else {
            throw new IllegalArgumentException("Cannot merge boxes with different types of fruits.");
        }
    }
}
