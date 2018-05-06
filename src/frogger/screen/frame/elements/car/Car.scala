package frogger.screen.frame.elements.car

import frogger.screen.frame.elements.TexturedElement

abstract class Car extends TexturedElement(49, 24) {

  def setTextureOfCar() {}

  //TODO: tem de verificar se y de um carro n é mto parecido com o de outro, pq se sim eles vao ficar um em cima do outro, Dai tem de gerar outro rand

  def setTranslateY(): Unit = {
    setTranslateY((Math.random * 14).toInt * 40)
  }
}
