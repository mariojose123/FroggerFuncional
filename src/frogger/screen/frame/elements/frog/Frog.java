package frogger.screen.frame.elements.frog;

import frogger.screen.frame.elements.car.Car;
import frogger.screen.frame.helpers.PositionCalculator;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;

import java.util.List;


public class Frog {

	private Node frog;

	public Frog(Node frog) {
		this.frog = frog;
	}

	public Node getFrog() {
		return frog;
	}

	public void moveFrogBy(int dx, int dy) {
		PositionCalculator.moveFrogBy(frog, dx, dy);
	}

	public void moveFrogTo(double x, double y) {
		PositionCalculator.moveFrogTo(frog, x, y);
	}

	public void switchFrog(KeyCode keyCode) {
		PositionCalculator.switchPosition(keyCode);
	}
	public void setLastKeyPressedToFalse() {
		PositionCalculator.setFalseToLastKeyActive();
	}

	public void switchFrogPositionAndImage(KeyCode keyCode) {
		PositionCalculator.switchDirectionAndImage(keyCode);
	}

}
