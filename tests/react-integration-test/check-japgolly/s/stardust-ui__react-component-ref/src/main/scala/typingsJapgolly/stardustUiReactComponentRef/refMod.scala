package typingsJapgolly.stardustUiReactComponentRef

import org.scalablytyped.runtime.Shortcut
import typingsJapgolly.react.mod.FunctionComponent
import typingsJapgolly.stardustUiReactComponentRef.typesMod.RefProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object refMod extends Shortcut {
  
  @JSImport("@stardust-ui/react-component-ref/dist/es/Ref", JSImport.Default)
  @js.native
  val default: FunctionComponent[RefProps] = js.native
  
  type _To = FunctionComponent[RefProps]
  
  /* This means you don't have to write `default`, but can instead just say `refMod.foo` */
  override def _to: FunctionComponent[RefProps] = default
}
