package frogger.screen.frame.elements.frog

import frogger.screen.Main
import javafx.scene.Node

object PositionCalculator {

  def moveFrogBy(frog: Node, dx: Int, dy: Int): Unit = {
    if (dx == 0 && dy == 0) return
    val cx: Double = frog.getBoundsInLocal.getWidth / 2
    val cy: Double = frog.getBoundsInLocal.getHeight / 2
    val x: Double = cx + frog.getLayoutX + dx
    val y: Double = cy + frog.getLayoutY + dy
    moveFrogTo(frog, x, y)
  }

  def moveFrogTo(frog: Node, x: Double, y: Double): Unit = {
    val cx: Double = frog.getBoundsInLocal.getWidth / 2
    val cy: Double = frog.getBoundsInLocal.getHeight / 2
    if (x - cx >= 0 && x + cx <= Main.W && y - cy >= 0 && y + cy <= Main.H) {
      frog.relocate(x - cx, y - cy)
    }

  }
}
