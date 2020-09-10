package TestBoardGame;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameBoard implements Initializable {

    public Button btDraw;
    @FXML
    private Pane pane ;
    private Object Glow;
    ArrayList <ImageView> deck = new ArrayList<>();
    ArrayList <ImageView> mainPlayer = new ArrayList<>();
    public GameBoard(){}



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btDraw.setOnAction(event -> {
            TranslateTransition translate= new TranslateTransition();
            ImageView current =deck.get(deck.size()-1);
            ImageView lastCard= mainPlayer.get(mainPlayer.size()-1);
            mainPlayer.add(current);
            translate.setNode(current);
            current.toFront();
            translate.setToX(lastCard.getTranslateX() + 20);
            translate.setToY(lastCard.getTranslateY());
            current.setFitHeight(lastCard.getFitHeight());
            current.setFitWidth(lastCard.getFitWidth());
            current.setRotate(lastCard.getRotate());
            System.out.println(lastCard.getTranslateX());
            System.out.println(lastCard.getTranslateY());
            deck.remove( deck.get(deck.size()-1) );
            translate.play();
        });

        deck.add(new ImageView("file:cards/"+ 0 +".png"));

        // Main player
        double maxSize=720;
        double step=0+maxSize/mainPlayer.size();
        for (int i = 0 ; i < 20 ; i ++) {
            ImageView imageView1 = setSizeImage();
            imageView1.setFitWidth(120);
            imageView1.setFitHeight(150);
            imageView1.setTranslateX(200 + i * 36);
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
            mainPlayer.add(imageView1);
        }

        // Bo bai rut
        for (int i = 1 ; i < 53 ; i ++) {

            ImageView a=new ImageView("cards/"+ 0 +".png");
            RotateTransition rotator = new RotateTransition(Duration.millis(500),a);

            a.setRotate(-50);
            deck.add(a);
            a.setTranslateX(300 + i * 1);
            a.setTranslateY(60 - i * 1);
            a.setFitWidth(80);
            a.setFitHeight(100);

            pane.getChildren().add(a);
        }

//        300 60




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


    }

    public ImageView setSizeImage (){
        ImageView imageView = new ImageView(new Image("cards/0.png"));
        imageView.setFitHeight(100);
        imageView.setFitWidth(80);
        imageView.setSmooth(true);

        return imageView;
    }


}
