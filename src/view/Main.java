package view;

import model.*;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();
        stock.addItem(new StockItem(new ProductSpecification("Rice", 30), 10));
        stock.addItem(new StockItem(new ProductSpecification("Beans", 20), 5));
        stock.addItem(new StockItem(new ProductSpecification("Pasta", 15), 20));

        SalesManager salesManager = new SalesManager(stock);

        String[][] products = {
                {"Rice", "2"},
                {"Beans", "1"},
                {"Pasta", "6"}
        };

        Sale sale = salesManager.processSale(products, "credit card");

        System.out.println("\nSold Items:");
        sale.getItems().forEach(item -> {
            System.out.printf("Product: %s, Quantity: %d, Subtotal: %.2f%n",
                    item.getProduct().getDescription(), item.getQuantity(), item.getSubtotal());
        });

        System.out.printf("\nPayment Method: %s%n", sale.getPaymentMethod());
        System.out.printf("Total Amount: %.2f%n", sale.getTotalAmount());
    }
}
