package frogger.screen.`object`

import frogger.screen.`object`.Frog.RetangleObject
import javafx.scene.paint.Color

class RunningObject(height:java.lang.Double , width: java.lang.Double , color: Color, var  _positionY: java.lang.Double, var right:java.lang.Boolean)extends RetangleObject {

  def move( Velo : java.lang.Double): Unit =
  {
    if(right) {
      super.move(NodeX() - 1 * Velo, NodeY())
    }
    else{
      super.move(NodeX() + 1 * Velo, NodeY())
    }
  }
  def positionY:Double = _positionY
}
