package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import model.Accident;
import model.Vehicle;
import model.Owner;

public class AccidentController {

    @FXML private TextField offendingVinField;
    @FXML private TextField victimVinField;
    @FXML private TextField dateField;
    @FXML private TextField timeField;
    @FXML private TextField locationField;
    @FXML private TextArea descriptionField;
    @FXML private TextArea accidentReport;
    @FXML private GridPane accidentDetailsPane;
    @FXML private VBox reportPane;
    @FXML private GridPane vehicles;
    @FXML private Button retrieve;
    @FXML private Button close;
    private Vehicle offendingVehicle;
    private Vehicle victimVehicle;

    @FXML
    public void retrieveVehicles() {
        // Placeholder VIN validation (you can replace this with actual logic)
        String offendingVin = offendingVinField.getText();
        String victimVin = victimVinField.getText();
       
        // Check if both vehicles are valid
        if (offendingVin.isEmpty() || victimVin.isEmpty()) {
        	displayMessage("Invalid VIN(s). Please re-enter.", AlertType.INFORMATION);
        	
        } else {
        	
        	// Here, we’d ideally fetch data from a database or service. For now, assume it’s hardcoded.
            offendingVehicle = new Vehicle(offendingVin, new Owner("Ahmed", "O123", "1111111111"));
            victimVehicle = new Vehicle(victimVin, new Owner("Ali", "V123", "2222222222"));
            
        	accidentDetailsPane.setVisible(true);  // Show accident details fields
        }
    }

    @FXML
    public void confirmAccident() {
    	
    	String caseNum = "AC" + System.currentTimeMillis();  // Generate unique case number
        String date = dateField.getText();
        String time = timeField.getText();
        String location = locationField.getText();
        String description = descriptionField.getText();

        // Create the accident report
        Accident accident = new Accident(caseNum, date, time, location, description, offendingVehicle, victimVehicle);

        // Display the report in the report pane
        accidentReport.setText(
	        "Accident Report\n" +
	        "Case Number: " + accident.getCaseNum() + "\n" +
	        "Date: " + accident.getDate() + "\n" +
	        "Time: " + accident.getTime() + "\n" +
	        "Location: " + accident.getLocation() + "\n" +
	        "Description: " + accident.getDescription() + "\n" +
	        "Offending Vehicle VIN: " + accident.getOffendingVehicle().getVIN() + "\n" +
	        "Victim Vehicle VIN: " + accident.getVictimVehicle().getVIN()
	        );

        //show report pane
        reportPane.setVisible(true);
        
    }


    @FXML
    public void closeApplication() {
    	displayMessage("Accident Reported.", AlertType.CONFIRMATION);
        System.exit(0);
    }
    
    public void displayMessage(String message, AlertType type) {
    	Alert alert = new Alert(type);
    	alert.setTitle("System Message");
    	alert.setHeaderText(null);
    	alert.setContentText(message);
    	alert.showAndWait();
    }
}
