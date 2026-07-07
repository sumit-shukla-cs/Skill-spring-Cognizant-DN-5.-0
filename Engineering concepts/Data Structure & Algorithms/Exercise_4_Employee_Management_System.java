import java.util.ArrayList;
import java.util.List;

public class Exercise_4_Employee_Management_System {

    static class Employee {
        private final int id;
        private String name;
        private String department;

        Employee(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', department='" + department + "'}";
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR"));
        employees.add(new Employee(2, "Bob", "IT"));
        employees.add(new Employee(3, "Carol", "Finance"));

        System.out.println(employees.get(1));
        employees.get(1).department = "Engineering";
        employees.add(new Employee(4, "David", "Support"));

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}