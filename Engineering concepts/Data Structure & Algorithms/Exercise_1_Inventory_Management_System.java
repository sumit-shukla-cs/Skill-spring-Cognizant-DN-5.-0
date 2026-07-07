import java.util.HashMap;
import java.util.Map;

public class Exercise_1_Inventory_Management_System {

    static class Item {
        private final String name;
        private int quantity;

        Item(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Item{name='" + name + "', quantity=" + quantity + '}';
        }
    }

    static class InventorySystem {
        private final Map<Integer, Item> items = new HashMap<>();

        public void addItem(int itemId, String name, int quantity) {
            items.put(itemId, new Item(name, quantity));
        }

        public void updateStock(int itemId, int quantity) {
            Item item = items.get(itemId);
            if (item != null) {
                item.setQuantity(quantity);
            }
        }

        public Item getItem(int itemId) {
            return items.get(itemId);
        }

        public void removeItem(int itemId) {
            items.remove(itemId);
        }
    }

    public static void main(String[] args) {
        InventorySystem inventory = new InventorySystem();
        inventory.addItem(101, "Keyboard", 50);
        inventory.addItem(102, "Mouse", 120);
        System.out.println(inventory.getItem(101));
    }
}