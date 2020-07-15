package Wk8;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class LineSegment extends Application {
    final double WIDTH = 250;
    final double HEIGHT = 200;
    Line line = new Line(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2 - 10);

    @Override
    public void start(Stage primaryStage) throws Exception {

        line.setStroke(Color.BLACK);
        Pane pane = new Pane();
        pane.getChildren().add(line);

        line.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    line = new Line(line.getEndX(),line.getEndY(),line.getEndX(),line.getEndY() - 10);
                    pane.getChildren().add(line);
                    break;
                case DOWN:
                    line = new Line(line.getEndX(),line.getEndY(),line.getEndX(),line.getEndY() + 10);
                    pane.getChildren().add(line);
                    break;
                case LEFT:
                    line = new Line(line.getEndX(),line.getEndY(),line.getEndX() - 10 ,line.getEndY() );
                    pane.getChildren().add(line);
                    break;
                case RIGHT:
                    line = new Line(line.getEndX(),line.getEndY(),line.getEndX() + 10 ,line.getEndY() );
                    pane.getChildren().add(line);
                    break;
            }
        });

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
        line.requestFocus();
    }
}
