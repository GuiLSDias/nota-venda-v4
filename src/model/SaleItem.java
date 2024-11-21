package model;

public class SaleItem {
    private ProductSpecification product;
    private int quantity;

    public SaleItem(ProductSpecification product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductSpecification getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
}
