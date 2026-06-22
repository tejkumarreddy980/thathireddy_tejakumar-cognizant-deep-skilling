public class EmployeeManagementSystem {

    static class Employee {
        int employeeId;
        String name;
        String position;
        double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public String toString() {
            return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: ₹" + salary;
        }
    }

    static class EmployeeManager {
        private Employee[] employees;
        private int size;

        public EmployeeManager(int capacity) {
            employees = new Employee[capacity];
            size = 0;
        }

        public void addEmployee(Employee employee) {
            if (size < employees.length) {
                employees[size++] = employee;
                System.out.println("Employee added.");
            } else {
                System.out.println("Employee list is full.");
            }
        }

        public void searchEmployee(int id) {
            for (int i = 0; i < size; i++) {
                if (employees[i].employeeId == id) {
                    System.out.println("Employee found: " + employees[i]);
                    return;
                }
            }
            System.out.println("Employee not found.");
        }

        public void traverseEmployees() {
            if (size == 0) {
                System.out.println("No employees to display.");
            } else {
                for (int i = 0; i < size; i++) {
                    System.out.println(employees[i]);
                }
            }
        }

        public void deleteEmployee(int id) {
            for (int i = 0; i < size; i++) {
                if (employees[i].employeeId == id) {
                    for (int j = i; j < size - 1; j++) {
                        employees[j] = employees[j + 1];
                    }
                    employees[--size] = null;
                    System.out.println("Employee deleted.");
                    return;
                }
            }
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee(1, "Alice", "Manager", 75000));
        manager.addEmployee(new Employee(2, "Bob", "Developer", 50000));
        manager.addEmployee(new Employee(3, "Charlie", "Designer", 45000));

        System.out.println("\nAll Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching for Employee with ID 2:");
        manager.searchEmployee(2);

        System.out.println("\nDeleting Employee with ID 1:");
        manager.deleteEmployee(1);

        System.out.println("\nAll Employees after deletion:");
        manager.traverseEmployees();
    }
}
