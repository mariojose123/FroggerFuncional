package frogger.screen.frame.helpers

import java.io.File
import frogger.screen.frame.elements.player.PlayerStatus

import javafx.scene.media.{Media, MediaPlayer}

class MusicManager() {

  private var musicFile = "music.mp3"
  private var sound = new Media(new File(musicFile).toURI.toString)
  private var mediaPlayer = new MediaPlayer(sound)
  private var playerState = PlayerStatus.STILL_ON_GAME

  def playMusic(playerStatus: PlayerStatus.Value){
    mediaPlayer.stop()
    playerState = playerStatus
    playSound(buildMusicPath)
  }

  private def buildMusicPath(playerStatus: PlayerStatus.Value): String ={
    playerStatus match {
      case PlayerStatus.STILL_ON_GAME => return  "music.mp3"
      case PlayerStatus.WINNER => return "cheer.mp3"
      case PlayerStatus.LOSER => return "gameOver.wav"
      case whoa => return ""
    }
  }
  private def chooseMusicCycle(playerStatus: PlayerStatus.Value, musicPlayer: MediaPlayer): Unit ={
    if (playerStatus == PlayerStatus.STILL_ON_GAME) {
      mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE)
    }
  }

  private def playSound(f: PlayerStatus.Value => String): Unit ={
      musicFile = f(playerState)
      sound = new Media(new File(musicFile).toURI.toString)
      mediaPlayer = new MediaPlayer(sound)
      chooseMusicCycle(playerState, mediaPlayer)
      mediaPlayer.play()
  }



}
