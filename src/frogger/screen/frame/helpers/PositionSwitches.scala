package frogger.screen.frame.helpers

trait PositionSwitches {

  private val positionAndImages = new PositionAndImageVariables()

  /*def switchPosition(keyCode: KeyCode): Unit = keyCode match {
    case KeyCode.UP => positionAndImages.goUp = false
    case KeyCode.DOWN => positionAndImages.goDown = false
    case KeyCode.LEFT => positionAndImages.goLeft = false
    case KeyCode.RIGHT => positionAndImages.goRigth = false
    case x => false
  }*/

 /* def switchPositionAndImage(keyCode: KeyCode): Unit = keyCode match {
    case KeyCode.UP => {
      positionAndImages.goUp = true
      ImageViewConstant.frogImg.setImage(new Image(positionAndImages.FROG_UP))
    }
    case KeyCode.DOWN => {
      positionAndImages.goDown = true
      ImageViewConstant.frogImg.setImage(new Image(positionAndImages.FROG_DOWN))
    }
    case KeyCode.LEFT
    => {
      positionAndImages.goLeft = true
      ImageViewConstant.frogImg.setImage(new Image(positionAndImages.FROG_LEFT))
    }
    case KeyCode.RIGHT
    => {
      positionAndImages.goRigth = true
      ImageViewConstant.frogImg.setImage(new Image(positionAndImages.FROG_RIGHT))
    }
    case x => {}
  }*/

  /*def setFalseToLastKeyActive(): Unit ={
    if (positionAndImages.goUp) {
      positionAndImages.goUp = false
    }
    if (positionAndImages.goDown) {
      positionAndImages.goDown = false
    }
    if (positionAndImages.goRigth) {
      positionAndImages.goRigth = false
    }
    if (positionAndImages.goLeft) {
      positionAndImages.goLeft = false
    }
  }*/
}
