package frogger.screen.frame.elements.map;

import frogger.screen.frame.elements.TexturedElement;
import frogger.screen.frame.elements.car.Car;
import frogger.screen.frame.elements.sidewalk.Sidewalk;
import frogger.screen.frame.elements.street.Street;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Hagen.
 */
public class Map extends VBox {

    private List<TexturedElement> places;

    private Car car;

    public Map() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Map.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();

        places = new ArrayList<>();

        addPlaces();

        printPlaces();
    }

    private void printPlaces() {
        for(TexturedElement place : places)
            getChildren().add(place);
    }

    private void addPlaces() {
        places.add(new Sidewalk());
        places.add(new Street(1));
        places.add(new Sidewalk());
        places.add(new Street(2));
        places.add(new Sidewalk());
        places.add(new Street(1));
        places.add(new Sidewalk());
        places.add(new Street(2));

    }

}
