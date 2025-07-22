package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
		stage.setScene(new Scene(root, 600, 400));
		stage.setTitle("iQVR App");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
