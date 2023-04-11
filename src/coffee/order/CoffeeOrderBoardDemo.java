package coffee.order;

public class CoffeeOrderBoardDemo {
    public static void main(String[] args) {
        CoffeeOrderBoard cob = new CoffeeOrderBoard();

        cob.add("Andrii");
        cob.add("Ivan");
        cob.add("Sergii");
        cob.add("Oleksandr");
        cob.add("Roman");
        //cob.draw();
        cob.deliver();
        cob.draw();
        cob.deliver(4);
        System.out.println("");
        cob.draw();
    }
}
