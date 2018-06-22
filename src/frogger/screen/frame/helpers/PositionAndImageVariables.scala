package frogger.screen.frame.helpers

import frogger.screen.frame.elements.car.Car
import javafx.scene.image.Image
import javafx.scene.input.KeyCode

class PositionAndImageVariables() {

  val KEYBOARD_MOVEMENT_DELTA = 12


  val W: Double = 1260

  val H: Double = 640

  val FROG_UP: String = "frogger/screen/frame/elements/frog/assets/frog-up.png"

  val FROG_DOWN: String = "frogger/screen/frame/elements/frog/assets/frog-down.png"

  val FROG_LEFT: String = "frogger/screen/frame/elements/frog/assets/frog-left.png"

  val FROG_RIGHT: String = "frogger/screen/frame/elements/frog/assets/frog-right.png"

  var goUp: Boolean = false

  var goDown: Boolean = false

  var goRigth: Boolean = false

  var goLeft: Boolean = false

  //var livesRemaing = 3

  var UP_MARGIN = 50

  //var carPositions = mutable.MutableList[Double]()
  var carPositions = new GenericList[Car]

  def restartCarPositionsList(): Unit = {
    //carPositions = mutable.MutableList[Double]()
    carPositions.restart()
  }

  /*def reestartLivesRemaining(): Unit ={
    if(livesRemaing < 0) livesRemaing = 3;
  }*/
  def switchPosition(keyCode: KeyCode): Unit = keyCode match {
    case KeyCode.UP => this.goUp = false
    case KeyCode.DOWN => this.goDown = false
    case KeyCode.LEFT => this.goLeft = false
    case KeyCode.RIGHT => this.goRigth = false
    case x => false
  }
  def switchPositionAndImage(keyCode: KeyCode): Unit = keyCode match {
    case KeyCode.UP => {
      this.goUp = true
      ImageViewConstant.frogImg.setImage(new Image(this.FROG_UP))
    }
    case KeyCode.DOWN => {
      this.goDown = true
      ImageViewConstant.frogImg.setImage(new Image(this.FROG_DOWN))
    }
    case KeyCode.LEFT
    => {
      this.goLeft = true
      ImageViewConstant.frogImg.setImage(new Image(this.FROG_LEFT))
    }
    case KeyCode.RIGHT
    => {
      this.goRigth = true
      ImageViewConstant.frogImg.setImage(new Image(this.FROG_RIGHT))
    }
    case x => {}
  }
  def setFalseToLastKeyActive(): Unit ={
    if (this.goUp) {
      this.goUp = false
    }
    if (this.goDown) {
      this.goDown = false
    }
    if (this.goRigth) {
      this.goRigth = false
    }
    if (this.goLeft) {
      this.goLeft = false
    }
  }

}
