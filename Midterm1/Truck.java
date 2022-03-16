public class Truck extends Vehicle{
    private int towCapacity;
    public Truck(){  }
    public Truck(String vin, String make, String model, int year, int seats,int tow){
        super(vin, make, model, year, seats);
        this.towCapacity = tow;
    }
    public int getTowCapacity(){
        return towCapacity;
    }
    public void setTowCapacity(int t){
        towCapacity = t;
    }
    public String toString(){
        return String.format("%s\t%-5d", super.toString(), towCapacity);
    }
    public String simpleString(){
        return super.simpleString()+";"+towCapacity;
    }
    public Object clone() {
        // Vehicle test = new Truck();
        // Vehicle test2 = (Truck) test.clone();        
    
    	// return null;
    }
}
