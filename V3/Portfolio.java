package V3;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<String> stocks;

    public Portfolio() {
        stocks = new ArrayList<>();
    }

    public void addStock(String stockName) {
        stocks.add(stockName);
    }

    public void displayValues(StockExchange exchange) {
        System.out.println("Stock values at " + exchange.getClass().getSimpleName() + ":");
        for (String stock : stocks) {
            double price = exchange.getPrice(stock);
            System.out.println("  " + stock + ": " + price + " CHF/USD");
        }
    }
}

