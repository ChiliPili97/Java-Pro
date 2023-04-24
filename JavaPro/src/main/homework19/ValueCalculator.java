package homework19;

public class ValueCalculator {
    private float[] arr;
    private int size;
    private int halfSize;
    private long elapsedTime;

    public long getElapsedTime() {
        return elapsedTime;
    }

    public ValueCalculator(int size) {
        if (size < 1_000_000) {
            size = 1_000_000;
        }
        this.size = size;
        this.halfSize = size / 2;
        this.arr = new float[size];
    }

    public void fillArrays() {
        long start = System.currentTimeMillis();
        float[] a1 = new float[arr.length / 2];
        float[] a2 = new float[arr.length / 2];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        System.arraycopy(arr, 0, a1, 0, halfSize);
        System.arraycopy(arr, halfSize, a2, 0, halfSize);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.arraycopy(a1, 0, arr, 0, halfSize);
        System.arraycopy(a2, 0, arr, halfSize, halfSize);

        long end = System.currentTimeMillis();
        elapsedTime = end - start;
    }
}
