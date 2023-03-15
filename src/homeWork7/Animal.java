package homeWork7;

public abstract class Animal {

    private static int counter;
    public String name;

    public Animal(String name) {
        this.name = name;
        counter++;
    }

    public abstract void run(int length);

    public abstract void swim(int length);

    public static int getAnimalCounter() {
        return counter;
    }
}
