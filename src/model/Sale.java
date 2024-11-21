package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<SaleItem> items = new ArrayList<>();
    private String paymentMethod;
    private double totalAmount;

    public void addItem(SaleItem saleItem) {
        items.add(saleItem);
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void calculateTotal() {
        totalAmount = items.stream().mapToDouble(SaleItem::getSubtotal).sum();
        if ("credit card".equalsIgnoreCase(paymentMethod)) {
            totalAmount *= 1.05;
        } else if ("cash/pix".equalsIgnoreCase(paymentMethod)) {
            totalAmount *= 0.95;
        }
    }
}
