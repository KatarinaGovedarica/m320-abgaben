package M3;

public class CoffeeOrder {
    private String coffeeType;
    private String size;
    private int quantity;

    public CoffeeOrder(String coffeeType, String size, int quantity) {
        this.coffeeType = coffeeType;
        this.size = size;
        this.quantity = quantity;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public String getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculatePrice() {
        double basePrice = switch (coffeeType.toLowerCase()) {
            case "latte" -> 5.0;
            case "cappuccino" -> 4.5;
            case "espresso" -> 3.0;
            default -> 2.5;
        };
        double sizeMultiplier = switch (size.toLowerCase()) {
            case "small" -> 1.0;
            case "medium" -> 1.5;
            case "large" -> 2.0;
            default -> 1.0;
        };
        return basePrice * sizeMultiplier * quantity;
    }
}


