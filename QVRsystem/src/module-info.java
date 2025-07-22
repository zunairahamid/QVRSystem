module QVRsystem {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	exports app;
    exports controller;
    opens controller to javafx.fxml; 
	opens application to javafx.graphics, javafx.fxml;
}
