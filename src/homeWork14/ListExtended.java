package homeWork14;

import java.util.*;


public class ListExtended {

    public static int countOccurrence(List<String> words, String target) {
        Objects.requireNonNull(words);
        Objects.requireNonNull(target);
        int count = 0;

        for (String str : words) {
            if (str.equals(target)) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();

        for (int number : array) {
            list.add(number);
        }
        return list;
    }

    public static List<Integer> findUnique(List<Integer> sourceList) {
        List<Integer> uniqueList = new ArrayList<>();

        for (Integer number : sourceList) {
            if (!uniqueList.contains(number)) {
                uniqueList.add(number);
            }
        }
        return uniqueList;
    }

    public static Map<String, Integer> calcOccurrence(List<String> words) {
        List<String> uniqueList = new ArrayList<>();
        Map<String, Integer> mapOccurrence = new HashMap<>();

        for (String string : words) {
            int count = countOccurrence(words, string);
            if (!uniqueList.contains(string)) {
                mapOccurrence.put(string, count);
                uniqueList.add(string);
            }
        }
        return mapOccurrence;
    }

    public static List<Fruit> findOccurrence(List<String> words) {
        List<Fruit> fruits = new ArrayList<>();

        for (String string : words) {
            int count = countOccurrence(words, string);
            if (!fruits.contains(new Fruit(string, count))) {
                fruits.add(new Fruit(string, count));
            }
        }
        return fruits;
    }
}

