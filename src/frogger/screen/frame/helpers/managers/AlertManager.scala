package frogger.screen.frame.helpers.managers
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.{Alert, DialogEvent}


class AlertManager {

  def displayAlert(numberOfLives : Int, f: DialogEvent => DialogEvent) = {

    val alert = new Alert(AlertType.INFORMATION)
    alert.setTitle("Atenção")
    alert.setHeaderText(null)
    alert.setContentText("Você tem ainda " + numberOfLives + " vidas")
    alert.setOnHidden(evt => f(evt))
    alert.show()

  }


}
