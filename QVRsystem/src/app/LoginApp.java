package app;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.UserAccount;
public class LoginApp extends Application {
 @Override
 public void start(Stage stage) throws Exception{
 Pane root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
 stage.setScene(new Scene(root, 300, 200));
 stage.setTitle("Login Dialog");
 stage.show();
 }
 public static void main(String[] args) {
//Create sample UserAccounts:
 new UserAccount("sayed", "password123");
 new UserAccount("ahmed", "ahmed123");
 launch(args);
 }
}