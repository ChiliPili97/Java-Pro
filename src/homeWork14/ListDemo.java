package homeWork14;

import java.util.ArrayList;
import java.util.Arrays;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList("Watermelon", "Cherry", "Apple", "Orange", "Melon",
                "Grape", "Pineapple", "Blueberry", "Grape", "Watermelon", "Melon", "Cherry", "Blackberry", "Grape", "Orange"));
        int[] ints = {1, 2, 3, 4, 56, 7, 8, 2, 2, 3, 4};

        System.out.println(List.countOccurrence(stringArrayList, "Grape"));

        System.out.println(List.toList(ints));

        ArrayList<Integer> intsList = new ArrayList<>(List.toList(ints));
        System.out.println(List.findUnique(intsList));

        List.calcOccurrence(stringArrayList);

        System.out.println(List.findOccurrence(stringArrayList));
    }
}
