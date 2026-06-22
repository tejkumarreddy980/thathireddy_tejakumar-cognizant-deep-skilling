import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ECommerceSearch {

    
    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return "ProductID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

   
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // Sample data
        Product[] productList = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Keyboard", "Electronics"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Bag", "Travel")
        };

        // Scanner to get user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String searchName = scanner.nextLine();

        // --- Linear Search ---
        System.out.println("\n🔍 Linear Search:");
        Product resultLinear = linearSearch(productList, searchName);
        if (resultLinear != null) {
            System.out.println("Product found: " + resultLinear);
        } else {
            System.out.println("Product not found.");
        }

        // Sort productList by productName for binary search
        Arrays.sort(productList, Comparator.comparing(p -> p.productName.toLowerCase()));

        // --- Binary Search ---
        System.out.println("\n🔍 Binary Search:");
        Product resultBinary = binarySearch(productList, searchName);
        if (resultBinary != null) {
            System.out.println("Product found: " + resultBinary);
        } else {
            System.out.println("Product not found.");
        }

        scanner.close();
    }
}
