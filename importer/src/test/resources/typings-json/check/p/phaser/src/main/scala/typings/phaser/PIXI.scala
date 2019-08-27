package typings.phaser

import org.scalablytyped.runtime.UndefOr
import typings.phaser.PIXI.blendModes
import typings.phaser.PIXI.scaleModes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("PIXI")
@js.native
object PIXI extends js.Object {
  @js.native
  sealed trait blendModes extends js.Object
  
  @js.native
  sealed trait scaleModes extends js.Object
  
  var CANVAS_RENDERER: Double = js.native
  var VERSION: String = js.native
  var WEBGL_RENDERER: Double = js.native
  @js.native
  object blendModes extends js.Object {
    @js.native
    sealed trait ADD extends blendModes
    
    @js.native
    sealed trait NORMAL extends blendModes
    
    /* 1 */ val ADD: typings.phaser.PIXI.blendModes.ADD with Double = js.native
    /* 0 */ val NORMAL: typings.phaser.PIXI.blendModes.NORMAL with Double = js.native
    @JSBracketAccess
    def apply(value: Double): UndefOr[blendModes with Double] = js.native
  }
  
  @js.native
  object scaleModes extends js.Object {
    @js.native
    sealed trait DEFAULT extends scaleModes
    
    @js.native
    sealed trait LINEAR extends scaleModes
    
    @js.native
    sealed trait NEAREST extends scaleModes
    
    /* 0 */ val DEFAULT: typings.phaser.PIXI.scaleModes.DEFAULT with Double = js.native
    /* 1 */ val LINEAR: typings.phaser.PIXI.scaleModes.LINEAR with Double = js.native
    /* 2 */ val NEAREST: typings.phaser.PIXI.scaleModes.NEAREST with Double = js.native
    @JSBracketAccess
    def apply(value: Double): UndefOr[scaleModes with Double] = js.native
  }
  
}

