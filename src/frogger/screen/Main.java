package frogger.screen;

import frogger.screen.frame.GameFrame;
import frogger.screen.frame.elements.frog.Frog;
import frogger.screen.frame.helpers.ImageViewConstant;
import frogger.screen.frame.helpers.LivesRemaingLabel;
import frogger.screen.frame.helpers.PositionAndImageVariables;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private GameFrame game;
    private Stage stage;
    private Frog frog;
    private Parent root;

    private Image personageImage;
    private Node personage;
    private final Label livesRemaining = new Label();
    private AnchorPane anchor = new AnchorPane();
    private AnimationTimer timer;


    private List<Node> cars = new ArrayList<>();


    public Main() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = getParentContent();

        LivesRemaingLabel.livesRemainingPanel(anchor, livesRemaining);

        frog = setPersonageImage();
        frog.moveFrogTo(PositionAndImageVariables.W() / 2, PositionAndImageVariables.H() / 2);

        cars.add(spawnCar());
        Group frogRoad = new Group(frog.getFrog(), cars.get(0), root, livesRemaining);
        frog.getFrog().toFront();
        cars.get(0).toFront();

        this.stage = primaryStage;
        stage.setTitle("Frogger - MLP");
        Scene scene = new Scene(frogRoad, PositionAndImageVariables.W(), PositionAndImageVariables.H());
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
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;
                if (PositionAndImageVariables.goUp()) {
                    frog.getFrog().setTranslateY(frog.getFrog().getTranslateY() - PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA());
                }
                if (PositionAndImageVariables.goDown()) {
                    frog.getFrog().setTranslateY(frog.getFrog().getTranslateY() + PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA());
                }
                if (PositionAndImageVariables.goRigth()) {
                    frog.getFrog().setTranslateX(frog.getFrog().getTranslateX() + PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA());
                }
                if (PositionAndImageVariables.goLeft()) {
                    frog.getFrog().setTranslateX(frog.getFrog().getTranslateX() - PositionAndImageVariables.KEYBOARD_MOVEMENT_DELTA());
                }
                frog.setLastKeyPressedToFalse();
                frog.moveFrogBy(dx, dy);
                  onUpdate();
            }
        };
        timer.start();
    }

    private Frog setPersonageImage() {
        personageImage = new Image(PositionAndImageVariables.FROG_UP());
        ImageViewConstant.frogImg = new ImageView(personageImage);
        personage = ImageViewConstant.frogImg;
        return new Frog(personage);
    }

    private Parent getParentContent() throws IOException {
        return FXMLLoader.load(getClass().getResource("mainscreen.fxml"));
    }

    public static void main(String[] args) {
        launch(args);
    }

    private Rectangle spawnCar() {
        Rectangle rect = new Rectangle(40, 40, Color.RED);
        rect.setTranslateY((int) (Math.random() * 14) * 40);
        return rect;
    }
    private void onUpdate() {
        for (Node car : cars)
            car.setTranslateX(car.getTranslateX() + Math.random() * 10);
        checkState();
    }

    private void checkState() {
        for (Node car : cars) {
            if (car.getBoundsInParent().intersects(frog.getFrog().getBoundsInParent())) {
                timer.stop();
                return;
            }
        }
    }
}
