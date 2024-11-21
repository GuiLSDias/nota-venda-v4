package model;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<StockItem> items = new ArrayList<>();

    public void addItem(StockItem stockItem) {
        items.add(stockItem);
    }

    public boolean hasProduct(String description, int quantity) {
        return items.stream()
                .anyMatch(item -> item.getProduct().getDescription().equals(description) && item.getQuantity() >= quantity);
    }

    public void removeProduct(String description, int quantity) {
        for (StockItem item : items) {
            if (item.getProduct().getDescription().equals(description)) {
                item.decreaseQuantity(quantity);
                break;
            }
        }
    }

    public List<StockItem> getItems() {
        return items;
    }
}
