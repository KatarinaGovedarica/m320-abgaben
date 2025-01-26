package V3;

import java.util.HashMap;
import java.util.Map;

public class ZurichStockExchange implements StockExchange {
    private Map<String, Double> prices;

    public ZurichStockExchange() {
        prices = new HashMap<>();
        prices.put("Microsoft", 120.0);
        prices.put("Apple", 140.0);
    }

    @Override
    public double getPrice(String stockName) {
        return prices.getOrDefault(stockName, 0.0);
    }
}

