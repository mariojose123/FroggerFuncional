package frogger.screen.frame.elements.street;

import frogger.screen.frame.elements.TexturedElement;
import frogger.screen.frame.elements.car.Car;

/**
 * @author Lucas Hagen.
 */
public class Street extends TexturedElement {

    private int lanes;

    public Street(int lanes) {
        super(1280, lanes * 64);

        setTexture(getClass().getResource("street-texture.jpg").toString(), 64, 64);
    }

    public void addCar(Car car) {
        this.getChildren().add(car);
    }

}
