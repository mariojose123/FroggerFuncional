package frogger.screen.`object`.Log

import frogger.screen.`object`.Frog.RetangleObject
import frogger.screen.`object`.RunningObject
import javafx.scene.paint.Color

class Log(height:java.lang.Double , width: java.lang.Double , color: Color, _positionY: java.lang.Double, right:java.lang.Boolean) extends RunningObject(height , width , color,_positionY, right){
  setGameObjectRectangle(height, width, color)
  var RandomPosition = math.random()
  if (right) {
    move(800, 0.1 *  positionY *14 * 40)
  }
  else {
    move(0, 0.1 *  positionY *14 * 40)
  }
  var initY =0
  if(right){
    initY=800
  }
  else{
    initY=0
  }
}
