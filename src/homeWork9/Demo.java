package homeWork9;

public class Demo {
    public static void main(String[] args) {

        ArrayValueCalculator arrayValueCalculator = new ArrayValueCalculator();
        String[][] array = new String[][]{
                new String[]{"i", "2", "3", "4"},
                new String[]{"1", "2", "3", "4"},
                new String[]{"1", "2", "3", "4"},
                new String[]{"1", "2", "3", "4"}
        };

        System.out.println(arrayValueCalculator.doCalc(array));
    }
}
