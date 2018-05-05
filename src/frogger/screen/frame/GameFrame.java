package frogger.screen.frame;

import frogger.screen.frame.elements.map.Map;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Lucas Hagen.
 */
public class GameFrame extends AnchorPane implements Initializable {

    public GameFrame() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameFrame.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();
    }

    public void generateMap() throws IOException {
        getChildren().add(new Map());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            generateMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
