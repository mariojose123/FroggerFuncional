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
import frogger.screen.frame.helpers.MusicManager;
import frogger.screen.frame.helpers.PositionAndImageVariables;
import frogger.screen.frame.helpers.collision.Collisions;
import frogger.screen.frame.helpers.managers.AlertManager;
import frogger.screen.frame.helpers.managers.CarManager;
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
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



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
    private LivesRemaingLabel livesLabel;
    private MusicManager musicManager = new MusicManager();
    private PositionAndImageVariables positionAndImages = new PositionAndImageVariables();
    private List<Node> cars = new ArrayList<>();
    private Player player = new Player();
    private Collisions collisions = new Collisions();
    private CarManager carManager = new CarManager();
    private AlertManager alertManager = new AlertManager();


    public Main() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        livesLabel = new LivesRemaingLabel(player);
        positionAndImages.restartCarPositionsList();
        musicManager.playMusic(PlayerStatus.STILL_ON_GAME());

        root = getParentContent();

        livesLabel.livesRemainingPanel(anchor, livesRemaining);

        frog = setPersonageImage();
        frog.moveFrog(positionAndImages.W() / 2, positionAndImages.H() - 100);


        List<Node> carList = carManager.addCars(positionAndImages);
        cars = new ArrayList<>(carList);

        frogRoad = new Group(frog.getFrog(), cars.get(0), cars.get(1), cars.get(2), cars.get(3), cars.get(4), cars.get(5), root, livesRemaining);

        setZindexOfSprites();

        setStageAndScene(primaryStage, frogRoad);

        animationTimer();
    }

    private void animationTimer() {

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;
                if (positionAndImages.goUp()) {
                    frog.getFrog().setTranslateY(frog.getFrog().getTranslateY() - positionAndImages.KEYBOARD_MOVEMENT_DELTA());
                }
                if (positionAndImages.goDown()) {
                    frog.getFrog().setTranslateY(frog.getFrog().getTranslateY() + positionAndImages.KEYBOARD_MOVEMENT_DELTA());
                }
                if (positionAndImages.goRigth()) {
                    frog.getFrog().setTranslateX(frog.getFrog().getTranslateX() + positionAndImages.KEYBOARD_MOVEMENT_DELTA());
                }
                if (positionAndImages.goLeft()) {
                    frog.getFrog().setTranslateX(frog.getFrog().getTranslateX() - positionAndImages.KEYBOARD_MOVEMENT_DELTA());
                }
                positionAndImages.setFalseToLastKeyActive();
                if (!frog.moveFrog(dx, dy)) {

                    timer.stop();
                    musicManager.playMusic(PlayerStatus.WINNER());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Você ganhou o jogo!");
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setOnHidden(evt -> Platform.exit());
                    alert.show();
                }

                if(collisions.onUpdate((ArrayList<Node>) cars, frog, stage).compareTo(PlayerStatus.LOSER()) ==0){
                    startAgain();

                }
            }
        };
        timer.start();
    }

    private void setZindexOfSprites() {
        frog.getFrog().toFront();
        for (Node car : cars) {
            car.toFront();
        }
    }
    private void startAgain() {
        timer.stop();
        player.lostLive();
        if (player.numberOfLives() <= 0) {
            musicManager.playMusic(PlayerStatus.LOSER());
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Você perdeu o jogo!");
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setOnHidden(evt -> Platform.exit());
            alert.show();
        } else {
            try {

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Você ainda tem " + (player.numberOfLives()) + " vidas");
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
        personageImage = new Image(positionAndImages.FROG_UP());
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
        Scene scene = new Scene(frogRoad, positionAndImages.W(), positionAndImages.H());
        stage.setScene(scene);
        stage.setResizable(false);

        setKeyEvents(scene);
        stage.show();
    }

    private void setKeyEvents(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                positionAndImages.switchPosition(event.getCode());
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                positionAndImages.switchPositionAndImage(event.getCode());
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
