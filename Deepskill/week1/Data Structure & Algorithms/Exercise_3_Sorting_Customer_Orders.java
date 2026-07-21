public class Exercise_3_Sorting_Customer_Orders {

    static class Order {
        private final int orderId;
        private final int totalPrice;

        Order(int orderId, int totalPrice) {
            this.orderId = orderId;
            this.totalPrice = totalPrice;
        }

        public int getOrderId() {
            return orderId;
        }

        public int getTotalPrice() {
            return totalPrice;
        }

        @Override
        public String toString() {
            return "Order{orderId=" + orderId + ", totalPrice=" + totalPrice + '}';
        }
    }

    private static void mergeSort(Order[] orders, Order[] temp, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(orders, temp, left, mid);
        mergeSort(orders, temp, mid + 1, right);
        merge(orders, temp, left, mid, right);
    }

    private static void merge(Order[] orders, Order[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (orders[i].getTotalPrice() >= orders[j].getTotalPrice()) {
                temp[k++] = orders[i++];
            } else {
                temp[k++] = orders[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = orders[i++];
        }

        while (j <= right) {
            temp[k++] = orders[j++];
        }

        for (int index = left; index <= right; index++) {
            orders[index] = temp[index];
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, 300),
            new Order(2, 150),
            new Order(3, 500)
        };

        Order[] temp = new Order[orders.length];
        mergeSort(orders, temp, 0, orders.length - 1);

        for (Order order : orders) {
            System.out.println(order);
        }
    }
}