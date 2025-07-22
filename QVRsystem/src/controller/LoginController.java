package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import model.UserAccount;
import model.UserAccountContainer;
public class LoginController {
@FXML
private PasswordField password;
@FXML
private TextField username;
@FXML
private Button loginButton;
@FXML
void login(ActionEvent event) {
UserAccount user = UserAccountContainer.login(
 username.getText(), password.getText());
if (user != null && user.isLogged()) {
displayMessage("Welcome " + user.getUsername()
 + ". You have successfully logged in.",
AlertType.CONFIRMATION);
username.clear();
password.clear();
((Window) loginButton.getScene().getWindow()).hide();
} else
displayMessage("Unsuccessfull login. Try again.", AlertType.ERROR);
}
public void displayMessage(String message, AlertType type) {
Alert alert = new Alert(type);
alert.setTitle("System Message");
alert.setHeaderText(null);
alert.setContentText(message);
alert.showAndWait();
}
}