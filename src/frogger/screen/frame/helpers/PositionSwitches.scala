package frogger.screen.frame.helpers

import javafx.scene.image.Image
import javafx.scene.input.KeyCode

trait PositionSwitches {

  def switchPosition(keyCode: KeyCode): Unit = keyCode match {
    case KeyCode.UP => PositionAndImageVariables.goUp = false
    case KeyCode.DOWN => PositionAndImageVariables.goDown = false
    case KeyCode.LEFT => PositionAndImageVariables.goLeft = false
    case KeyCode.RIGHT => PositionAndImageVariables.goRigth = false
  }

  def switchPositionAndImage(keyCode: KeyCode): Unit = keyCode match {
    case KeyCode.UP => {
      PositionAndImageVariables.goUp = true
      PositionAndImageVariables.frogImg.setImage(new Image(PositionAndImageVariables.FROG_UP))
    }
    case KeyCode.DOWN => {
      PositionAndImageVariables.goDown = true
      PositionAndImageVariables.frogImg.setImage(new Image(PositionAndImageVariables.FROG_DOWN))
    }
    case KeyCode.LEFT
    => {
      PositionAndImageVariables.goLeft = true
      PositionAndImageVariables.frogImg.setImage(new Image(PositionAndImageVariables.FROG_LEFT))
    }
    case KeyCode.RIGHT
    => {
      PositionAndImageVariables.goRigth = true
      PositionAndImageVariables.frogImg.setImage(new Image(PositionAndImageVariables.FROG_RIGHT))
    }
  }

  def setFalseToLastKeyActive(): Unit ={
    if (PositionAndImageVariables.goUp) {
      PositionAndImageVariables.goUp = false
    }
    if (PositionAndImageVariables.goDown) {
      PositionAndImageVariables.goDown = false
    }
    if (PositionAndImageVariables.goRigth) {
      PositionAndImageVariables.goRigth = false
    }
    if (PositionAndImageVariables.goLeft) {
      PositionAndImageVariables.goLeft = false
    }
  }
}
