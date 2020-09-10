package TestBoardGame;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameBoard implements Initializable {

    @FXML
    private Pane pane ;
    private Object Glow;

    public GameBoard(){}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList <ImageView> deck = new ArrayList<>();

        300 60
        for (int i = 1 ; i < 53 ; i ++) {
            deck.add(new Image())
        }



        ArrayList<ImageView> imageView = new ArrayList<>();
        // Player on the left

        for (int i = 0 ; i < 20 ; i ++) {
            imageView.add(setSizeImage());
            imageView.get(i).setTranslateX(100 + i * 10);
            imageView.get(i).setTranslateY(170 + i * 12);
            imageView.get(i).setSmooth(true);
            pane.getChildren().add(imageView.get(i));
        }

        // Set animation for going into the board
        for (int i = 0 ; i < 20 ; i ++){
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000),imageView.get(i));
            AtomicBoolean check = new AtomicBoolean(false);
            RotateTransition rotator = new RotateTransition(Duration.millis(500),imageView.get(i));
            int finalI = i ;

            imageView.get(i).setOnMouseClicked(event -> {
                translateTransition.setToX(700 );
                translateTransition.setToY(400 );
                imageView.get(finalI).setFitHeight(150);
                imageView.get(finalI).setFitWidth(120);

                rotator.setAxis(Rotate.Y_AXIS);
                rotator.setFromAngle(0);
                rotator.setToAngle(360);

                rotator.setInterpolator(Interpolator.LINEAR);
                rotator.setCycleCount(1);

                rotator.play();
                translateTransition.play();

                imageView.get(finalI).setImage(new Image("cards/"+ finalI  +".png"));

                imageView.get(finalI).toFront();


            });
        }


        // Right player
        for (int i = 0 ; i < 20 ; i ++) {
            ImageView imageView1 = setSizeImage();
            imageView1.setTranslateX(1350 - i * 12);
            imageView1.setTranslateY(170 + i * 12);
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500),imageView1);
            AtomicBoolean check = new AtomicBoolean(false);
            imageView1.setOnMouseClicked(event -> {
                if (!check.get()) {
                    translateTransition.setByY(-50);
                    check.set(true);
                } else {
                    translateTransition.setByY(50);
                    check.set(false);
                }

                translateTransition.play();
            });
            pane.getChildren().add(imageView1);
        }


        // Upper player
        for (int i = 0 ; i < 20 ; i ++) {
            ImageView imageView1 = setSizeImage();
            imageView1.setTranslateX(550 + i * 20);
            imageView1.setTranslateY(50);
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500),imageView1);
            AtomicBoolean check = new AtomicBoolean(false);
            imageView1.setOnMouseClicked(event -> {
                if (!check.get()) {
                    translateTransition.setByY(-50);
                    check.set(true);
                } else {
                    translateTransition.setByY(50);
                    check.set(false);
                }

                translateTransition.play();
            });
            pane.getChildren().add(imageView1);
        }


        // Main player

        for (int i = 0 ; i < 20 ; i ++) {
            ImageView imageView1 = setSizeImage();
            imageView1.setFitWidth(120);
            imageView1.setFitHeight(150);
            imageView1.setTranslateX(200 + i * 50);
            imageView1.setTranslateY(660 );
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500),imageView1);
            AtomicBoolean check = new AtomicBoolean(false);
            imageView1.setOnMouseClicked(event -> {
                if (!check.get()) {
                    translateTransition.setByY(-50);
                    check.set(true);
                } else {
                    translateTransition.setByY(50);
                    check.set(false);
                }

                translateTransition.play();
            });
            pane.getChildren().add(imageView1);
        }
    }

    public ImageView setSizeImage (){
        ImageView imageView = new ImageView(new Image("cards/UNO-Back.png"));
        imageView.setFitHeight(100);
        imageView.setFitWidth(80);
        imageView.setSmooth(true);

        return imageView;
    }


}
