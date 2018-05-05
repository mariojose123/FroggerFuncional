package frogger.screen.frame.elements.car;

import frogger.screen.frame.elements.TexturedElement;

/**
 * @author Lucas Hagen.
 */
public class Car extends TexturedElement {

    private static String TEXTURE = "car.png";
    private static int WIDTH = 49;
    private static int HEIGHT = 24;

    public Car() {
        super(WIDTH, HEIGHT);

        setTexture(getClass().getResource(TEXTURE).toString(), WIDTH, HEIGHT);
    }

    public void move(int x, int y) {
        setTranslateX(getTranslateX() + x);
        setTranslateY(getTranslateY() + y);
    }

}
