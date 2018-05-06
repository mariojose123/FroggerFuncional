package frogger.screen.frame.helpers.collision

import frogger.screen.frame.elements.car.Car
import frogger.screen.frame.elements.frog.Frog
import frogger.screen.frame.elements.player.PlayerStatus
import javafx.stage.Stage

import scala.collection.JavaConversions.asScalaBuffer

object Collisions {


  def onUpdate(carList: java.util.ArrayList[Car], frog: Frog, stage: Stage):  PlayerStatus.Value = {
    for (car <- carList) {
      print(car.getCarNode.getTranslateX)
      if (car.getCarNode.getTranslateX > stage.getWidth){
        print("aaa")
        car.getCarNode.setTranslateX(0)
      }
      else {
        car.move()
      }

    }
    return checkState(carList, frog)
  }

  private def checkState(carList: java.util.ArrayList[Car], frog: Frog): PlayerStatus.Value = {

    for (car <- carList
         if car.getCarNode.getBoundsInParent.intersects(frog.getFrog.getBoundsInParent)) {
      print("player perdeu "  + "\n")
      return PlayerStatus.LOSER
    }
    print("playernogame" + "\n")
    return PlayerStatus.STILL_ON_GAME;

  }

}
