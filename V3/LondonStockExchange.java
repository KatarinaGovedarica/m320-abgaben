package V3;

import java.util.HashMap;
import java.util.Map;

public class LondonStockExchange implements StockExchange {
    private Map<String, Double> prices;

    public LondonStockExchange() {
        prices = new HashMap<>();
        prices.put("Microsoft", 110.0);
        prices.put("Apple", 135.0);
    }

    @Override
    public double getPrice(String stockName) {
        return prices.getOrDefault(stockName, 0.0);
    }
}

