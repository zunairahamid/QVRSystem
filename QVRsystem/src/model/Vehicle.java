package model;

public class Vehicle {
	
	private String VIN;
    private Owner currentOwner;
 
    // constructors
    
    public Vehicle() {
    	VIN = null;
    	currentOwner = null;
    }
    
    public Vehicle(String VIN, Owner currentOwner) {
        this.VIN = VIN;
        this.currentOwner = currentOwner;
        
    }

    // getter and setter methods
    public String getVIN() {
        return this.VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
    public Owner getCurrentOwner() {
        return this.currentOwner;
    }

    public void setCurrentOwner(Owner currentOwner) {
        this.currentOwner = currentOwner;
    }

}
