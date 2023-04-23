package homework19;

public class ValueCalculator {
    int[] arr = new int[1_000_000];
    private int size = arr.length;
    private int halfSize = arr.length / 2;

    public int getSize() {
        return size;
    }

    public int getHalfSize() {
        return halfSize;
    }

    public void fillArray() {
        long start = System.currentTimeMillis();
        int[] a1 = new int[halfSize];
        int[] a2 = new int[halfSize];;
        for (int i = 0; i < getSize(); i++){
            arr[i] = 1;
        }

        //System.arraycopy(arr, 0, a1, halfSize);





        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
