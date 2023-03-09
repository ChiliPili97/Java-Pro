package homeWork7;

public abstract class Animals {

    private static int counter;
    public String name;

    public Animals(String name) {
        this.name = name;
        counter++;
    }

    public abstract void run (int length);

    public abstract void swim (int length);

    public int getCounterAnimals(){
        return counter;
    }
}
