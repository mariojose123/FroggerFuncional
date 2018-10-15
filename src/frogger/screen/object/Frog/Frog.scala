package frogger.screen.`object`.Frog
import javafx.scene.Node;
import scala.collection.mutable
import javafx.scene.paint.Color

class Frog(var height:java.lang.Double ,var width: java.lang.Double ,var color: Color ) extends RetangleObject {
  setGameObjectRectangle(height,width, color)
  def CheckWin(): Boolean ={
     return (NodeY()<=0);
  }
}
