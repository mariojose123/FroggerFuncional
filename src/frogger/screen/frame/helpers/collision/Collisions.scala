package frogger.screen.frame.helpers.collision

import frogger.screen.frame.elements.frog.Frog
import javafx.animation.AnimationTimer
import javafx.scene.Node

import scala.collection.JavaConversions.asScalaBuffer

object Collisions {

  
   def onUpdate(carList: java.util.ArrayList[Node], frog: Frog, timer: AnimationTimer): Unit = {
    for (car <- carList) car.setTranslateX(car.getTranslateX + Math.random() * 10)
    checkState(carList, frog, timer)
  }

  private def checkState(carList: java.util.ArrayList[Node], frog: Frog, timer: AnimationTimer): Unit = {

    for (car <- carList
         if car.getBoundsInParent.intersects(frog.getFrog.getBoundsInParent)) {
          timer.stop()

    }
  }

}
