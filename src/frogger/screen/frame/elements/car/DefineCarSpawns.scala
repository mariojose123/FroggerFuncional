package frogger.screen.frame.elements.car

class DefineCarSpawns {

   def spawnYellowCar = {
    val car = new YellowCar
    car.setTranslateY()
    car.setTextureOfCar()
    car
  }

  def spawnRedCar = {
    val car = new RedCar
    car.setTranslateY()
    car.setTextureOfCar()
    car
  }
}
