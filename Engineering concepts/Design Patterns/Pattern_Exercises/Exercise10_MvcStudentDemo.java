public class Exercise10_MvcStudentDemo {
    public static void main(String[] args) {
        StudentRecordModel model = new StudentRecordModel("1001", "Meera", "A+");
        StudentRecordView view = new StudentRecordView();
        StudentRecordController controller = new StudentRecordController(model, view);

        controller.updateView();
        controller.setStudentName("Meera Sharma");
        controller.setGrade("A");
        controller.updateView();
    }
}

final class StudentRecordModel {
    private String studentId;
    private String studentName;
    private String grade;

    StudentRecordModel(String studentId, String studentName, String grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

final class StudentRecordView {
    public void displayStudent(StudentRecordModel model) {
        System.out.println("Student ID: " + model.getStudentId());
        System.out.println("Student Name: " + model.getStudentName());
        System.out.println("Grade: " + model.getGrade());
        System.out.println();
    }
}

final class StudentRecordController {
    private final StudentRecordModel model;
    private final StudentRecordView view;

    StudentRecordController(StudentRecordModel model, StudentRecordView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String studentName) {
        model.setStudentName(studentName);
    }

    public void setGrade(String grade) {
        model.setGrade(grade);
    }

    public void updateView() {
        view.displayStudent(model);
    }
}