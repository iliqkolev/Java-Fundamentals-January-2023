package Student_04;

public class Student {
    private String firstName;
    private String lastname;
    private double grade;

    public Student(String fn, String ln, double grade) {
        this.firstName = fn;
        this.lastname = ln;
        this.grade = grade;

    }

    public double getGrade() {
        return this.grade;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastname() {
        return this.lastname;
    }
}
