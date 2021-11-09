package typingsSlinky.stardustUiReactComponentRef

import org.scalajs.dom.HTMLElement
import typingsSlinky.react.mod.Component
import typingsSlinky.stardustUiReactComponentRef.anon.Children
import typingsSlinky.stardustUiReactComponentRef.anon.InnerRef
import typingsSlinky.stardustUiReactComponentRef.typesMod.RefProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object refForwardMod {
  
  @JSImport("@stardust-ui/react-component-ref/dist/es/RefForward", JSImport.Default)
  @js.native
  open class default () extends RefForward
  /* static members */
  object default {
    
    @JSImport("@stardust-ui/react-component-ref/dist/es/RefForward", JSImport.Default)
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("@stardust-ui/react-component-ref/dist/es/RefForward", "default.displayName")
    @js.native
    def displayName: String = js.native
    inline def displayName_=(x: String): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("displayName")(x.asInstanceOf[js.Any])
    
    @JSImport("@stardust-ui/react-component-ref/dist/es/RefForward", "default.propTypes")
    @js.native
    def propTypes: Children | InnerRef = js.native
    inline def propTypes_=(x: Children | InnerRef): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("propTypes")(x.asInstanceOf[js.Any])
  }
  
  @js.native
  trait RefForward
    extends Component[RefProps, js.Object, js.Any] {
    
    def handleRefOverride(node: HTMLElement): Unit = js.native
  }
}
