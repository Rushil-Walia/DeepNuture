public class MVCTest {
    public static void main(String[] args) {
        Student model = new Student("101", "John Doe");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();
        controller.setStudentName("Jane Doe"); // Update model via controller
        controller.updateView();
    }
}