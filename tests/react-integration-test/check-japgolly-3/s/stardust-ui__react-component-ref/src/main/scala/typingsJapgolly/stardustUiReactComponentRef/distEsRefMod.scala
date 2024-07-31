package typingsJapgolly.stardustUiReactComponentRef

import _root_.typingsJapgolly.react.mod.FunctionComponent
import _root_.typingsJapgolly.stardustUiReactComponentRef.distEsTypesMod.RefProps
import org.scalablytyped.runtime.Shortcut
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distEsRefMod extends Shortcut {
  
  @JSImport("@stardust-ui/react-component-ref/dist/es/Ref", JSImport.Default)
  @js.native
  val default: FunctionComponent[RefProps] = js.native
  
  type _To = FunctionComponent[RefProps]
  
  /* This means you don't have to write `default`, but can instead just say `distEsRefMod.foo` */
  override def _to: FunctionComponent[RefProps] = default
}
