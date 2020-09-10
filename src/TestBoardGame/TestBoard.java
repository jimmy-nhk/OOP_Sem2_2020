package TestBoardGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestBoard  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent view2 = FXMLLoader.load(getClass().getClassLoader().getResource("TestBoardGame/GameBoard.fxml"));
        Scene scene = new Scene(view2);

        primaryStage.setScene(scene);
        primaryStage.show();



    }
}
