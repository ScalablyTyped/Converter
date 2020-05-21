package typings.phaser.global

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("PIXI")
@js.native
object PIXI extends js.Object {
  var CANVAS_RENDERER: Double = js.native
  var VERSION: String = js.native
  var WEBGL_RENDERER: Double = js.native
  @js.native
  object blendModes extends js.Object {
    /* 1 */ val ADD: typings.phaser.PIXI.blendModes.ADD with Double = js.native
    /* 0 */ val NORMAL: typings.phaser.PIXI.blendModes.NORMAL with Double = js.native
    @JSBracketAccess
    def apply(value: Double): js.UndefOr[typings.phaser.PIXI.blendModes with Double] = js.native
  }
  
  @js.native
  object scaleModes extends js.Object {
    /* 0 */ val DEFAULT: typings.phaser.PIXI.scaleModes.DEFAULT with Double = js.native
    /* 1 */ val LINEAR: typings.phaser.PIXI.scaleModes.LINEAR with Double = js.native
    /* 2 */ val NEAREST: typings.phaser.PIXI.scaleModes.NEAREST with Double = js.native
    @JSBracketAccess
    def apply(value: Double): js.UndefOr[typings.phaser.PIXI.scaleModes with Double] = js.native
  }
  
}

