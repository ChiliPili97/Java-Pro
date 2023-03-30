package homeWork13;

import java.util.Arrays;
import java.util.Random;

public class DemoSort {
    public static void main(String[] args) {
        Random rm = new Random();
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = rm.nextInt(100);
        }

        System.out.println("Unsorted array:" + Arrays.toString(array));
        System.out.println("Insertion sort:" + Arrays.toString(SortAlgorithms.insertionSort(array)));
        System.out.println("Bubble sort:" + Arrays.toString(SortAlgorithms.bubbleSort(array)));

    }
}
