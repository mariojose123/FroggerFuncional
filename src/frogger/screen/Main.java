package frogger.screen;

import frogger.screen.frame.GameFrame;
import frogger.screen.frame.elements.frog.Frog;
import frogger.screen.frame.helpers.ImageViewConstant;
import frogger.screen.frame.helpers.LivesRemaingLabel;
import frogger.screen.frame.helpers.PositionAndImageVariables;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private GameFrame game;
    private Stage stage;

    private Image heroImage;
    private Node hero;
    private final Label livesRemaining = new Label();
    AnchorPane anchor = new AnchorPane();

    public Main() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        heroImage = new Image(PositionAndImageVariables.FROG_UP());
        ImageViewConstant.frogImg= new ImageView(heroImage);
        hero =ImageViewConstant.frogImg;
        Frog frog = new Frog(hero);
        frog.moveFrogTo(PositionAndImageVariables.W()/2,PositionAndImageVariables.H()/2);
        Parent root = FXMLLoader.load(getClass().getResource("mainscreen.fxml"));
        LivesRemaingLabel.livesRemainingPanel(anchor, livesRemaining);
        Group dungeon = new Group(frog.getFrog(), root, livesRemaining);
        frog.getFrog().toFront();
        this.stage = primaryStage;
        stage.setTitle("Frogger - MLP");
        Scene scene =new Scene(dungeon, PositionAndImageVariables.W(), PositionAndImageVariables.H());
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
                if (PositionAndImageVariables.goUp()) {
                    dy -= PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA();
                }
                if (PositionAndImageVariables.goDown()) {
                    dy += PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA();
                }
                if (PositionAndImageVariables.goRigth()) {
                    dx += PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA();
                }
                if (PositionAndImageVariables.goLeft())  {
                    dx -= PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA();
                }
                frog.setLastKeyPressedToFalse();
                frog.moveFrogBy(dx, dy);
            }
        };
        timer.start();
    }

    private void livesRemainingPanel(){
        AnchorPane.setTopAnchor(livesRemaining, 50.0);
        AnchorPane.setRightAnchor(livesRemaining, 50.0);
        livesRemaining.setText(String.format("Vidas Restantes: %d", 3));
        livesRemaining.setTextFill(Color.web("#0076a3"));
        livesRemaining.setScaleY(1.5);
        livesRemaining.backgroundProperty().setValue(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        anchor.toFront();
        anchor.getChildren().add(livesRemaining);
    }


    public static void main(String[] args) {
        launch(args);
    }

}
