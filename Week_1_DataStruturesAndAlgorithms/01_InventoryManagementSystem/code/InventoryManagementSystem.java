import java.util.HashMap;
import java.util.Scanner;

public class InventoryManagementSystem {

    static class Product {
        private String productId;
        private String productName;
        private int quantity;
        private double price;

        public Product(String productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String toString() {
            return "ProductID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: ₹" + price;
        }
    }

    static class Inventory {
        private HashMap<String, Product> products = new HashMap<>();

        public void addProduct(Product product) {
            products.put(product.productId, product);
            System.out.println("Product added.");
        }

        public void updateProduct(String productId, int newQuantity, double newPrice) {
            Product product = products.get(productId);
            if (product != null) {
                product.setQuantity(newQuantity);
                product.setPrice(newPrice);
                System.out.println("Product updated.");
            } else {
                System.out.println("Product not found.");
            }
        }

        public void deleteProduct(String productId) {
            if (products.remove(productId) != null) {
                System.out.println("Product deleted.");
            } else {
                System.out.println("Product not found.");
            }
        }

        public void displayAllProducts() {
            if (products.isEmpty()) {
                System.out.println("No products in inventory.");
            } else {
                for (Product p : products.values()) {
                    System.out.println(p);
                }
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Product\n2. Update Product\n3. Delete Product\n4. Show All Products\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter Product ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Quantity: ");
                int qty = scanner.nextInt();
                System.out.print("Enter Price: ");
                double price = scanner.nextDouble();
                inventory.addProduct(new Product(id, name, qty, price));
            } else if (choice == 2) {
                System.out.print("Enter Product ID to update: ");
                String id = scanner.nextLine();
                System.out.print("Enter New Quantity: ");
                int qty = scanner.nextInt();
                System.out.print("Enter New Price: ");
                double price = scanner.nextDouble();
                inventory.updateProduct(id, qty, price);
            } else if (choice == 3) {
                System.out.print("Enter Product ID to delete: ");
                String id = scanner.nextLine();
                inventory.deleteProduct(id);
            } else if (choice == 4) {
                inventory.displayAllProducts();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
