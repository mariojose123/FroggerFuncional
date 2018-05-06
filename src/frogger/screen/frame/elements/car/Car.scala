package frogger.screen.frame.elements.car

import frogger.screen.frame.elements.TexturedElement
import frogger.screen.frame.helpers.PositionAndImageVariables

import scala.collection.mutable


abstract class Car extends TexturedElement(49, 24) {

  def setTextureOfCar() {}

  def setTranslateY(): Double = {
    val start = (PositionAndImageVariables.H - 200).toInt
    val end: Int = PositionAndImageVariables.UP_MARGIN
    val r = new scala.util.Random
    val interval = start - end
    val r1 = start - r.nextInt(interval)
    val finalPosition = getPosition(r1, PositionAndImageVariables.carPositions)
    PositionAndImageVariables.carPositions += finalPosition
    setTranslateY(finalPosition)
    return finalPosition

  }
  def getPosition(position: Double, list: mutable.MutableList[Double]): Double = {
    var count = 0
    var finalPosition = position
    while (count < list.length) {
        if ((finalPosition > list(count) + 60  || finalPosition < list(count) - 58)) {
        count += 1
      }
      else {
        val start = (PositionAndImageVariables.H - 200).toInt
        val end: Int = PositionAndImageVariables.UP_MARGIN
        val r = new scala.util.Random
        val interval = start - end
        val newPos = start - r.nextInt(interval)
        finalPosition = newPos
        count = 0
      }
    }
    return finalPosition
  }
}
