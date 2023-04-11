package coffee.order;

import java.util.Objects;

public class Order implements Comparable<Order> {
    private String name;
    private int queueNumber;

    public Order(String name, int queueNumber) {
        this.name = name;
        this.queueNumber = queueNumber;
    }

    @Override
    public int compareTo(Order anotherOrder) {
        return Integer.compare(this.queueNumber, anotherOrder.queueNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return queueNumber == order.queueNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(queueNumber);
    }

    @Override
    public String toString() {
        return queueNumber + " | " + name;
    }
}
