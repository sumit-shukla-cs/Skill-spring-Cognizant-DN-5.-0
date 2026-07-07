public class Exercise_2_Ecommerce_Platform_Search_Function {

    public static int binarySearch(String[] products, String target) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].compareTo(target);

            if (comparison == 0) {
                return mid;
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] products = {"Camera", "Laptop", "Phone", "Tablet"};
        System.out.println(binarySearch(products, "Phone"));
    }
}