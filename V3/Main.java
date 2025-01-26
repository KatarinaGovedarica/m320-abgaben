package V3;
public class Main {
    public static void main(String[] args) {

        Portfolio portfolio = new Portfolio();
        portfolio.addStock("Microsoft");
        portfolio.addStock("Apple");

        StockExchange zurich = new ZurichStockExchange();
        StockExchange ny = new NewYorkStockExchange();
        StockExchange london = new LondonStockExchange();

        portfolio.displayValues(zurich);
        portfolio.displayValues(ny);
        portfolio.displayValues(london);
    }
}
