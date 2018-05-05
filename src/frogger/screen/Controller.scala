package frogger.screen

import java.net.URL
import java.util.ResourceBundle

import frogger.screen.frame.GameFrame
import javafx.fxml.{FXML, Initializable}
import javafx.scene.layout.AnchorPane

class Controller extends Initializable {

    @FXML
    var mainPane: AnchorPane = _

    override def initialize(location: URL, resources: ResourceBundle): Unit = {
      try mainPane.getChildren.add(new GameFrame())
      catch {
        case e: Exception => e.printStackTrace()

      }
    }

}
