package model;

public class PaymentMethod {
    public static double calculateFinalAmount(double total, String paymentMethod) {
        switch (paymentMethod.toLowerCase()) {
            case "cartão de crédito":
                return total * 1.05;
            case "dinheiro":
            case "pix":
                return total * 0.95;
            case "cartão de débito":
                return total;
            default:
                throw new IllegalArgumentException("Forma de pagamento inválida!");
        }
    }
}
