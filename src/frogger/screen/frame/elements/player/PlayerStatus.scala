package frogger.screen.frame.elements.player

object PlayerStatus extends Enumeration {

  type playerStatus = String

  val WINNER      = Value("WINNER")
  val LOSER       = Value("LOSER")
  val PAUSED         = Value("PAUSED")
  val STILL_ON_GAME = Value("STILL_ON_GAME")

}
