package controller;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainController {

    private static final String ACCIDENT_VIEW_PATH = "/view/AccidentView.fxml";
    private static final String TRANSFER_VIEW_PATH = "/view/TransferView.fxml";
    
    @FXML
    private Button accidentButton;

    @FXML
    private Button transferButton;

    @FXML
    void handleAccident(ActionEvent event) {
        switchScene(event, ACCIDENT_VIEW_PATH);
    }

    @FXML
    void handleTransfer(ActionEvent event) {
        switchScene(event, TRANSFER_VIEW_PATH);
    }

    private void switchScene(ActionEvent event, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            
            // Optionally, get the controller if you need to pass data
            // Example:
            // AccidentController accidentController = loader.getController();
            // accidentController.initData(someData);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            displayError("Failed to load the view: " + fxmlPath);
            e.printStackTrace();
        }
    }

    private void displayError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
