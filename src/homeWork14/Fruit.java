package homeWork14;

public class Fruit {
    public String name;
    public int occurrence;

    public Fruit(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", occurrence=" + occurrence +
                '}';
    }
}
