package typingsSlinky.stardustUiReactComponentRef

import _root_.typingsSlinky.stardustUiReactComponentRef.distEsTypesMod.RefProps
import org.scalablytyped.runtime.Shortcut
import slinky.core.ReactComponentClass
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distEsRefMod extends Shortcut {
  
  @JSImport("@stardust-ui/react-component-ref/dist/es/Ref", JSImport.Default)
  @js.native
  val default: ReactComponentClass[RefProps] = js.native
  
  type _To = ReactComponentClass[RefProps]
  
  /* This means you don't have to write `default`, but can instead just say `distEsRefMod.foo` */
  override def _to: ReactComponentClass[RefProps] = default
}
