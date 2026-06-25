package DesignPatternsandPrinciples;

class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println(student.getName() + " " +
                student.getId() + " " +
                student.getGrade());
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void updateGrade(String grade) {
        model.setGrade(grade);
    }

    public void display() {
        view.displayStudentDetails(model);
    }
}

public class Exercise10 {
    public static void main(String[] args) {
        Student student = new Student("Krishna", 101, "A");

        StudentView view = new StudentView();

        StudentController controller =
                new StudentController(student, view);

        controller.display();

        controller.updateGrade("A+");

        controller.display();
    }
}