package frogger.screen.frame.elements.car

class RedCar extends Car {

  override def setTextureOfCar(){
    setTexture(getClass.getResource("assets/redCar.png").toString, 49, 24)
  }
}
