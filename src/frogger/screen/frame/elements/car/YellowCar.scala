package frogger.screen.frame.elements.car

class YellowCar extends Car {

 override def setTextureOfCar(){
    setTexture(getClass.getResource("assets/yellowCar.png").toString, 49, 24)
  }
}
