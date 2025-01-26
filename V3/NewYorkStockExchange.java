package V3;

import java.util.HashMap;
import java.util.Map;

public class NewYorkStockExchange implements StockExchange {
    private Map<String, Double> prices;

    public NewYorkStockExchange() {
        prices = new HashMap<>();
        prices.put("Microsoft", 100.0);
        prices.put("Apple", 130.0);
    }

    @Override
    public double getPrice(String stockName) {
        return prices.getOrDefault(stockName, 0.0);
    }
}

