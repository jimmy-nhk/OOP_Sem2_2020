package Wk8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;

public class DistanceBetweenCircles extends Application {
    public Circle c1 = new Circle(40,40,10, Color.WHITE);
    public Circle c2 = new Circle(120,150,10, Color.WHITE);
    Line line = new Line(c1.getCenterX(),c1.getCenterY(),c2.getCenterX(),c2.getCenterY());
    double distance = Math.sqrt(Math.pow(c1.getCenterX() - c2.getCenterX(),2) + Math.pow(c1.getCenterY() - c2.getCenterY(),2) );
    Text text = new Text((c1.getCenterX()+c2.getCenterX()) / 2, (c1.getCenterY()+c2.getCenterY()) / 2, (int)distance + "" );

    @Override
    public void start(Stage primaryStage) throws Exception {

        c1.setStroke(Color.BLACK);
        c2.setStroke(Color.BLACK);
        Pane pane = new Pane();
        pane.getChildren().addAll(line,c1,c2,text);

        pane.setOnMouseDragged(e -> {
            if (c1.contains(e.getX(),e.getY())){
                pane.getChildren().clear();
                c1 = new Circle(e.getX(),e.getY(),10, Color.WHITE);
                c1.setStroke(Color.BLACK);
                pane.getChildren().addAll(getLine(c1,c2),c1,c2,getText(c1,c2));

            } else if (c2.contains(e.getX(),e.getY())) {
                pane.getChildren().clear();
                c2 = new Circle(e.getX(),e.getY(),10, Color.WHITE);
                c2.setStroke(Color.BLACK);
                pane.getChildren().addAll(getLine(c1,c2),c1,c2,getText(c1,c2));

            }
        });

        Scene scene = new Scene(pane,250,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Distance between 2 Circle");
        primaryStage.show();
    }

    public Line getLine (Circle c1 , Circle c2) {
        return new Line(c1.getCenterX(),c1.getCenterY(),c2.getCenterX(),c2.getCenterY());
    }

    public Text getText ( Circle c1 , Circle c2) {
        return new Text((c1.getCenterX()+c2.getCenterX()) / 2, (c1.getCenterY()+c2.getCenterY()) / 2, String.format ("%.2f",getDistance(c1,c2)));
    }

    public double getDistance(Circle c1 , Circle c2) {
        return  Math.sqrt(Math.pow(c1.getCenterX() - c2.getCenterX(),2) + Math.pow(c1.getCenterY() - c2.getCenterY(),2) )
        ;
    }
}
