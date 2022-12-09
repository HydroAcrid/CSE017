public class Student extends Person {
    
    private int id;
    private double gpa;

    public Student() {
        super();
        id = 0;
        gpa = 0.0;
    }

    public Student(String name, String address, String phone, String email, int id, double gpa) {
        super(name, address, phone, email);
        this.id = id;
        this.gpa = gpa;

    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String toString() {
        return String.format("%sID: %d\nGPA: %.2f\n", super.toString(), id, gpa);
    }
}
