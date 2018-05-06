package frogger.screen;

import frogger.screen.frame.GameFrame;
import frogger.screen.frame.elements.car.Car;
import frogger.screen.frame.elements.car.DefineCarSpawns;
import frogger.screen.frame.elements.car.RedCar;
import frogger.screen.frame.elements.car.YellowCar;
import frogger.screen.frame.elements.frog.Frog;
import frogger.screen.frame.elements.player.Player;
import frogger.screen.frame.elements.player.PlayerStatus;
import frogger.screen.frame.helpers.ImageViewConstant;
import frogger.screen.frame.helpers.LivesRemaingLabel;
import frogger.screen.frame.helpers.PositionAndImageVariables;
import frogger.screen.frame.helpers.collision.Collisions;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private Group frogRoad;

    private List<Node> cars = new ArrayList<>();


    public Main() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = getParentContent();

        LivesRemaingLabel.livesRemainingPanel(anchor, livesRemaining);

        frog = setPersonageImage();
        frog.moveFrog(PositionAndImageVariables.W() / 2, PositionAndImageVariables.H() / 2);

        cars.add((new DefineCarSpawns(new YellowCar())).getSpawnCar());
        cars.add((new DefineCarSpawns(new RedCar())).getSpawnCar());
        cars.add((new DefineCarSpawns(new YellowCar())).getSpawnCar());

        frogRoad = new Group(frog.getFrog(), cars.get(0), cars.get(1), cars.get(2), root, livesRemaining);

        setZindexOfSprites();

        setStageAndScene(primaryStage, frogRoad);

        animationTimer();
    }

    private void animationTimer() {

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
                frog.moveFrog(dx, dy);

                if(Collisions.onUpdate((ArrayList<Node>) cars, frog, stage).compareTo(PlayerStatus.LOSER()) ==0){
                    startAgain();

                }
            }
        };
        timer.start();
    }

    private void setZindexOfSprites() {
        frog.getFrog().toFront();
        cars.get(0).toFront();
        cars.get(1).toFront();
        cars.get(2).toFront();
    }
    private void startAgain() {
        timer.stop();
        Player.lostLive();
        if (PositionAndImageVariables.livesRemaing() <= 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Você perdeu o jogo!");
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setOnHidden(evt -> Platform.exit());
            alert.show();
        } else {
            try {

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Você ainda tem " + (PositionAndImageVariables.livesRemaing()) + " vidas");
                alert.setTitle(null);
                alert.setHeaderText(null);

                alert.setOnHidden(evt -> {
                    try {
                        start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                alert.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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

    private void setStageAndScene(Stage primaryStage, Group frogRoad) {
        this.stage = primaryStage;
        stage.setTitle("Frogger - MLP");

        Scene scene = new Scene(frogRoad, PositionAndImageVariables.W(), PositionAndImageVariables.H());
        stage.setScene(scene);
        stage.setResizable(false);

        setKeyEvents(scene);
        stage.show();
    }

    private void setKeyEvents(Scene scene) {
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
    }

    public static void main(String[] args) {
        launch(args);
    }

}
