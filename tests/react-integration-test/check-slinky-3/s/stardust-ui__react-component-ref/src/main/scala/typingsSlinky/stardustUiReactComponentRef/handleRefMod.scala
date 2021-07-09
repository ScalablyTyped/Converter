package typingsSlinky.stardustUiReactComponentRef

import typingsSlinky.react.mod.Ref
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object handleRefMod {
  
  @JSImport("@stardust-ui/react-component-ref/dist/es/handleRef", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  /**
    * The function that correctly handles passing refs.
    *
    * @param ref An ref object or function
    * @param node A node that should be passed by ref
    */
  @scala.inline
  def default[N](ref: Ref[N], node: N): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("default")(ref.asInstanceOf[js.Any], node.asInstanceOf[js.Any])).asInstanceOf[Unit]
}
