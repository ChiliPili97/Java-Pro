package coffee.order;

import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CoffeeOrderBoard {
    private Map<Long, Order> orders = new HashMap<Long, Order>();
    private long numberOfOrders;
    private static final Logger LOGGER = Logger.getLogger(CoffeeOrderBoard.class.getName());
    private static final String DEFAULT_PATH_FOR_LOG = "D:/Log.txt";
    private String pathForLog;
    private FileHandler fh;

    public CoffeeOrderBoard() {
        setPathForLog(DEFAULT_PATH_FOR_LOG);
    }

    public String getPathForLog() {
        return pathForLog;
    }

    public void setPathForLog(String pathForLog) {
        this.pathForLog = pathForLog;
        try {
            fh = new FileHandler(pathForLog);
            LOGGER.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Rise new run time exception", e);
            throw new RuntimeException(e);
        }
    }

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
