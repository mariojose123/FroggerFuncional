package frogger.screen.frame.helpers

import javafx.scene.Node

class PositionCalculator  {

  private val positionAndImages = new PositionAndImageVariables()

  def moveFrog(frog: Node, dx: Int, dy: Int): Unit = {
    if (dx == 0 && dy == 0) return
    val cx: Double = frog.getBoundsInLocal.getWidth / 2
    val cy: Double = frog.getBoundsInLocal.getHeight / 2
    val x: Double = cx + frog.getLayoutX + dx
    val y: Double = cy + frog.getLayoutY + dy
    moveFrog(frog, x, y)
  }

  def moveFrog(frog: Node, x: Double, y: Double): Unit = {
    val cx: Double = frog.getBoundsInLocal.getWidth / 2
    val cy: Double = frog.getBoundsInLocal.getHeight / 2
    if (x - cx >= 0 && x + cx <= positionAndImages.W && y - cy >= 0 && y + cy <= positionAndImages.H) {
      frog.relocate(x - cx, y - cy)
    }
  }

}
