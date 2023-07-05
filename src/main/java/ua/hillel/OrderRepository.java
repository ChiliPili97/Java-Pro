package ua.hillel;

import org.springframework.stereotype.Repository;
import ua.hillel.entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Repository
public class OrderRepository {

    private List<Order> orders = new ArrayList<>();

    public Order getOrderByID(long id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        Objects.requireNonNull(order);
        orders.add(order);
    }
}
