public class Task_Management_System {

    static class Task {
        int taskId;
        String taskName;
        String status;
        Task next;

        Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }
    }

    static Task head = null;

    static void add(int id, String name, String status) {
        Task t = new Task(id, name, status);
        if (head == null) {
            head = t;
            return;
        }
        Task temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = t;
    }

    static void search(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println(temp.taskName);
                return;
            }
            temp = temp.next;
        }
    }

    static void traverse() {
        Task temp = head;
        while (temp != null) {
            System.out.println(temp.taskId + " " + temp.taskName + " " + temp.status);
            temp = temp.next;
        }
    }

    static void delete(int id) {
        if (head == null)
            return;

        if (head.taskId == id) {
            head = head.next;
            return;
        }

        Task temp = head;
        while (temp.next != null && temp.next.taskId != id)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    public static void main(String[] args) {

        add(1, "Coding", "Pending");
        add(2, "Testing", "Completed");
        add(3, "Review", "Pending");

        traverse();

        search(2);

        delete(2);

        System.out.println("After Delete:");
        traverse();
    }
}