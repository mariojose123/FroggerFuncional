package frogger.screen;

import frogger.screen.frame.GameFrame;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    private GameFrame game;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainscreen.fxml"));
        stage = primaryStage;
        stage.setTitle("Frogger - MLP");
        stage.setScene(new Scene(root, 1260, 720));
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void addEventHandler(EventHandler<? super KeyEvent> handler) {
        stage.addEventHandler(KeyEvent.KEY_PRESSED, handler);
    }
}
