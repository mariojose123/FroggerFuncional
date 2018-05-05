package frogger.screen;

import frogger.screen.frame.GameFrame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    private GameFrame game;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainscreen.fxml"));
        primaryStage.setTitle("Frogger - MLP");
        primaryStage.setScene(new Scene(root, 1260, 720));
        primaryStage.setResizable(false);
        primaryStage.show();

        //this.game = new GameFrame();

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> System.out.println("Check: " + event.getCharacter()));

    }


    public static void main(String[] args) {
        launch(args);
    }
}
