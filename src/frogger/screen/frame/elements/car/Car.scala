package frogger.screen.frame.elements.car

import frogger.screen.frame.elements.TexturedElement
import frogger.screen.frame.helpers.PositionAndImageVariables

import scala.collection.mutable


abstract class Car extends TexturedElement(49, 24) {


  def setTextureOfCar() {}

  def setTranslateY(positionAndImages: PositionAndImageVariables): Double = {
    val start = (positionAndImages.H - 200).toInt
    val end: Int = positionAndImages.UP_MARGIN
    val r = new scala.util.Random
    val interval = start - end
    val r1 = start - r.nextInt(interval)
    val finalPosition = getPos(positionAndImages.carPositions.elements)
    //positionAndImages.carPositions.add(this) //+= finalPosition
    setTranslateY(finalPosition)
    return finalPosition

  }

  def getPos(list: mutable.MutableList[Car]): Double = {
    if (list.isEmpty) {
      return 402
    }
    else {
      val lastElement = list(list.length - 1)
      return lastElement.localToScene(lastElement.getBoundsInLocal).getMinY - 64
    }
  }

  //parei de usar, só nao tirei ainda pra vai que
 /* def getPosition(position: Double, list: mutable.MutableList[Car]): Double = {
    var count = 0
    var finalPosition = position
    while (count < list.length) {
        if ((finalPosition > list(count).getTranslateY + 60  || finalPosition < list(count).getTranslateY - 58)) {
        count += 1
      }
      else {
        val start = (positionAndImages.H - 200).toInt
        val end: Int = positionAndImages.UP_MARGIN
        val r = new scala.util.Random
        val interval = start - end
        val newPos = start - r.nextInt(interval)
        finalPosition = newPos
        count = 0
      }
    }
    return finalPosition
  }*/
}
