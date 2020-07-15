package Wk6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Ex5 extends Application {
    Circle c1 = new Circle();

    Circle c2 = new Circle();
    @Override
    public void start(Stage primaryStage) throws Exception {

        formatCircle(c1,Color.BLUE);
        formatCircle(c2,Color.PURPLE);

        Line line = new Line(c1.getCenterX(),c1.getCenterY(),c2.getCenterX(),c2.getCenterY());
        line.setFill(Color.BLACK);
        Text t1 = new Text(c1.getCenterX(),c1.getCenterY(),"1");
        Text t2 = new Text(c2.getCenterX(),c2.getCenterY(),"2");

        Pane pane = new Pane();
        pane.getChildren().addAll(line,c1,c2,t1,t2);

        Scene scene = new Scene(pane, 610, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void formatCircle (Circle c1 , Color color) {
        Random random = new Random();
        c1.setCenterX(random.nextInt(500) + 1 );
        c1.setCenterY(random.nextInt(300) + 1);
        c1.setRadius( 15);
        c1.setStroke(color);
        c1.setFill(Color.WHITE);
    }
}
