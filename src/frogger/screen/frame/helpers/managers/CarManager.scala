package frogger.screen.frame.helpers.managers

import java.util

import frogger.screen.frame.elements.car.{Car, DefineCarSpawns, RedCar, YellowCar}
import frogger.screen.frame.helpers.PositionAndImageVariables
import javafx.scene.Node

import scala.collection.mutable.MutableList;
import scala.collection.JavaConverters._

class CarManager {
  private val numberCars = 6

  def addCars(positionAndImages: PositionAndImageVariables): util.List[Node] = {
    var cont = 0
    var cars: MutableList[Node] =  MutableList[Node]()
    while ( {cont < numberCars} ) {
      var newCar: Car = null
      if (cont % 2 == 0) newCar = new YellowCar
      else newCar = new RedCar
      newCar.setTranslateY(positionAndImages)
      newCar.setTextureOfCar()
      cars.+=(new DefineCarSpawns(newCar).getSpawnCar)
      positionAndImages.carPositions.add(newCar)
      cont += 1;
    }
    return cars.asJava
  }
}
