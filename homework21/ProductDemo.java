import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ProductDemo {
    public static void main(String[] args) {

        Product p1 = new Product("Book", 150, true);
        Product p2 = new Product("Book", 300, false);
        Product p3 = new Product("Book", 265, true);
        Product p4 = new Product("Book", 210, false);
        Product p5 = new Product("Car", 15200, true);
        Product p6 = new Product("Bike", 7000, true);
        Product p7 = new Product("Book", 60, true);
        Product p8 = new Product("Book", 40, false);
        List<Product> products = List.of(p1, p2, p3, p4, p5, p6, p7, p8);

        /*System.out.println(getBookOverPrice(products));
        System.out.println(getBookWithDiscount(products, 0.1f));
        Optional<Product> cheapestBook = getCheapestBook(products);
        if (cheapestBook.isPresent()){
            System.out.println("Cheapest book costs: " + cheapestBook.get().getPrice());
        } else {
            System.out.println("Product book not found");
        }
        System.out.println(getLastThreeAdded(products));
        System.out.println(getTotalCost(products));*/
        System.out.println(groupByType(products));

    }

    public static List<Product> getBookOverPrice(List<Product> list) {
        return list.stream()
                .filter(p -> p.getTyp() == "Book" && p.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> getBookWithDiscount(List<Product> list, float discount) {
        return list.stream()
                .filter(p -> p.getTyp() == "Book" && p.isDiscount())
                .peek(p -> p.setPrice(Math.round(p.getPrice() * (1 - discount))))
                .collect(Collectors.toList());
    }

    public static Optional<Product> getCheapestBook(List<Product> list) {
        Optional<Product> cheapestBook = list.stream()
                .filter(p -> p.getTyp() == "Book")
                .min((x, y) -> (int) (x.getPrice() - y.getPrice()));
        return cheapestBook;
    }

    public static List<Product> getLastThreeAdded(List<Product> list) {
        return list.stream().sorted(Comparator.comparing(Product::getTimestamp).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static double getTotalCost(List<Product> list) {
        return list.stream()
                .filter(p -> p.getTyp() == "Book" && p.getPrice() < 75 && p.getTimestamp().getYear() == LocalDateTime.now().getYear())
                .collect(Collectors.summingDouble(Product::getPrice));
    }

    public static Map<String, List<Product>> groupByType(List<Product> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Product::getTyp));
    }
}
