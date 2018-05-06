package frogger.screen.frame.elements.frog

import frogger.screen.frame.helpers.PositionCalculator
import javafx.scene.Node
import javafx.scene.input.KeyCode

import scala.beans.BeanProperty

class Frog(@BeanProperty var frog: Node) {

  def moveFrogBy(dx: Int, dy: Int): Boolean = {
   // print(this.frog.getLayoutY + "\n")
    val boundsInScene = frog.localToScene(frog.getBoundsInLocal)
    //print(boundsInScene.getMinY + "\n")
    if (boundsInScene.getMinY > 50) {
      PositionCalculator.moveFrogBy(frog, dx, dy)
      return true
    }
    return false
  }

  def moveFrogTo(x: Double, y: Double): Unit = {
    PositionCalculator.moveFrogTo(frog, x, y)
  }

  def switchFrog(keyCode: KeyCode): Unit = {
    PositionCalculator.switchPosition(keyCode)
  }

  def setLastKeyPressedToFalse(): Unit = {
    PositionCalculator.setFalseToLastKeyActive()
  }

  def switchFrogPositionAndImage(keyCode: KeyCode): Unit = {
    PositionCalculator.switchDirectionAndImage(keyCode)
  }

}
