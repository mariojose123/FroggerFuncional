package frogger.screen.frame.elements.car

import frogger.screen.frame.elements.TexturedElement

class Car extends TexturedElement(49, 24) {

  setTexture(getClass.getResource("car.png").toString, 49, 24)

}
