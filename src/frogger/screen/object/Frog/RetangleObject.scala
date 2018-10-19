package frogger.screen.`object`.Frog
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
 abstract class RetangleObject extends PositionObject {
  def setGameObjectRectangle( x: java.lang.Double, y: java.lang.Double,  Color:Paint) {
    var  GameObjectRectangle :  Rectangle = new Rectangle(x, y, Color);
    setNode(GameObjectRectangle);
    return;
  }
}