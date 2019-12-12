package typings.phaser

import org.scalablytyped.runtime.TopLevel
import typings.phaser.PIXI.blendModes
import typings.phaser.PIXI.blendModes.ADD
import typings.phaser.PIXI.blendModes.NORMAL
import typings.phaser.PIXI.scaleModes
import typings.phaser.PIXI.scaleModes.DEFAULT
import typings.phaser.PIXI.scaleModes.LINEAR
import typings.phaser.PIXI.scaleModes.NEAREST
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
    
    @JSBracketAccess
    def apply(value: Double): js.UndefOr[blendModes with Double] = js.native
    /* 1 */ @js.native
    object ADD extends TopLevel[ADD with Double]
    
    /* 0 */ @js.native
    object NORMAL extends TopLevel[NORMAL with Double]
    
  }
  
  @js.native
  object scaleModes extends js.Object {
    @js.native
    sealed trait DEFAULT extends scaleModes
    
    @js.native
    sealed trait LINEAR extends scaleModes
    
    @js.native
    sealed trait NEAREST extends scaleModes
    
    @JSBracketAccess
    def apply(value: Double): js.UndefOr[scaleModes with Double] = js.native
    /* 0 */ @js.native
    object DEFAULT extends TopLevel[DEFAULT with Double]
    
    /* 1 */ @js.native
    object LINEAR extends TopLevel[LINEAR with Double]
    
    /* 2 */ @js.native
    object NEAREST extends TopLevel[NEAREST with Double]
    
  }
  
}

