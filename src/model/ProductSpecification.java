package model;

public class ProductSpecification {
    private String description;
    private double price;

    public ProductSpecification(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
