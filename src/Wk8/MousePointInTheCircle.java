package Wk8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MousePointInTheCircle extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Circle circle = new Circle(100,60,50);
        Text text = new Text();
        Pane pane = new Pane(circle);

        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(text);
        pane.setOnMouseMoved(e -> {
            // Remember set pane to have setOnMouseMoved action because when set to circle , the mouse
            // can only move inside the circle

            text.setX(e.getX());
            text.setY(e.getY());
            if (e.getY() <= 60 + 50 && e.getX() <= 150) {
                text.setText("Mouse point is inside the circle");
            } else
                text.setText("Mouse point is NOT inside the circle");
        });

        Scene scene = new Scene(pane,250,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
