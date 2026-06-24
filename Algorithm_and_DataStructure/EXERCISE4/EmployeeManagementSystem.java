package Algorithm_and_DataStructure.EXERCISE4;

public class EmployeeManagementSystem {

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

        @Override
        public String toString() {
            return "Employee ID: " + employeeId +
                    ", Name: " + name +
                    ", Position: " + position +
                    ", Salary: " + salary;
        }
    }

    static Employee[] employees = new Employee[10];
    static int count = 0;

    public static void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Array is full.");
        }
    }

    public static Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public static void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void deleteEmployee(int employeeId) {
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee deleted successfully.");
    }

    public static void main(String[] args) {

        addEmployee(new Employee(101, "Krishna", "Developer", 50000));
        addEmployee(new Employee(102, "Rahul", "Tester", 40000));
        addEmployee(new Employee(103, "Priya", "Manager", 70000));

        System.out.println("\nAll Employees:");
        traverseEmployees();

        System.out.println("\nSearching Employee ID 102:");
        Employee employee = searchEmployee(102);

        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting Employee ID 102:");
        deleteEmployee(102);

        System.out.println("\nEmployees After Deletion:");
        traverseEmployees();
    }
}