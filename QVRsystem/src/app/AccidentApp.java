package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AccidentApp extends Application {
    
    @Override
    public void start(Stage stage) {
        try {
            Pane root = FXMLLoader.load(getClass().getResource("/view/AccidentView.fxml"));
            Scene scene = new Scene(root, 600, 600);
            stage.setScene(scene);
            stage.setTitle("Accident Report");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading FXML file.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
