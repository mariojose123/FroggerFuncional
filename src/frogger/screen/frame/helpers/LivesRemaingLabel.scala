package frogger.screen.frame.helpers

import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.layout.{AnchorPane, Background, BackgroundFill, CornerRadii}
import javafx.scene.paint.Color
import frogger.screen.frame.elements.player.Player

class LivesRemaingLabel(player : Player) {

 // private val positionAndImages = new PositionAndImageVariables

  def livesRemainingPanel(anchor: AnchorPane, livesRemaining: Label): Unit = {
    AnchorPane.setTopAnchor(livesRemaining, 50.0)
    AnchorPane.setRightAnchor(livesRemaining, 50.0)
     livesRemaining.setText(new StringBuilder().append("Vidas Restantes: "+ player.numberOfLives).toString())
    livesRemaining.setTextFill(Color.web("#0076a3"))
    livesRemaining.setScaleY(1.5)
    livesRemaining
      .backgroundProperty()
      .setValue(
        new Background(
          new BackgroundFill(Color.CORNFLOWERBLUE,
            CornerRadii.EMPTY,
            Insets.EMPTY)))
    anchor.toFront()
    anchor.getChildren.add(livesRemaining)
  }

}
