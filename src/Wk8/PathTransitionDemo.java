package Wk8;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class PathTransitionDemo extends Application {
    public void start(Stage primaryStage) {
        Pane pane = new Pane();


        Rectangle rectangle = new Rectangle(0,0,25,50);
        rectangle.setFill(Color.ORANGE);
        Circle circle = new Circle(125,100,50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(rectangle);
        pathTransition.setPath(circle);
        pathTransition.setAutoReverse(true);
        pathTransition.setDuration(Duration.millis(4000));

        pathTransition.setCycleCount(Timeline.INDEFINITE); // = -1 is also fine
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(rectangle);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.1);
        fadeTransition.setDuration(Duration.millis(4000)); // how fast the opacity changes
        fadeTransition.setCycleCount(-1);
        fadeTransition.setAutoReverse(true);

        RotateTransition rt = new RotateTransition(Duration.millis(400),rectangle);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setByAngle(10);
        rt.setCycleCount(-1);

        pathTransition.play();
        fadeTransition.play();
        rt.play();

        pane.getChildren().addAll(circle,rectangle);


        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("PathTransitionDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


