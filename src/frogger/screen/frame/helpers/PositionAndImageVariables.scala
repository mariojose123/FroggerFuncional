package frogger.screen.frame.helpers

import javafx.fxml.FXML

import javafx.scene.image.ImageView

//remove if not needed
import scala.collection.JavaConversions._

object PositionAndImageVariables {

  @FXML
  val frogImg: ImageView =frogImg

  val W: Double = 1260

  val H: Double = 720

  val FROG_UP: String = "frogger/screen/frame/elements/frog/frog-up.png"

  val FROG_DOWN: String = "frogger/screen/frame/elements/frog/frog-down.png"

  val FROG_LEFT: String = "frogger/screen/frame/elements/frog/frog-left.png"

  val FROG_RIGHT: String = "frogger/screen/frame/elements/frog/frog-right.png"

  var goUp: Boolean = false

  var goDown: Boolean = false

  var goRigth: Boolean = false

  var goLeft: Boolean = false

}
