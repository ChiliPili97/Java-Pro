import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ProductDemo {
    public static void main(String[] args) {

        Product p1 = new Product(ProductType.BOOK, 150, true);
        Product p2 = new Product(ProductType.BOOK, 300, false);
        Product p3 = new Product(ProductType.BOOK, 265, true);
        Product p4 = new Product(ProductType.BOOK, 210, false);
        Product p5 = new Product(ProductType.CAR, 15200, true);
        Product p6 = new Product(ProductType.BIKE, 7000, true);
        Product p7 = new Product(ProductType.BOOK, 60, true);
        Product p8 = new Product(ProductType.BOOK, 40, false);
        List<Product> products = List.of(p1, p2, p3, p4, p5, p6, p7, p8);

        //System.out.println("Books with price over then 250:" + getBookOverPrice(products));
        //System.out.println("Books with discount 10 %:" + getBookWithDiscount(products, 0.1f));
        //System.out.println("Cheapest book costs: " + getCheapestBook(products).getPrice());
        System.out.println("Last three added products:" + getLastThreeAdded(products));
        //System.out.println(getTotalCost(products));
        //System.out.println(groupByType(products));

    }

    public static List<Product> getBookOverPrice(List<Product> list) {
        return list.stream()
                .filter(p -> p.getType() == ProductType.BOOK && p.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> getBookWithDiscount(List<Product> list, float discount) {
        return list.stream()
                .filter(p -> p.getType() == ProductType.BOOK && p.isHasDiscount())
                .peek(p -> p.setPrice(Math.round(p.getPrice() * (1 - discount))))
                .collect(Collectors.toList());
    }

    public static Product getCheapestBook(List<Product> list) {
        Optional<Product> result = list.stream()
                .filter(p -> p.getType() == ProductType.BOOK)
                .min((x, y) -> (int) (x.getPrice() - y.getPrice()));
        if (result.isPresent()){
            return result.get();
        } else {
            throw new NullPointerException("Product book not found");
        }
    }

    public static List<Product> getLastThreeAdded(List<Product> list) {
        return list.stream().skip(list.size() - 3)
                .collect(Collectors.toList());
    }

    public static double getTotalCost(List<Product> list) {
        return list.stream()
                .filter(p -> p.getType() == ProductType.BOOK)
                .filter(p -> p.getPrice() < 75)
                .filter(p -> p.getCreateAt().getYear() == LocalDateTime.now().getYear())
                .collect(Collectors.summingDouble(Product::getPrice));
    }

    public static Map<ProductType, List<Product>> groupByType(List<Product> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}
