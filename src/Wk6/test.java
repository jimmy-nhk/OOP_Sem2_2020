package Wk6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class test extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("Oke");
        Scene scene = new Scene(button);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
