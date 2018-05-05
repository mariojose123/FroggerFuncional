package frogger.screen.frame.helpers.UserCommunication

import frogger.screen.frame.elements.player.PlayerStatus
import frogger.screen.frame.helpers.PositionAndImageVariables
import javafx.animation.AnimationTimer
import javafx.application.Platform
import javafx.scene.control.{Alert, DialogEvent}

object AlertManager {

  def showAlert(playerStatus: PlayerStatus.Value, timer: AnimationTimer): Unit = {
    timer.stop()
    playerStatus match {
      case PlayerStatus.LOSER  => showFinishGameAlert("Que pena! Você perdeu!")
      case PlayerStatus.WINNER => showFinishGameAlert("Parabéns, você venceu!")
      case PlayerStatus.STILL_ON_GAME => restartGameAlert()
      // catch the default with a variable so you can print it
      case whoa  => println("Unexpected case: " + whoa.toString)
    }


  }
  def showFinishGameAlert(message: String): Unit ={
    val alert = new Alert(Alert.AlertType.INFORMATION, message)
    alert.setTitle(null)
    alert.setHeaderText(null)
    alert.setOnHidden((evt: DialogEvent) => Platform.exit())
    alert.show()
  }
  def restartGameAlert(): Unit = {


    try {
      val alert = new Alert(Alert.AlertType.INFORMATION, "Você ainda tem " + PositionAndImageVariables.livesRemaing + " vidas")
      alert.setTitle(null)
      alert.setHeaderText(null)
      alert.setOnHidden((evt: DialogEvent) => {
        def foo(evt: DialogEvent) = try
          //start(stage) // quero que quando ele der ok chame a funcao start da main
        catch {
          case e: Exception =>
            e.printStackTrace()
        }

        foo(evt)
      })
      alert.show()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }

  }
}
