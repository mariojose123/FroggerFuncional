package frogger.screen.frame.elements.frog

import frogger.screen.frame.helpers.PositionCalculator
import javafx.scene.Node
import javafx.scene.input.KeyCode

import scala.beans.BeanProperty

class Frog(@BeanProperty var frog: Node) {

  def moveFrogBy(dx: Int, dy: Int): Unit = {
    PositionCalculator.moveFrogBy(frog, dx, dy)
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
