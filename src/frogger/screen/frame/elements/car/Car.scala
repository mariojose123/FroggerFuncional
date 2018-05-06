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
    //setTranslateY((Math.random * 14).toInt * 40)
    PositionAndImageVariables.carPositions += finalPosition
    setTranslateY(finalPosition)
    return finalPosition

  }
  def getPosition(position: Double, list: mutable.MutableList[Double]): Double = {
    var cont = 0
    var finalPosition = position
    while (cont < list.length) {
      if (finalPosition > list(cont) + 50 || finalPosition < list(cont) - 50) {
        cont += 1
      }
      else {
        val start = (PositionAndImageVariables.H - 200).toInt
        val end: Int = PositionAndImageVariables.UP_MARGIN
        val r = new scala.util.Random
        val interval = start - end
        val newPos = start - r.nextInt(interval)
        finalPosition = newPos
        cont = 0
      }
    }
    return finalPosition
  }
}
