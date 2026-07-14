class Task {
    int taskId;
    String taskName;
    Task next; // Pointer to the next node

    public Task(int taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.next = null;
    }
}