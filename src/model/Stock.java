package model;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<StockItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        items.add(new StockItem(product, quantity));
    }

    public boolean hasProduct(String description, int requiredQuantity) {
        for (StockItem item : items) {
            if (item.getProduct().getDescription().equalsIgnoreCase(description) &&
                    item.isAvailable(requiredQuantity)) {
                return true;
            }
        }
        return false;
    }

    public void updateStock(String description, int soldQuantity) {
        for (StockItem item : items) {
            if (item.getProduct().getDescription().equalsIgnoreCase(description)) {
                item.setQuantity(item.getQuantity() - soldQuantity);
            }
        }
    }

    public List<StockItem> getItems() {
        return items;
    }
}
