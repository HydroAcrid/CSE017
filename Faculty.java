public class Faculty extends Employee {

    private String rank;

    public Faculty() {
        super();
        rank = "none";
    }

    public Faculty(String name, String address, String phone, String email, int id, String position, double salary, String rank) {
        super(name, address, phone, email, id, position, salary);
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String toString() {
        return String.format("%sRank: %s\n", super.toString(), rank);

    }
    
}
