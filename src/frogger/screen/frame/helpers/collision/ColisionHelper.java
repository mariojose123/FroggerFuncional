package frogger.screen.frame.helpers.collision;

import frogger.screen.frame.elements.frog.Frog;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class ColisionHelper {
    public static void colisionHelper(List<Node> cars, Frog frog, AnimationTimer timer){
        Collisions.onUpdate((ArrayList<Node>) cars, frog, timer);
    }
}
