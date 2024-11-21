package model;

public class SalesManager {
    private Stock estoque;

    public SalesManager(Stock estoque) {
        this.estoque = estoque;
    }

    public boolean processSale(Sale sale, String description, double price, int quantity) {
        if (estoque.hasProduct(description, quantity)) {
            sale.addProduct(description, price, quantity);
            estoque.updateStock(description, quantity);
            return true;
        }
        return false;
    }
}
