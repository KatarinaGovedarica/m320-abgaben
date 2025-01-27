package M3;

public class DebitCardPayment implements PaymentMethod {
    private String cardNumber;
    private String bankName;

    public DebitCardPayment(String cardNumber, String bankName) {
        this.cardNumber = cardNumber;
        this.bankName = bankName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Debit Card from " + bankName);
    }
}

