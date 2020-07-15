package Wk8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MovingABall extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Ball ball = new Ball(100, 100, 20);

        Button up = new Button("UP");
        up.setOnAction(e -> {
            ball.moveUp();
            System.out.println(ball.getCircle().getCenterY());
                }
        );

        Button down = new Button("DOWN");
        down.setOnAction(e ->
                ball.moveDown()
        );

        Button left = new Button("LEFT");
        left.setOnAction(e ->{
            ball.moveLeft();
                }
        );

        Button right = new Button("RIGHT");
        right.setOnAction(e -> {
                ball.moveRight();
                System.out.println(ball.getCircle().getCenterX());
            
        });

        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(up, down, left, right);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.setPadding(new Insets(10, 10, 10, 10));

        BorderPane pane = new BorderPane();
        pane.setCenter(ball);
        pane.setBottom(hbox);

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

class Ball extends Pane {
    private Circle circle;

    public Ball (){
        this(0,0,10);
    }
    
    public Ball(double x, double y, double r) {
        Circle circle = new Circle(x, y, r);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        this.circle = circle;
        getChildren().addAll(circle);
    }


    public Circle getCircle() {
        return circle;
    }


    public void moveRight() {
        if (circle.getCenterX() + circle.getRadius() + 10 > getWidth()) return;
        circle.setCenterX(circle.getCenterX() + 10);
    }

    public void moveLeft() {
        if (circle.getCenterX() >= 25) {
            circle.setCenterX(circle.getCenterX() - 5);
        }
    }

    public void moveUp() {
        if (circle.getCenterY() - circle.getRadius()  - 10 < 0) return;
        circle.setCenterY(circle.getCenterY() - 10);
    }

    public void moveDown() {
        if (circle.getCenterY() + circle.getRadius() + 10 > getHeight() ) return;

        circle.setCenterY(circle.getCenterY() + 10);
    }

}
