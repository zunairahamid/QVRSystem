package model;

public class Accident {
	
	private String caseNum;
    private String date;
    private String time;
    private String location;
    private String description;
    private Vehicle offendingVehicle;
    private Vehicle victimVehicle;
    
    
    //Constructers
    
    public Accident() {}

	public Accident(String caseNum, String date, String time, String location, String description, Vehicle offendingVehicle, Vehicle victimVehicle) {
        this.caseNum = caseNum;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.offendingVehicle = offendingVehicle;
        this.victimVehicle = victimVehicle;
    }

    // Getters and setters
    public String getCaseNum() { return caseNum; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }
    public Vehicle getOffendingVehicle() { return offendingVehicle; }
    public Vehicle getVictimVehicle() { return victimVehicle; }

	public void setCaseNum(String caseNum) {this.caseNum = caseNum;}
	public void setDate(String date) {this.date = date;}
	public void setTime(String time) {this.time = time;}
	public void setLocation(String location) {this.location = location;}
	public void setDescription(String description) {this.description = description;}
	public void setOffendingVehicle(Vehicle offendingVehicle) {this.offendingVehicle = offendingVehicle;}
	public void setVictimVehicle(Vehicle victimVehicle) {this.victimVehicle = victimVehicle;}

}
