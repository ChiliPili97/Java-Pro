package coffee.order;

import java.util.*;

public class CoffeeOrderBoard {

    private TreeSet<Order> queue = new TreeSet<>();
    private int queueNumber = 1;

    public void add(String name) {
        queue.add(new Order(name, queueNumber));
        queueNumber++;
    }

    public void deliver() {
        queue.pollFirst();
    }

    public void deliver(int queueNumber) {
        queue.remove(new Order("", queueNumber));
    }

    public void draw() {
        System.out.println("Num | name");
        for (Order order : queue) {
            System.out.println(order);
        }
    }
}

