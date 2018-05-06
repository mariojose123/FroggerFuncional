package frogger.screen.frame.elements.frog

import frogger.screen.frame.helpers.PositionCalculator
import javafx.scene.Node
import javafx.scene.input.KeyCode

class Frog(var frog: Node) {

  def getFrog(): Node ={
    if(frog == null) throw new Exception("Erro no jogo, tente jogar novamente!")
    return frog
  }
//Usar polimorfismo por sobrecarga(ESSES DOIS ABAIXO)
  def moveFrog(dx: Int, dy: Int): Unit = {
    PositionCalculator.moveFrogBy(frog, dx, dy)
  }

  def moveFrog(x: Double, y: Double): Unit = {
    
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
