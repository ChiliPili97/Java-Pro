package homeWork14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList("Watermelon", "Watermelon",  "Cherry", "Apple", "Orange", "Melon",
                "Grape", "Pineapple", "Blueberry", "Grape", "Watermelon", "Melon", "Cherry", "Blackberry", "Grape", "Orange"));
        int[] ints = {1, 2, 3, 4, 56, 7, 8, 2, 2, 3, 4};

        System.out.println(ListExtended.countOccurrence(stringArrayList, "Grape"));

        System.out.println(ListExtended.toList(ints));

        ArrayList<Integer> intsList = new ArrayList<>(ListExtended.toList(ints));
        System.out.println(ListExtended.findUnique(intsList));

        Map<String, Integer> mapOccurrence = new HashMap<>();
        mapOccurrence = ListExtended.calcOccurrence(stringArrayList);

        System.out.println(ListExtended.findOccurrence(stringArrayList));
    }
}
