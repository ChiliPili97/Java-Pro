package homeWork14;

import java.util.ArrayList;


public class List {

    public static int countOccurrence(ArrayList<String> list, String target) {
        int count = 0;

        for (String str : list) {
            if (str.equals(target)) {
                count++;
            }
        }
        return count;
    }

    public static ArrayList<Integer> toList(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int j : array) {
            list.add(j);
        }
        return list;
    }

    public static ArrayList<Integer> findUnique(ArrayList<Integer> sourceList) {
        ArrayList<Integer> uniqueList = new ArrayList<>();

        for (Integer i : sourceList) {
            if (!uniqueList.contains(i)) {
                uniqueList.add(i);
            }
        }
        return uniqueList;
    }

    public static void calcOccurrence(ArrayList<String> list) {
        ArrayList<String> uniqueList = new ArrayList<>();

        for (String string : list) {
            int count = countOccurrence(list, string);
            if (!uniqueList.contains(string)) {
                System.out.printf("%s: %d%n", string, count);
                uniqueList.add(string);
            }
        }
    }

    public static ArrayList<Fruit> findOccurrence(ArrayList<String> list) {
        ArrayList<String> uniqueList = new ArrayList<>();
        ArrayList<Fruit> fruits = new ArrayList<>();

        for (String string : list) {
            int count = countOccurrence(list, string);
            if (!uniqueList.contains(string)) {
                fruits.add(new Fruit(string, count));
                uniqueList.add(string);
            }
        }
        return fruits;
    }
}

