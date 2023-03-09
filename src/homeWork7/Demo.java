package homeWork7;

public class Demo {
    public static void main(String[] args) {

        Dog dogBobik = new Dog("Бобік");
        Dog dogSirko = new Dog("Сірко");
        Cat catRizhik = new Cat("Рижик");

        dogBobik.run(300);
        catRizhik.swim(50);

        System.out.println(dogSirko.getCounterAnimals());
        System.out.println(dogSirko.getCounterDogs());
        System.out.println(catRizhik.getCounterCat());
    }
}
