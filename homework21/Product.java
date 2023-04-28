import java.time.LocalDateTime;
import java.util.Objects;

public class Product {
    private ProductType type;
    private double price;
    private boolean hasDiscount;
    private LocalDateTime createAt;

    public Product(ProductType type, long price, boolean hasDiscount) {
        this.type = type;
        this.price = price;
        this.hasDiscount = hasDiscount;
        this.createAt = LocalDateTime.now();
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", hasDiscount=" + hasDiscount +
                ", createAt=" + createAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && hasDiscount == product.hasDiscount && Objects.equals(type, product.type) && Objects.equals(createAt, product.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price, hasDiscount, createAt);
    }
}


