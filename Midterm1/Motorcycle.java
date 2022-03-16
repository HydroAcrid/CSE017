public class Motorcycle extends Vehicle{  
    private int wheels;
        public Motorcycle(){  }
        public Motorcycle(String vin, String make, String model, int year, int seats,int wheels){
            super(vin, make, model, year, seats);
            this.wheels = wheels;
        }
        public int getWheels(){
            return wheels;
        }
        public void setWheels(int w){
            wheels = w;
        }
        public String toString(){
            return String.format("%s\t%-5d", super.toString(), wheels);
        }
        public String simpleString(){
            return super.simpleString()+";"+wheels;
        }
        public Object clone() {
            // Vehicle test = new Motorcycle();
            // Vehicle test2 = (Motorcycle) test.clone();        
    
    	
        
            // return null;
        }
    }
