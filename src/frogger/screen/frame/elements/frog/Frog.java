package frogger.screen.frame.elements.frog;

import javafx.scene.Node;


public class Frog {

	private Node frog;

	public Frog(Node frog){
		this.frog = frog;
	}

	public Node getFrog(){
		return frog;
	}
	public void moveFrogBy(int dx, int dy) {
		PositionCalculator.moveFrogBy(frog, dx, dy);
	}

	public void moveFrogTo(double x, double y) {
		PositionCalculator.moveFrogTo(frog, x, y);
	}
}
