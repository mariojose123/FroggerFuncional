package frogger.screen.`object`.Car
import javafx.scene.paint.Color
import javafx.scene.Node
import frogger.screen.`object`.Frog.RetangleObject

class Car(height:java.lang.Double , width: java.lang.Double , color: Color, MinSpawnY: java.lang.Double , MaxSpawnY:java.lang.Double ) extends RetangleObject
{
  var right:Boolean=true;
  setGameObjectRectangle(height,width, color)
    var RandomPosition = math.random()
    private var Velo:java.lang.Double=0
    Velo=math.ceil(RandomPosition * (MaxSpawnY-MinSpawnY+1));
    if(math.ceil(RandomPosition * (MaxSpawnY-MinSpawnY+1))%2==0){
      right=true;
      move(800, (0.1 * (math.ceil(RandomPosition * (MaxSpawnY-MinSpawnY+1)) + (MinSpawnY-1)) * 14) * 40)
    }
    else{
      right=false
      move(NodeX(), (0.1 * (math.ceil(RandomPosition * (MaxSpawnY-MinSpawnY+1)) + (MinSpawnY-1)) * 14) * 40)
    }
  def move( ): Unit =
  {
    if(right) {
      super.move(NodeX() - 1 * Velo, NodeY())
    }
    else{
      super.move(NodeX() + 1 * Velo, NodeY())
    }
  }

}
