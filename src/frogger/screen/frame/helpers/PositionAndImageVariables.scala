package frogger.screen.frame.helpers

object PositionAndImageVariables {

  val KEYBOARD_MOVEMENT_DELTA = 12

  val W: Double = 1260

  val H: Double = 720

  val FROG_UP: String = "frogger/screen/frame/elements/frog/assets/frog-up.png"

  val FROG_DOWN: String = "frogger/screen/frame/elements/frog/assets/frog-down.png"

  val FROG_LEFT: String = "frogger/screen/frame/elements/frog/assets/frog-left.png"

  val FROG_RIGHT: String = "frogger/screen/frame/elements/frog/assets/frog-right.png"

  var goUp: Boolean = false

  var goDown: Boolean = false

  var goRigth: Boolean = false

  var goLeft: Boolean = false

  var livesRemaing = 3

  def reestartLivesRemaining(): Unit ={
    livesRemaing = 3;
  }

}
