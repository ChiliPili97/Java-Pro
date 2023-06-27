package math;

import java.util.ArrayList;


class ConcurrentClass {

    public static void main(String[] args) {
        var values = new ArrayList<Integer>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);

        for (Integer val : values) {
            if (val % 2 == 0) values.remove(val);
        }
        System.out.println(values);
    }
}