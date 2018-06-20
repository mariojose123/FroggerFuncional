package frogger.screen.frame.elements.frog

import frogger.screen.frame.helpers.PositionCalculator
import javafx.scene.Node

class Frog(var frog: Node) {

  val positionCalculator = new PositionCalculator

  def getFrog(): Node ={
    if(frog == null) throw new Exception("Erro no jogo, tente jogar novamente!")
    return frog
  }
  def moveFrog(dx: Int, dy: Int): Boolean = {
    val boundsInScene = frog.localToScene(frog.getBoundsInLocal)
    if (boundsInScene.getMinY > 10) {
      positionCalculator.moveFrog(frog, dx, dy)
      return true
    }
    return false
  }

  def moveFrog(x: Double, y: Double): Unit = {
    positionCalculator.moveFrog(frog, x, y)
  }

  /*def switchFrog(keyCode: KeyCode): Unit = {
    PositionCalculator.switchPosition(keyCode)
  }*/

  /*def setLastKeyPressedToFalse(): Unit = {
    PositionCalculator.setFalseToLastKeyActive()
  }*/

  /*def switchFrogPositionAndImage(keyCode: KeyCode): Unit = {
    PositionCalculator.switchDirectionAndImage(keyCode)
  }*/

}
