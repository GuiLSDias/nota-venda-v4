package view;

import model.PaymentMethod;
import model.Product;
import model.Sale;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Sale sale = new Sale();
        addProductsToSale(sale);

        displaySaleDetails(sale);

        String paymentMethod = getPaymentMethodFromUser();

        double finalAmount = PaymentMethod.calculateFinalAmount(sale.getTotal(), paymentMethod);
        double difference = finalAmount - sale.getTotal();

        displayInvoice(sale, paymentMethod, finalAmount, difference);
    }

    private static void addProductsToSale(Sale sale) {
        sale.addProduct("Arroz", 30, 2);
        sale.addProduct("Feijão", 20, 1);
        sale.addProduct("Pasta", 15 , 6);
    }

    private static void displaySaleDetails(Sale sale) {
        System.out.println("\n=== Itens Vendidos ===");
        sale.getItems().forEach(System.out::println);
        System.out.printf("Total: R$ %.2f%n", sale.getTotal());
    }

    private static String getPaymentMethodFromUser() {
        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1. Cartão de Crédito (5% de juros)");
        System.out.println("2. Cartão de Débito (sem juros ou desconto)");
        System.out.println("3. Dinheiro/Pix (5% de desconto)");
        System.out.print("Digite o número correspondente: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                return "Cartão de Crédito";
            case 2:
                return "Cartão de Débito";
            case 3:
                return "Dinheiro";
            default:
                System.out.println("Opção inválida! Usando Cartão de Débito por padrão.");
                return "Cartão de Débito";
        }
    }

    private static void displayInvoice(Sale sale, String paymentMethod, double finalAmount, double difference) {
        System.out.println("\n=== Nota de Venda ===");
        sale.getItems().forEach(System.out::println);
        System.out.printf("Total Bruto: R$ %.2f%n", sale.getTotal());
        System.out.printf("Forma de Pagamento: %s%n", paymentMethod);

        if (difference > 0) {
            System.out.printf("Juros: R$ %.2f%n", difference);
        } else if (difference < 0) {
            System.out.printf("Desconto: R$ %.2f%n", -difference);
        }

        System.out.printf("Valor Final a Pagar: R$ %.2f%n", finalAmount);
    }
}
