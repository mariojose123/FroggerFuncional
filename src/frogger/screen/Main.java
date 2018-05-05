package frogger.screen;

import frogger.screen.frame.GameFrame;
import frogger.screen.frame.elements.frog.Frog;
import frogger.screen.frame.helpers.PositionAndImageVariables;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private GameFrame game;
    private Stage stage;

    private Image heroImage;
    private Node hero;

    public Main() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        heroImage = new Image(PositionAndImageVariables.FROG_UP);
        PositionAndImageVariables.frogImg= new ImageView(heroImage);
        hero =PositionAndImageVariables.frogImg;
        Frog frog = new Frog(hero);
        frog.moveFrogTo(PositionAndImageVariables.W/2,PositionAndImageVariables.H/2);


        Parent root = FXMLLoader.load(getClass().getResource("mainscreen.fxml"));
        Group dungeon = new Group(frog.getFrog(), root);
        frog.getFrog().toFront();
        this.stage = primaryStage;
        stage.setTitle("Frogger - MLP");
        Scene scene =new Scene(dungeon, PositionAndImageVariables.W, PositionAndImageVariables.H);
        stage.setScene(scene);
        stage.setResizable(false);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                frog.switchFrog(event.getCode());
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                frog.switchFrogPositionAndImage(event.getCode());
            }
        });

        stage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;
                if (PositionAndImageVariables.goUp) {
                    dy -= 12;
                }
                if (PositionAndImageVariables.goDown) {
                    dy += 12;
                }
                if (PositionAndImageVariables.goRigth) {
                    dx += 12;
                }
                if (PositionAndImageVariables.goLeft)  {
                    dx -= 12;
                }
                frog.setLastKeyPressedToFalse();
                frog.moveFrogBy(dx, dy);
            }
        };
        timer.start();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
