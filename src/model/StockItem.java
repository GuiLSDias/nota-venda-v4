package model;

public class StockItem {
    private Product product;
    private int quantity;

    public StockItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable(int requiredQuantity) {
        return quantity >= requiredQuantity;
    }
}
