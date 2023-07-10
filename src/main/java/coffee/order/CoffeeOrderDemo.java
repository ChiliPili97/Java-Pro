package coffee.order;

public class CoffeeOrderDemo {
    public static void main(String[] args) {
        Order order_1 = new Order("Ivan");
        Order order_2 = new Order("Andrii");
        Order order_3 = new Order("Vasil");
        Order order_4 = new Order("Olena");
        Order order_5 = new Order("Oleksandr");
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add(order_1);
        coffeeOrderBoard.add(order_2);
        coffeeOrderBoard.delivery();
        coffeeOrderBoard.add(order_3);
        coffeeOrderBoard.add(order_4);
        coffeeOrderBoard.add(order_5);
        coffeeOrderBoard.draw();
        coffeeOrderBoard.delivery(4);
        coffeeOrderBoard.draw();

    }
}
