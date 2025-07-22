package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class TransferApp extends Application {
	
	@Override
    public void start(Stage stage) throws Exception {
		
		Pane root = FXMLLoader.load(getClass().getResource("/view/TransferView.fxml"));
		stage.setScene(new Scene(root, 600, 400));
		stage.setTitle("Transfer System App");
		stage.show();
			 
    }

    public static void main(String[] args) {
    	launch(args);
    }

}