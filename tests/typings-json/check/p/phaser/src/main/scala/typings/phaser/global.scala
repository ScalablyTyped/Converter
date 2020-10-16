package typings.phaser

import typings.phaser.anon.LowerBound
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSGlobalScope
@js.native
object global extends js.Object {
  @js.native
  object PIXI extends js.Object {
    var CANVAS_RENDERER: Double = js.native
    var VERSION: String = js.native
    var WEBGL_RENDERER: Double = js.native
    @js.native
    object blendModes extends js.Object {
      @JSBracketAccess
      def apply(value: Double): js.UndefOr[typings.phaser.PIXI.blendModes with Double] = js.native
      /* 1 */ val ADD: typings.phaser.PIXI.blendModes.ADD with Double = js.native
      /* 0 */ val NORMAL: typings.phaser.PIXI.blendModes.NORMAL with Double = js.native
    }
    
    @js.native
    object scaleModes extends js.Object {
      @JSBracketAccess
      def apply(value: Double): js.UndefOr[typings.phaser.PIXI.scaleModes with Double] = js.native
      /* 0 */ val DEFAULT: typings.phaser.PIXI.scaleModes.DEFAULT with Double = js.native
      /* 1 */ val LINEAR: typings.phaser.PIXI.scaleModes.LINEAR with Double = js.native
      /* 2 */ val NEAREST: typings.phaser.PIXI.scaleModes.NEAREST with Double = js.native
    }
    
  }
  
  /* static members */
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
  
  @js.native
  class Phaser ()
    extends typings.phaser.Phaser
  
  @js.native
  object p2 extends js.Object {
    @js.native
    class AABB ()
      extends typings.phaser.p2.AABB {
      def this(options: LowerBound) = this()
    }
    
  }
  
}

