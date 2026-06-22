public class MVCPatternExample {

    // Model
    static class Student {
        private String name;
        private String id;
        private String grade;

        public Student(String name, String id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    // View
    static class StudentView {
        public void displayStudentDetails(String name, String id, String grade) {
            System.out.println("Student Details:");
            System.out.println("Name  : " + name);
            System.out.println("ID    : " + id);
            System.out.println("Grade : " + grade);
        }
    }

    // Controller
    static class StudentController {
        private Student student;
        private StudentView view;

        public StudentController(Student student, StudentView view) {
            this.student = student;
            this.view = view;
        }

        public void setStudentName(String name) {
            student.setName(name);
        }

        public void setStudentId(String id) {
            student.setId(id);
        }

        public void setStudentGrade(String grade) {
            student.setGrade(grade);
        }

        public void updateView() {
            view.displayStudentDetails(student.getName(), student.getId(), student.getGrade());
        }
    }

    public static void main(String[] args) {
        Student model = new Student("Alice", "S101", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        System.out.println("== Initial Student Info ==");
        controller.updateView();

        controller.setStudentName("Alice Johnson");
        controller.setStudentGrade("A+");

        System.out.println("\n== After Update ==");
        controller.updateView();
    }
}
