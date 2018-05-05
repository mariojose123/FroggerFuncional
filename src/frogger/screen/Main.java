package frogger.screen;

import frogger.screen.frame.GameFrame;
import frogger.screen.frame.elements.frog.Frog;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private GameFrame game;
    private Stage stage;

    @FXML
    private ImageView frogImg;

    public static final double W = 1260, H = 720;

    private static final String FROG_UP = "frogger/screen/frame/elements/frog/frog-up.png";
    private static final String FROG_DOWN = "frogger/screen/frame/elements/frog/frog-down.png";
    private static final String FROG_LEFT = "frogger/screen/frame/elements/frog/frog-left.png";
    private static final String FROG_RIGHT = "frogger/screen/frame/elements/frog/frog-right.png";

    private Image heroImage;
    private Node hero;
    boolean goNorth, goSouth, goEast, goWest;

    public Main() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        heroImage = new Image(FROG_UP);
        frogImg= new ImageView(heroImage);
        hero =frogImg;
        Frog frog = new Frog(hero);
        frog.moveFrogTo(W/2,H/2);


        Parent root = FXMLLoader.load(getClass().getResource("mainscreen.fxml"));
        Group dungeon = new Group(frog.getFrog(), root);
        frog.getFrog().toFront();
        this.stage = primaryStage;
        stage.setTitle("Frogger - MLP");
        Scene scene =new Scene(dungeon, W, H);
        stage.setScene(scene);
        stage.setResizable(false);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    {
                        goNorth = true;
                    } break;
                    case DOWN:  {
                        goSouth = true;
                    } break;
                    case LEFT:  goWest  = true; break;
                    case RIGHT: goEast  = true; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    {
                        goNorth = false;
                        frogImg.setImage(new Image(FROG_UP));
                    } break;
                    case DOWN:  {
                        goSouth = false;
                        frogImg.setImage(new Image(FROG_DOWN));
                    } break;
                    case LEFT:  {
                        goWest  = false;
                        frogImg.setImage(new Image(FROG_LEFT));
                    } break;
                    case RIGHT: {
                        goEast  = false;
                        frogImg.setImage(new Image(FROG_RIGHT));
                    } break;
                }
            }
        });
        stage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;
                if (goNorth) dy -= 6;
                if (goSouth) dy += 6;
                if (goEast)  dx += 6;
                if (goWest)  dx -= 6;
                frog.moveFrogBy(dx, dy);
            }
        };
        timer.start();
    }


    public static void main(String[] args) {
        launch(args);
    }

    //eu fiz na chinelagem ali mesmo tudojunto pq n sei separar, dai quem conseguir colocar o handle dos eventos aqui seria top
    public void addEventHandler(EventHandler<? super KeyEvent> handler) {
        stage.addEventHandler(KeyEvent.KEY_PRESSED, handler);
    }

}
