package typings.phaser

import typings.phaser.anon.LowerBound
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object PIXI {
    
    @JSGlobal("PIXI")
    @js.native
    val ^ : js.Any = js.native
    
    @JSGlobal("PIXI.CANVAS_RENDERER")
    @js.native
    def CANVAS_RENDERER: Double = js.native
    @scala.inline
    def CANVAS_RENDERER_=(x: Double): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("CANVAS_RENDERER")(x.asInstanceOf[js.Any])
    
    @JSGlobal("PIXI.VERSION")
    @js.native
    def VERSION: String = js.native
    @scala.inline
    def VERSION_=(x: String): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("VERSION")(x.asInstanceOf[js.Any])
    
    @JSGlobal("PIXI.WEBGL_RENDERER")
    @js.native
    def WEBGL_RENDERER: Double = js.native
    @scala.inline
    def WEBGL_RENDERER_=(x: Double): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("WEBGL_RENDERER")(x.asInstanceOf[js.Any])
    
    @JSGlobal("PIXI.blendModes")
    @js.native
    object blendModes extends StObject {
      
      @JSBracketAccess
      def apply(value: Double): js.UndefOr[typings.phaser.PIXI.blendModes & Double] = js.native
      
      /* 1 */ val ADD: typings.phaser.PIXI.blendModes.ADD & Double = js.native
      
      /* 0 */ val NORMAL: typings.phaser.PIXI.blendModes.NORMAL & Double = js.native
    }
    
    @JSGlobal("PIXI.scaleModes")
    @js.native
    object scaleModes extends StObject {
      
      @JSBracketAccess
      def apply(value: Double): js.UndefOr[typings.phaser.PIXI.scaleModes & Double] = js.native
      
      /* 0 */ val DEFAULT: typings.phaser.PIXI.scaleModes.DEFAULT & Double = js.native
      
      /* 1 */ val LINEAR: typings.phaser.PIXI.scaleModes.LINEAR & Double = js.native
      
      /* 2 */ val NEAREST: typings.phaser.PIXI.scaleModes.NEAREST & Double = js.native
    }
  }
  
  @JSGlobal("Phaser")
  @js.native
  class Phaser ()
    extends StObject
       with typings.phaser.Phaser
  object Phaser {
    
    @JSGlobal("Phaser")
    @js.native
    val ^ : js.Any = js.native
    
    /**
      * An Animation instance contains a single animation and the controls to play it.
      *
      * It is created by the AnimationManager, consists of Animation.Frame objects and belongs to a single Game Object such as a Sprite.
      */
    @JSGlobal("Phaser.Animation")
    @js.native
    class Animation ()
      extends StObject
         with typings.phaser.Phaser.Animation
    
    /* static member */
    @JSGlobal("Phaser.VERSION")
    @js.native
    def VERSION: String = js.native
    @scala.inline
    def VERSION_=(x: String): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("VERSION")(x.asInstanceOf[js.Any])
  }
  
  object p2 {
    
    @JSGlobal("p2.AABB")
    @js.native
    class AABB ()
      extends StObject
         with typings.phaser.p2.AABB {
      def this(options: LowerBound) = this()
    }
  }
}
