package typings.phaser.global

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("Phaser")
@js.native
class Phaser ()
  extends typings.phaser.Phaser

/* static members */
@JSGlobal("Phaser")
@js.native
object Phaser extends js.Object {
  /**
    * An Animation instance contains a single animation and the controls to play it.
    *
    * It is created by the AnimationManager, consists of Animation.Frame objects and belongs to a single Game Object such as a Sprite.
    */
  @js.native
  class Animation ()
    extends typings.phaser.Phaser.Animation
  
  var VERSION: String = js.native
}

