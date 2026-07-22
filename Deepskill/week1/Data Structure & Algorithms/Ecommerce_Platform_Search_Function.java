import java.util.Arrays;
import java.util.Comparator;

public class Ecommerce_Platform_Search_Function {

    static class Product {
        int productId;
        String productName;
        String category;

        Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }
    }

    static int linearSearch(Product[] products, int id) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == id)
                return i;
        }
        return -1;
    }

    static int binarySearch(Product[] products, int id) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == id)
                return mid;
            else if (products[mid].productId < id)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(103, "Mouse", "Electronics"),
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics")
        };

        System.out.println("Linear Search: " + linearSearch(products, 102));

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        System.out.println("Binary Search: " + binarySearch(products, 102));
    }
}