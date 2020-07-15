package Wk8;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class DisplayingText extends Application {
    final String javaIsFun = "Java is fun";
    final String javaIsPowerful = "Java is powerful";
    @Override
    public void start(Stage primaryStage) throws Exception {

        Text text = new Text("Hello");
        text.setText(javaIsFun);
        text.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (text.getText().equals(javaIsFun)){
                    text.setText(javaIsPowerful);
                } else
                    text.setText(javaIsFun);
            }
        });

        StackPane pane = new StackPane();
        pane.getChildren().addAll(text);
        Scene scene = new Scene(pane,250,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
