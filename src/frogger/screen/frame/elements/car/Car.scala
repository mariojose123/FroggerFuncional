package frogger.screen.frame.elements.car

import frogger.screen.frame.elements.Vehicle.Vehicle
import javafx.scene.Node

import scala.beans.BeanProperty

class Car(@BeanProperty var carNode: Node) extends Vehicle {

  setTranslateY((Math.random * 14).toInt * 40)

  //setTexture(getClass.getResource("Resources/star.png").toString, 49, 24)
  override def move(): Unit = {
    this.carNode.setTranslateX( this.carNode.getTranslateX + 20)
  }

  //TODO: tem de verificar se y de um carro n é mto parecido com o de outro, pq se sim eles vao ficar um em cima do outro, Dai tem de gerar outro rand
//  private def spawnCar = {
//    val car = new Car
//    car.setTranslateY((Math.random * 14).toInt * 40)
//    car
//  }

}
