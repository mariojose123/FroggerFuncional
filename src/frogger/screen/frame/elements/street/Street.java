package frogger.screen.frame.elements.street;

import frogger.screen.frame.elements.Place;

/**
 * @author Lucas Hagen.
 */
public class Street extends Place {

    private int lanes;

    public Street(int lanes) {
        super(1280, lanes * 64);

        setTexture(getClass().getResource("street-texture.jpg").toString(), 64, 64);
    }

}
