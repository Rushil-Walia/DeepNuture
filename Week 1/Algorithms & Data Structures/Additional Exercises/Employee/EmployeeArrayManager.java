public class EmployeeArrayManager {
    private Employee[] employees;
    private int size = 0;

    public EmployeeArrayManager(int capacity) {
        employees = new Employee[capacity];
    }

    public void addEmployee(Employee emp) {
        if (size < employees.length) employees[size++] = emp;
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) return employees[i];
        }
        return null;
    }

    public void traverse() {
        for (int i = 0; i < size; i++) System.out.println(employees[i].name);
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                // Shift elements left to fill the gap
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return;
            }
        }
    }
}