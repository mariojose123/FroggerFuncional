package frogger.screen.frame.elements.sidewalk

import frogger.screen.frame.elements.TexturedElement

class Sidewalk extends TexturedElement(1280, 64) {

  setTexture(getClass.getResource("sidewalk-texture.jpg").toString, 64, 64)

}
