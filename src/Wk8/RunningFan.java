package Wk8;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;



public class RunningFan extends Application {
    Button pause = new Button("Pause");
    Button resume = new Button("Resume");
    Button reverse = new Button("Reverse");

    @Override
    public void start(Stage primaryStage) throws Exception {
        FanPane fanpane = new FanPane();

        pause.setOnAction(e -> {

        });

        resume.setOnAction(e -> {

        });

        reverse.setOnAction(e -> {

        });

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(pause,resume,resume);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
    }
}
class FanPane extends Pane {
    Circle circle = new Circle(100,50,50);
    Line line1 = new Line(50,100,150,100);
    Line line2 = new Line(100,50,100,150);

    public FanPane(){
        getChildren().addAll(circle,line1,line2);
    }

    public void spin (){

    }


}
