public class Employee extends Person {
    
    private int id;
    private String position;
    private double salary;

    public Employee() {
        super();
        id = 0;
        position = "none";
        salary = 0.0;
    }

    public Employee(String name, String address, String phone, String email, int id, String position, double salary) {
        super(name, address, phone, email);
        this.id = id;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return String.format("%sID: %d\nPosition: %s\nSalary: %.2f\n", super.toString(), id, position, salary);
    }
}
