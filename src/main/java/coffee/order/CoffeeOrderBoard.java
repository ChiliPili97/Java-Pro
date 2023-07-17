package coffee.order;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;


public class CoffeeOrderBoard {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeOrderBoard.class);//Logger.getLogger(CoffeeOrderBoard.class.getName());
    private long numberOfOrders;
    private Map<Long, Order> orders = new HashMap<Long, Order>();

    public void add(Order order) {
        Objects.requireNonNull(order);
        order.setNumber(++numberOfOrders);
        orders.put(order.getNumber(), order);
        LOGGER.info("Added new order \t num: %d, name: %s"
                .formatted(order.getNumber(), order.getName()));
    }

    public void delivery() {
        LOGGER.info("Delivered last order \t num: %d, name: %s"
                .formatted(orders.get(numberOfOrders).getNumber(), orders.get(numberOfOrders).getName()));
        orders.remove(numberOfOrders);
    }

    public void delivery(long number) {
        LOGGER.info("Delivered order \t num: %d, name: %s"
                .formatted(orders.get(numberOfOrders).getNumber(), orders.get(numberOfOrders).getName()));
        orders.remove(numberOfOrders);
        Objects.requireNonNull(number);
        orders.remove(number);
    }

    public void draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("===============\n");
        sb.append("Num | Name\n");
        for (Order order : orders.values()) {
            sb.append(order.getNumber() + " | " + order.getName() + "\n");
        }
        LOGGER.info(sb.toString());
    }
}
