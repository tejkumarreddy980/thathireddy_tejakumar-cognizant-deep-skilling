import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {

    interface Observer {
        void update(String stockName, double newPrice);
    }

    interface Stock {
        void registerObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers();
    }

    static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private String stockName;
        private double stockPrice;

        public void setStockPrice(String stockName, double stockPrice) {
            this.stockName = stockName;
            this.stockPrice = stockPrice;
            notifyObservers();
        }

        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockName, stockPrice);
            }
        }
    }

    static class MobileApp implements Observer {
        private String user;

        public MobileApp(String user) {
            this.user = user;
        }

        public void update(String stockName, double newPrice) {
            System.out.println("MobileApp (" + user + "): " + stockName + " is now ₹" + newPrice);
        }
    }

    static class WebApp implements Observer {
        private String user;

        public WebApp(String user) {
            this.user = user;
        }

        public void update(String stockName, double newPrice) {
            System.out.println("WebApp (" + user + "): " + stockName + " updated to ₹" + newPrice);
        }
    }

    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileUser = new MobileApp("Alice");
        Observer webUser = new WebApp("Bob");

        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

        System.out.println("\nStock update #1:");
        stockMarket.setStockPrice("TCS", 3540.25);

        System.out.println("\nStock update #2:");
        stockMarket.setStockPrice("INFY", 1510.75);

        stockMarket.removeObserver(mobileUser);

        System.out.println("\nStock update #3 (after Alice unsubscribed):");
        stockMarket.setStockPrice("HCL", 1225.00);
    }
}
