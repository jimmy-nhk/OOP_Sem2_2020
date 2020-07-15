package Wk6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex7 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Text text = new Text(100,5,"Traffic Light");
        text.setFill(Color.RED);
        text.setStroke(Color.RED);
        text.setFont(Font.font("Times New Roman" , FontWeight.BOLD,20));

        Rectangle rectangle = new Rectangle(160,340);

        Pane pane = new Pane();
        pane.getChildren().add(rectangle);
        Circle c1 = new Circle(80 , 60 ,50);
        c1.setFill(Color.RED);
        Circle c2 = new Circle(80 , 170 ,50);
        c2.setFill(Color.GRAY);
        Circle c3 = new Circle(80 , 280 ,50);
        c3.setFill(Color.GRAY);

        pane.getChildren().addAll(c1,c2,c3);

        Button btNext = new Button("Next");
        btNext.setOnAction( e -> {
            if (c1.getFill() == Color.RED) {
                c1.setFill(Color.GRAY);
                c3.setFill(Color.GRAY);
                c2.setFill(Color.GREEN);
            } else if (c2.getFill() == Color.GREEN) {
                c1.setFill(Color.GRAY);
                c2.setFill(Color.GRAY);
                c3.setFill(Color.YELLOW);
            } else if (c3.getFill() == Color.YELLOW) {
                c1.setFill(Color.RED);
                c2.setFill(Color.GRAY);
                c3.setFill(Color.GRAY);
            }
        });

        Button btExit = new Button("Exit");
        btExit.setOnAction(e -> System.exit(1));

        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(btNext,btExit);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(0,20,0,20));
        vBox.getChildren().addAll(text,pane,hBox);
        vBox.setMargin(text,new Insets(0,0,0,20));
        vBox.setMargin(hBox,new Insets(50,0,0,0));

        Scene scene = new Scene(vBox, 200, 420);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
