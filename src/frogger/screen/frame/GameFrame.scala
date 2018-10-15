package frogger.screen.frame

import java.net.URL
import java.util.ResourceBundle

import frogger.screen.frame.elements.map.Map
import javafx.fxml.{FXMLLoader, Initializable}
import javafx.scene.layout.AnchorPane

class GameFrame extends AnchorPane with Initializable {

  val fxmlLoader: FXMLLoader = new FXMLLoader(
    getClass.getResource("GameFrame.fxml"))

  fxmlLoader.setRoot(this)

  fxmlLoader.setController(this)

  fxmlLoader.load()

  private def generateMap(): Unit = {
    getChildren.add(new Map())
  }

  override def initialize(location: URL, resources: ResourceBundle): Unit = {
    try generateMap()
    catch {
      case e: Exception => e.printStackTrace()

    }
  }

}