package M3;

public class Main {
    public static void main(String[] args) {
        CoffeeOrder order = new CoffeeOrder("Latte", "Medium", 2);
        OrderSummary summary = new OrderSummary(order);

        summary.displaySummary();


        PaymentMethod payment = new CreditCardPayment("1234567890123456", "12/24");
        payment.pay(order.calculatePrice());
    }
}

