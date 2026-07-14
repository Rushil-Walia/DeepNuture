public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        System.out.println("--- Adding Tasks ---");
        taskList.addTask(new Task(1, "Design Database"));
        taskList.addTask(new Task(2, "Write API endpoints"));
        taskList.addTask(new Task(3, "Setup Frontend"));
        
        taskList.traverse();

        System.out.println("\n--- Searching for Task 2 ---");
        Task found = taskList.searchTask(2);
        System.out.println(found != null ? "Found: " + found.taskName : "Not found");

        System.out.println("\n--- Deleting Task 1 ---");
        taskList.deleteTask(1);
        taskList.traverse(); // "Design Database" should be gone
    }
}