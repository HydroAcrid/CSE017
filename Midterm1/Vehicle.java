public abstract class Vehicle implements Comparable<Vehicle>, Cloneable{
    private String vin;
    private String make;
    private String model;
    private int year;
    private int seats;

    protected Vehicle(){
        //remove this before giving to students
        this("test", "test", "test",2022, 4);
    }
    protected Vehicle(String vin, String make, String model, int year, int seats){
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.seats = seats;
    }
    public void setVin(String vin){
        this.vin = vin;
    }
    public String getVin(){
        return vin;
    }
    public void setMake(String make){
        this.make = make;
    }
    public String getMake(){
        return make;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return model;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return year;
    }
    public void setSeats(int seats){
        this.seats = seats;
    }
    public int getSeats(){
        return seats;
    }

    public String toString(){
        String s = String.format("%-17s\t%-5d\t%-10s\t%-10s\t%-5d", vin, year,make,model,seats);
        return s;
    }
    public String simpleString(){
        return vin+";"+ year + ";"+make +";"+model+";"+seats;
    }
    
    public int compareTo(Vehicle v){
        return 0;
    }

    public abstract Object clone();

}
