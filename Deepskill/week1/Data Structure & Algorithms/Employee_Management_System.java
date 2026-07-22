public class Employee_Management_System {

    static class Employee {
        int employeeId;
        String name;
        String position;
        double salary;

        Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }
    }

    static Employee[] employees = new Employee[5];
    static int count = 0;

    static void add(Employee e) {
        if (count < employees.length)
            employees[count++] = e;
    }

    static void search(int id) {
        for (int i = 0; i < count; i++)
            if (employees[i].employeeId == id)
                System.out.println(employees[i].name);
    }

    static void traverse() {
        for (int i = 0; i < count; i++)
            System.out.println(employees[i].employeeId + " " + employees[i].name);
    }

    static void delete(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++)
                    employees[j] = employees[j + 1];
                count--;
                break;
            }
        }
    }

    public static void main(String[] args) {

        add(new Employee(101, "Mohit", "Developer", 50000));
        add(new Employee(102, "Aman", "Manager", 60000));
        add(new Employee(103, "Riya", "Tester", 45000));

        traverse();

        search(102);

        delete(102);

        System.out.println("After Delete:");
        traverse();
    }
}