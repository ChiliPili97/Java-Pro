
public class Box<T extends Fruit> {

    private T typeOfFruit;
    private int amountOfFruit;

    public void add(T fruit) {
        setTypeOfFruit(fruit);
        if (isTypeEquals(fruit)) {
            amountOfFruit++;
        } else {
            System.out.println("This box contains another type of fruit");
        }
    }

    public void add(T fruit, int quantity) {
        setTypeOfFruit(fruit);
        if (isTypeEquals(fruit)) {
            amountOfFruit += quantity;
        } else {
            System.out.println("This box contains another type of fruit");
        }
    }

    public boolean compare(Box b) {
        return b.getWeight() == getWeight();
    }

    public void merge(Box b) {
        if (isTypeEquals((T) b.getTypeOfFruit())) {
            this.amountOfFruit += b.getAmountOfFruit();
            b.setAmountOfFruit(0);
        } else {
            System.out.println("This box contains another type of fruit");
        }
    }

    public float getWeight() {
        return amountOfFruit * typeOfFruit.weight;
    }

    private boolean isTypeEquals(T fruit) {
        return fruit.getClass() == typeOfFruit.getClass();
    }

    private void setTypeOfFruit(T type) {
        if (amountOfFruit == 0) {
            this.typeOfFruit = type;
        }
    }

    public T getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getAmountOfFruit() {
        return amountOfFruit;
    }

    public void setAmountOfFruit(int amountOfFruit) {
        this.amountOfFruit = amountOfFruit;
    }
}
