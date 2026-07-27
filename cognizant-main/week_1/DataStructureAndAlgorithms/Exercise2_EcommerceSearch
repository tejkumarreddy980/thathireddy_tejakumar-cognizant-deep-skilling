class Product {
    int productId;
    String productName;
    String category;
    double price;

    Product(int productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }
}

class SearchAlgorithms {

    // LINEAR SEARCH
    // Goes through every product one by one
    // Works on unsorted arrays
    // Returns index if found, -1 if not found
    static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == targetId) {
                return i;
            }
        }
        return -1;
    }

    // BINARY SEARCH
    // Only works on SORTED array (sorted by productId here)
    // Divides search space in half each time
    // Returns index if found, -1 if not found
    static int binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].productId == targetId) {
                return mid;
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop",        "Electronics", 45000.00),
            new Product(102, "Mobile Phone",  "Electronics", 15000.00),
            new Product(103, "Headphones",    "Electronics",  2500.00),
            new Product(104, "Running Shoes", "Footwear",     3500.00),
            new Product(105, "Backpack",      "Bags",         1500.00),
            new Product(106, "Smartwatch",    "Electronics", 12000.00),
            new Product(107, "Desk Lamp",     "Furniture",    1200.00),
            new Product(108, "Keyboard",      "Electronics",  3000.00)
        };

        System.out.println("=== E-Commerce Platform Search Function ===");
        System.out.println("Total products in catalog: " + products.length);
        System.out.println();

        // --- LINEAR SEARCH TEST ---
        System.out.println("--- Linear Search ---");
        int searchId1 = 105;
        int linearResult = SearchAlgorithms.linearSearch(products, searchId1);

        if (linearResult != -1) {
            System.out.println("Product found at index: " + linearResult);
            System.out.println("Product Name : " + products[linearResult].productName);
            System.out.println("Category     : " + products[linearResult].category);
            System.out.println("Price        : Rs." + products[linearResult].price);
        } else {
            System.out.println("Product with ID " + searchId1 + " not found.");
        }

        System.out.println();

        // --- BINARY SEARCH TEST ---
        System.out.println("--- Binary Search ---");
        int searchId2 = 107;
        int binaryResult = SearchAlgorithms.binarySearch(products, searchId2);

        if (binaryResult != -1) {
            System.out.println("Product found at index: " + binaryResult);
            System.out.println("Product Name : " + products[binaryResult].productName);
            System.out.println("Category     : " + products[binaryResult].category);
            System.out.println("Price        : Rs." + products[binaryResult].price);
        } else {
            System.out.println("Product with ID " + searchId2 + " not found.");
        }

        System.out.println();

        // --- NOT FOUND TEST ---
        System.out.println("--- Searching for non-existing product ---");
        int searchId3 = 999;
        int notFoundResult = SearchAlgorithms.linearSearch(products, searchId3);
        if (notFoundResult == -1) {
            System.out.println("Product with ID " + searchId3 + " not found in catalog.");
        }

        System.out.println();

        // --- COMPARISON SUMMARY ---
        System.out.println("--- Algorithm Comparison ---");
        System.out.println("Linear Search : Checks each element one by one — O(n)");
        System.out.println("Binary Search : Divides search in half each time  — O(log n)");
        System.out.println("Binary Search is faster but needs SORTED data.");
    }
}
