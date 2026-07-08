public class Exercise07_ObserverStockDemo {
    public static void main(String[] args) {
        StockMarketTicker ticker = new StockMarketTicker();

        ticker.addObserver(new MobileTraderObserver("Asha"));
        ticker.addObserver(new EmailAlertObserver("Ravi"));

        ticker.setStockPrice("TCS", 3900.75);
        ticker.setStockPrice("TCS", 3925.10);
    }
}

interface StockPriceObserver {
    void update(String symbol, double price);
}

interface StockPriceSubject {
    void addObserver(StockPriceObserver observer);

    void removeObserver(StockPriceObserver observer);

    void notifyObservers();
}

final class StockMarketTicker implements StockPriceSubject {
    private final java.util.List<StockPriceObserver> observers = new java.util.ArrayList<>();
    private String symbol;
    private double price;

    public void setStockPrice(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        notifyObservers();
    }

    @Override
    public void addObserver(StockPriceObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockPriceObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (StockPriceObserver observer : observers) {
            observer.update(symbol, price);
        }
    }
}

final class MobileTraderObserver implements StockPriceObserver {
    private final String traderName;

    MobileTraderObserver(String traderName) {
        this.traderName = traderName;
    }

    @Override
    public void update(String symbol, double price) {
        System.out.println("Mobile alert for " + traderName + ": " + symbol + " is now " + price);
    }
}

final class EmailAlertObserver implements StockPriceObserver {
    private final String traderName;

    EmailAlertObserver(String traderName) {
        this.traderName = traderName;
    }

    @Override
    public void update(String symbol, double price) {
        System.out.println("Email alert for " + traderName + ": " + symbol + " changed to " + price);
    }
}