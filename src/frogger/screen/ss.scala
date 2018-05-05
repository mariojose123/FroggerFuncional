//package frogger.screen
//
//import frogger.screen.frame.GameFrame
//
//import frogger.screen.frame.elements.frog.Frog
//
//import javafx.animation.AnimationTimer
//
//import javafx.application.Application
//
//import javafx.event.EventHandler
//
//import javafx.fxml.FXML
//
//import javafx.fxml.FXMLLoader
//
//import javafx.scene.Group
//
//import javafx.scene.Node
//
//import javafx.scene.Parent
//
//import javafx.scene.Scene
//
//import javafx.scene.image.Image
//
//import javafx.scene.image.ImageView
//
//import javafx.scene.input.KeyEvent
//
//import javafx.stage.Stage
//
//import java.io.IOException
//
//import Main._
//
////remove if not needed
//import scala.collection.JavaConversions._
//
//object ss extends Application{
//
//  val W: Double = 1260
//
//  val H: Double = 720
//
//  private val FROG_UP: String =
//    "frogger/screen/frame/elements/frog/frog-up.png"
//
//  private val FROG_DOWN: String =
//    "frogger/screen/frame/elements/frog/frog-down.png"
//
//  private val FROG_LEFT: String =
//    "frogger/screen/frame/elements/frog/frog-left.png"
//
//  private val FROG_RIGHT: String =
//    "frogger/screen/frame/elements/frog/frog-right.png"
//
//  def main(args: Array[String]): Unit = {
//    launch(args)
//  }
//
//}
//
//class ss extends Application {
//
//  private var game: GameFrame = _
//
//  private var stage: Stage = _
//
//  @FXML
//  private var frogImg: ImageView = _
//
//  private var heroImage: Image = _
//
//  private var hero: Node = _
//
//  var goNorth: Boolean = _
//
//  var goSouth: Boolean = _
//
//  var goEast: Boolean = _
//
//  var goWest: Boolean = _
//
//  override def start(primaryStage: Stage): Unit = {
//    heroImage = new Image(FROG_UP)
//    frogImg = new ImageView(heroImage)
//    hero = frogImg
//    val frog: Frog = new Frog(hero)
//    frog.moveFrogTo(W / 2, H / 2)
//    val root: Parent = FXMLLoader.load(getClass.getResource("mainscreen.fxml"))
//    val dungeon: Group = new Group(frog.getFrog, root)
//    frog.getFrog.toFront()
//    this.stage = primaryStage
//    stage.setTitle("Frogger - MLP")
//    val scene: Scene = new Scene(dungeon, W, H)
//    stage.setScene(scene)
//    stage.setResizable(false)
//    scene.setOnKeyPressed(new EventHandler[KeyEvent]() {
//      override def handle(event: KeyEvent): Unit = {
//        event.getCode match {
//          case UP => goNorth = true
//          case DOWN => goSouth = true
//          case LEFT => goWest = true
//          case RIGHT => goEast = true
//
//        }
//      }
//    })
//    scene.setOnKeyReleased(new EventHandler[KeyEvent]() {
//      override def handle(event: KeyEvent): Unit = {
//        event.getCode match {
//          case UP => {
//            goNorth = false
//            frogImg.setImage(new Image(FROG_UP))
//          }
//          case DOWN => {
//            goSouth = false
//            frogImg.setImage(new Image(FROG_DOWN))
//          }
//          case LEFT => {
//            goWest = false
//            frogImg.setImage(new Image(FROG_LEFT))
//          }
//          case RIGHT => {
//            goEast = false
//            frogImg.setImage(new Image(FROG_RIGHT))
//          }
//
//        }
//      }
//    })
//    stage.show()
//    val timer: AnimationTimer = new AnimationTimer() {
//      override def handle(now: Long): Unit = {
//        var dx: Int = 0
//        var dy: Int = 0
//        if (goNorth) dy -= 6
//        if (goSouth) dy += 6
//        if (goEast) dx += 6
//        if (goWest) dx -= 6
//        frog.moveFrogBy(dx, dy)
//      }
//    }
//    timer.start()
//  }
//
////eu fiz na chinelagem ali mesmo tudojunto pq n sei separar, dai quem conseguir colocar o handle dos eventos aqui seria top
//  def addEventHandler(handler: EventHandler[_ >: KeyEvent]): Unit = {
//    stage.addEventHandler(KeyEvent.KEY_PRESSED, handler)
//  }
//
//}
