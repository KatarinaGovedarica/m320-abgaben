package M3;

public class OrderSummary {
    private CoffeeOrder order;
    private double totalPrice;

    public OrderSummary(CoffeeOrder order) {
        this.order = order;
        this.totalPrice = order.calculatePrice();
    }

    public void displaySummary() {
        System.out.println("Order Summary:");
        System.out.println("Coffee Type: " + order.getCoffeeType());
        System.out.println("Size: " + order.getSize());
        System.out.println("Quantity: " + order.getQuantity());
        System.out.println("Total Price: $" + totalPrice);
    }
}
