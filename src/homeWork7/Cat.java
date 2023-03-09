package homeWork7;

public class Cat extends Animals {

    private static int counterCats;
    public Cat(String name) {
        super(name);
        counterCats++;
    }

    @Override
    public void run (int length){
        if (length > 200){
            throw new IllegalArgumentException("Кіт може пробігти не більше 200м");
        }
        System.out.println(super.name + " пробіг " + length + "м");
    }

    @Override
    public void swim (int length){
        System.out.println("Кіт не вміє плавати");
    }

    public int getCounterCat(){
        return counterCats;
    }
}
