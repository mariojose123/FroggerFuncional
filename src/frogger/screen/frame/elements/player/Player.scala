package frogger.screen.frame.elements.player

import frogger.screen.frame.helpers.PositionAndImageVariables

class Player() {

  val positionAndImages = new PositionAndImageVariables
  var numberOfLives = 3
  def lostLive() {
    numberOfLives -= 1
  }

}
