package frogger.screen.frame.elements.sidewalk;

import frogger.screen.frame.elements.TexturedElement;

/**
 * @author Lucas Hagen.
 */
public class Sidewalk extends TexturedElement {

    public Sidewalk() {
        super(1280, 64);

        setTexture(getClass().getResource("sidewalk-texture.jpg").toString(), 64, 64);
    }

}
