import java.util.HashMap;
import java.util.Scanner;

public class Inventory_management_System {

    static class Product {
        int productId;
        String productName;
        int quantity;
        double price;

        Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        void display() {
            System.out.println("Product ID : " + productId);
            System.out.println("Product Name : " + productName);
            System.out.println("Quantity : " + quantity);
            System.out.println("Price : " + price);
            System.out.println();
        }
    }

    static class Inventory {
        HashMap<Integer, Product> products = new HashMap<>();

        void addProduct(Product product) {
            if (products.containsKey(product.productId)) {
                System.out.println("Product already exists.");
            } else {
                products.put(product.productId, product);
                System.out.println("Product added successfully.");
            }
        }

        void updateProduct(int id, String name, int quantity, double price) {
            if (products.containsKey(id)) {
                Product p = products.get(id);
                p.productName = name;
                p.quantity = quantity;
                p.price = price;
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product not found.");
            }
        }

        void deleteProduct(int id) {
            if (products.containsKey(id)) {
                products.remove(id);
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product not found.");
            }
        }

        void displayProducts() {
            if (products.isEmpty()) {
                System.out.println("Inventory is empty.");
            } else {
                for (Product p : products.values()) {
                    p.display();
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    inventory.addProduct(new Product(id, name, quantity, price));
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Product Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter New Quantity: ");
                    quantity = sc.nextInt();

                    System.out.print("Enter New Price: ");
                    price = sc.nextDouble();

                    inventory.updateProduct(id, name, quantity, price);
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    id = sc.nextInt();
                    inventory.deleteProduct(id);
                    break;

                case 4:
                    inventory.displayProducts();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}