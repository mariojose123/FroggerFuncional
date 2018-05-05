package frogger.screen.frame.elements;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * @author Lucas Hagen.
 */
public class Place extends Pane {

    public Place(double width, double height) {
        super();

        this.setPrefHeight(height);
        this.setPrefWidth(width);
    }

    protected void setTexture(String path, int width, int height) {
        // new Image(url)
        Image image = new Image(path);

        // new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(width, height, true, true, true, false);

        // new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, backgroundSize);

        // new Background(images...)
        Background background = new Background(backgroundImage);

        this.setBackground(background);
    }

}
