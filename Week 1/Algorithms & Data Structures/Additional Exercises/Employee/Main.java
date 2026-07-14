public class Main {
    public static void main(String[] args) {
        EmployeeArrayManager manager = new EmployeeArrayManager(5);

        System.out.println("--- Adding Employees ---");
        manager.addEmployee(new Employee(1, "John Doe", 60000));
        manager.addEmployee(new Employee(2, "Jane Smith", 75000));
        manager.addEmployee(new Employee(3, "Sam Brown", 50000));
        
        manager.traverse();

        System.out.println("\n--- Searching for ID 2 ---");
        Employee found = manager.searchEmployee(2);
        System.out.println(found != null ? "Found: " + found.name : "Not found");

        System.out.println("\n--- Deleting ID 1 ---");
        manager.deleteEmployee(1);
        manager.traverse(); // John Doe should be gone
    }
}