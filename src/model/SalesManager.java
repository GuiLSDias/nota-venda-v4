package model;

public class SalesManager {
    private Stock stock;

    public SalesManager(Stock stock) {
        this.stock = stock;
    }

    public Sale processSale(String[][] products, String paymentMethod) {
        Sale sale = new Sale();

        for (String[] product : products) {
            String description = product[0];
            int quantity = Integer.parseInt(product[1]);

            if (stock.hasProduct(description, quantity)) {
                stock.removeProduct(description, quantity);
                ProductSpecification productSpec = stock.getItems().stream()
                        .filter(item -> item.getProduct().getDescription().equals(description))
                        .findFirst()
                        .get()
                        .getProduct();

                SaleItem saleItem = new SaleItem(productSpec, quantity);
                sale.addItem(saleItem);
            } else {
                throw new RuntimeException("Insufficient stock for product: " + description);
            }
        }

        sale.setPaymentMethod(paymentMethod);
        sale.calculateTotal();
        return sale;
    }
}
