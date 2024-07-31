package typings.phaser

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

// Type definitions for Phaser 2.6.2 - 26th August 2016
// Project: https://github.com/photonstorm/phaser
object mod {
  
  @JSImport("phaser", JSImport.Namespace)
  @js.native
  open class ^ ()
    extends StObject
       with Phaser
  @JSImport("phaser", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  /**
    * An Animation instance contains a single animation and the controls to play it.
    *
    * It is created by the AnimationManager, consists of Animation.Frame objects and belongs to a single Game Object such as a Sprite.
    */
  @JSImport("phaser", "Animation")
  @js.native
  open class Animation ()
    extends StObject
       with _root_.typings.phaser.Phaser.Animation
  
  /* static member */
  @JSImport("phaser", "VERSION")
  @js.native
  def VERSION: String = js.native
  inline def VERSION_=(x: String): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("VERSION")(x.asInstanceOf[js.Any])
}
