package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Owner;
import model.Vehicle;

public class TransferController {
	
	@FXML private TextField vinField;
    @FXML private TextField currentOwnerName;
    @FXML private TextField currentOwnerQID;
    @FXML private TextField currentOwnerMobile;
    @FXML private TextField newOwnerName;
    @FXML private TextField newOwnerQID;
    @FXML private TextField newOwnerMobile;
    @FXML private TextArea transferMessage;
    @FXML private Button pay;
    @FXML private Button cancel;
    @FXML private Button validateButton;
    @FXML private GridPane vehicleForm;
    @FXML private GridPane newOwnerForm;
    @FXML private VBox confirmationBox;

    // Predefined current owner and vehicle
    Owner owner = new Owner("Ahmed", "A100", "98765");
    Vehicle vehicle = new Vehicle("1234", owner);

    @FXML
    public void validateDetails(ActionEvent event) {
    	 // Create temporary owner and vehicle objects for validation
        Owner tempOwner = new Owner(currentOwnerName.getText(), currentOwnerQID.getText(), currentOwnerMobile.getText());
        String vinInput = vinField.getText();
        
        // Validate details
        if (vinInput.equals(vehicle.getVIN()) && tempOwner.getQID().equals(owner.getQID())) {
        	
            newOwnerForm.setVisible(true);
            if(!tempOwner.isPaid()) {
            	displayMessage("Pay the bills first.", AlertType.ERROR);
            	System.exit(0);
            }
            
        } else {
        	
            // Clear input fields for re-entry
            vinField.clear();
            currentOwnerName.clear();
            currentOwnerQID.clear();
            currentOwnerMobile.clear();
            
            // Show error message
            displayMessage("Details Not Correct. Re-Enter", AlertType.INFORMATION);
        }
    }

    // Confirm transfer and show final details
    @FXML
    public void confirmTransfer(ActionEvent event) {
        // Retrieve and store new owner details in the Vehicle
        Owner newOwner = new Owner(newOwnerName.getText(), newOwnerQID.getText(), newOwnerMobile.getText());
        vehicle.setCurrentOwner(newOwner); // Transfer ownership

        transferMessage.setText(
            "Transfer Confirmation:\n" +
            "  -Vehicle VIN: " + vehicle.getVIN() + "\n" +
            "\n  -Previous Owner: " + owner.getName() + " (QID: " + owner.getQID() + ", Mobile: " + owner.getMobileNum() + ")\n" +
            "\n  -New Owner: " + newOwner.getName() + " (QID: " + newOwner.getQID() + ", Mobile: " + newOwner.getMobileNum() + ")\n" +
            "\nTransfer Fee: 10000 QR"
        );

        newOwnerForm.setVisible(true);
        confirmationBox.setVisible(true);
    }

    // Pay button action
    @FXML
    public void payTransfer(ActionEvent event) {
    	
        displayMessage("Transfer Completed.", AlertType.CONFIRMATION);
        System.exit(0);
    }

    // Cancel button action
    @FXML
    public void cancelTransfer(ActionEvent event) {
    	
    	vehicle.setCurrentOwner(owner);
        displayMessage("Transfer Canceled.", AlertType.ERROR);
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
