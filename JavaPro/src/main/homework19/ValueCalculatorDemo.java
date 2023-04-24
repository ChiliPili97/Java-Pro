package homework19;

public class ValueCalculatorDemo {
    public static void main(String[] args) {
        ValueCalculator valueCalculator = new ValueCalculator(3_000_000);
        valueCalculator.fillArrays();
        System.out.println(valueCalculator.getElapsedTime());
    }
}
