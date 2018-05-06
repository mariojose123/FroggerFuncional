
package frogger.screen.frame.elements.car

import javafx.scene.Node

class DefineCarSpawns(val car: Car) {


  //deixar isso assim tbm pq é o construtor por sobrecarga, NAO MEXER PFF OU CABEÇAS ROLARÃO, hihi <3

  def this(car: YellowCar) = {
    this(car: Car)
    spawnCars(car)
  }

  def this(car: RedCar) = {
    this(car: Car)
    spawnCars(car)
  }

  def getSpawnCar(): Node = {
    if(car == null) throw new Exception("Erro de sistema, reinicie o jogo, por favor!")
    return car
  }

  def spawnCars(yellowCar: YellowCar): YellowCar = {
    yellowCar.setTranslateY()
    yellowCar.setTextureOfCar()
    return yellowCar
  }

  def spawnCars(redCar: RedCar): RedCar = {
    redCar.setTranslateY()
    redCar.setTextureOfCar()
    return redCar
  }

}


