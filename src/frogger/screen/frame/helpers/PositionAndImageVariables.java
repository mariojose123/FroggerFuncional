package frogger.screen.frame.helpers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class PositionAndImageVariables {

    @FXML
    public static ImageView frogImg;

    public static final double W = 1260, H = 720;

    public static final String FROG_UP = "frogger/screen/frame/elements/frog/frog-up.png";
    public static final String FROG_DOWN = "frogger/screen/frame/elements/frog/frog-down.png";
    public static final String FROG_LEFT = "frogger/screen/frame/elements/frog/frog-left.png";
    public static final String FROG_RIGHT = "frogger/screen/frame/elements/frog/frog-right.png";

    public static boolean goUp = false, goDown = false, goRigth = false, goLeft = false;
}
