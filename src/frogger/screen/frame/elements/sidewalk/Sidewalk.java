package frogger.screen.frame.elements.sidewalk;

import frogger.screen.frame.elements.Place;

/**
 * @author Lucas Hagen.
 */
public class Sidewalk extends Place {

    public Sidewalk() {
        super(1280, 64);

        setTexture(getClass().getResource("sidewalk-texture.jpg").toString(), 64, 64);
    }

}
