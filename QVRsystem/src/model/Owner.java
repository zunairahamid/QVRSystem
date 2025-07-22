package model;

public class Owner {
	
	private String name;
    private String QID;
    private String mobileNum;

    // constructor
    public Owner() {
    	name = null;
    	QID = null;
    	mobileNum = null;
    }
    public Owner(String name, String QID, String mobileNum) {
        this.name = name;
        this.QID = QID;
        this.mobileNum = mobileNum;
    }

    // getter and setter methods
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQID() {
        return this.QID;
    }

    public void setQID(String QID) {
        this.QID = QID;
    }

    public String getMobileNum() {
        return this.mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
    
    //Method that returns if the owner has paid the bills or not
    public boolean isPaid() {
    	//here we can specify the details and validate if the owner has paid
    	return true;
    }
    
    /*public boolean isEqual(Owner o) {
    	if(this.name == o.name && this.QID == o.QID && this.mobileNum == o.mobileNum)
    		return true;
    	return false;
    }*/

}
