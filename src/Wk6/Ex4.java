package Wk6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;

public class Ex4 extends Application {
    Random random = new Random();
    int a = random.nextInt(51) + 1;
    int b = random.nextInt(51) + 1;
    int c = random.nextInt(51) + 1;

    ImageView file1 = new ImageView();
    ImageView file2 = new ImageView();
    ImageView file3 = new ImageView();

    Button btDeal = new Button("Deal");
    Button btExit = new Button("Exit");
    Text text = new Text();
    GridPane pane = new GridPane();

    @Override
    public void start(Stage primaryStage) throws Exception {
        exportImage(file1,a);
        exportImage(file2,b);
        exportImage(file3,c);

        btDeal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                a = random.nextInt(51) + 1;
                b = random.nextInt(51) + 1;
                c = random.nextInt(51) + 1;

                text.setText(checkValue(a) + checkValue(b) + checkValue(c) +" points");
                exportImage(file1,a);
                exportImage(file2,b);
                exportImage(file3,c);

            }
        });

        text.setText(checkValue(a) + checkValue(b) + checkValue(c) +" points");
        btExit.setOnAction( e -> System.exit(1));

        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.add(file1, 1, 1);
        pane.add(file2, 2, 1);
        pane.add(file3, 3, 1);
        pane.add(btDeal, 1, 2);
        pane.setMargin(btDeal, new Insets(30, 0, 40, 150));

        pane.add(text, 2, 2);
        pane.setMargin(text, new Insets(15, 0, 80, 80));

        pane.add(btExit, 3, 2);
        pane.setMargin(btExit, new Insets(30, 150, 40, 0));

        Scene scene = new Scene(pane, 610, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public int checkValue (int a ) {
        int modulus = a % 13 ;
        if (modulus > 10 || modulus == 0) {
            return  10 ;
        }
        return  modulus;
    }

    public void exportImage (ImageView file3 ,int a) {
        file3.setImage(new Image("cards/" + a + ".png"));
        file3.setFitHeight(300);
        file3.setFitWidth(200);
    }
}
