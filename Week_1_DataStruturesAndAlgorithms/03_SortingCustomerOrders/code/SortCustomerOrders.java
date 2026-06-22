import java.util.Scanner;

public class SortCustomerOrders {

    static class Order {
        String orderId;
        String customerName;
        double totalPrice;

        public Order(String orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public String toString() {
            return "OrderID: " + orderId + ", Customer: " + customerName + ", Total: ₹" + totalPrice;
        }
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void printOrders(String title, Order[] orders) {
        System.out.println("\n" + title);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order("O101", "Alice", 4500.50),
            new Order("O102", "Bob", 2200.00),
            new Order("O103", "Charlie", 7500.00),
            new Order("O104", "David", 1200.00),
            new Order("O105", "Eve", 5000.00)
        };

        Order[] bubbleSorted = orders.clone();
        Order[] quickSorted = orders.clone();

        bubbleSort(bubbleSorted);
        quickSort(quickSorted, 0, quickSorted.length - 1);

        printOrders("Sorted using Bubble Sort:", bubbleSorted);
        printOrders("Sorted using Quick Sort:", quickSorted);
    }
}
