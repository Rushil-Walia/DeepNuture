public class TaskLinkedList {
    private Task head;

    public void addTask(Task newTask) {
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) current = current.next;
            current.next = newTask;
        }
    }

    public Task searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) return current;
            current = current.next;
        }
        return null;
    }

    public void traverse() {
        Task current = head;
        while (current != null) {
            System.out.println(current.taskName);
            current = current.next;
        }
    }

    public void deleteTask(int id) {
        if (head == null) return;
        if (head.taskId == id) {
            head = head.next; // Delete head
            return;
        }
        
        Task current = head;
        while (current.next != null && current.next.taskId != id) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next; // Bypass the deleted node
        }
    }
}