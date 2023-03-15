package homeWork7;

public class Dog extends Animal {

    private static int dogsCounter;

    public Dog(String name) {
        super(name);
        dogsCounter++;
    }

    @Override
    public void run(int length) {
        if (length > 500) {
            throw new IllegalArgumentException("Собака може пробігти не більше 500м");
        }
        System.out.println(super.name + " пробіг " + length + "м");
    }

    @Override
    public void swim(int length) {
        if (length > 10) {
            throw new IllegalArgumentException("Собака може пропливти не більше 10м");
        }
        System.out.println(super.name + " проплив " + length + "м");
    }

    public int getDogsCounter() {
        return dogsCounter;
    }
}
