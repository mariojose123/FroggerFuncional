package frogger.screen.frame.helpers.collision

import frogger.screen.frame.elements.frog.Frog
import frogger.screen.frame.elements.player.PlayerStatus
import javafx.scene.Node
import javafx.stage.Stage

import scala.collection.JavaConversions.asScalaBuffer

class Collisions {

  def onUpdate(carList: java.util.ArrayList[Node], frog: Frog, stage: Stage):  PlayerStatus.Value = {
    for (car <- carList) {
      if (car.getTranslateX > stage.getWidth){
        car.setTranslateX(0)
      }
      car.setTranslateX(car.getTranslateX + Math.random() * 10)
    }
    return checkState(carList, frog)
  }

  private def checkState(carList: java.util.ArrayList[Node], frog: Frog): PlayerStatus.Value = {
    for (car <- carList
         if car.getBoundsInParent.intersects(frog.getFrog.getBoundsInParent)) {
      return PlayerStatus.LOSER
    }
    return PlayerStatus.STILL_ON_GAME;

  }

}
