package model;

public class StockItem {
    private ProductSpecification product;
    private int quantity;

    public StockItem(ProductSpecification product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductSpecification getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity(int soldQuantity) {
        this.quantity -= soldQuantity;
    }
}
