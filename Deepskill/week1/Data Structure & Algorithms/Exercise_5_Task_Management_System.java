public class Exercise_5_Task_Management_System {

    static class Node {
        String task;
        Node next;

        Node(String task) {
            this.task = task;
        }
    }

    static class TaskList {
        private Node head;

        public void addTask(String task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
                return;
            }

            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        public void deleteTask(String task) {
            Node current = head;
            Node previous = null;

            while (current != null) {
                if (current.task.equals(task)) {
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    return;
                }
                previous = current;
                current = current.next;
            }
        }

        public void traverse() {
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        taskList.addTask("Create report");
        taskList.addTask("Send email");
        taskList.addTask("Review code");
        taskList.traverse();
    }
}