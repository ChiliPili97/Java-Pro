import java.time.LocalDateTime;

public class Product {
    private String typ;
    private double price;
    private boolean discount;
    private LocalDateTime timestamp;

    public Product(String typ, long price, boolean discount) {
        this.typ = typ;
        this.price = price;
        this.discount = discount;
        this.timestamp = LocalDateTime.now();
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Product{" +
                "typ='" + typ + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", timestamp=" + timestamp +
                '}';
    }
}


