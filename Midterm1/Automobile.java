public class Automobile extends Vehicle {
    private int doors; 
    private String type; 

    public Automobile(){ }
    public Automobile(String vin, String make, String model, int year, int seats,int doors, String type){
        super(vin, make, model, year, seats);
        this.doors = doors;
        this.type = type;
    }
    public void setDoors(int d){
        this.doors = d;
    }
    public int getDoors(){
        return doors;
    }
    public void setType(String t){
        this.type = t;
    }
    public String getType(){
        return type;
    }
    public String toString(){
        return String.format("%s\t%-25d\t%-5s", super.toString(), doors, type);
    }
    public String simpleString(){
        return super.simpleString()+";"+doors+";"+type;
    }
    public Object clone() {
        // Vehicle test = new Automobile();
        // Vehicle test2 = (Automobile) test.clone();        
    
    	// return null;
        
    }

}