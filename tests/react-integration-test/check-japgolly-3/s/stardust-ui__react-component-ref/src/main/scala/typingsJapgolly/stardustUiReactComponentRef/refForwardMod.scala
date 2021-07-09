package typingsJapgolly.stardustUiReactComponentRef

import org.scalajs.dom.raw.HTMLElement
import typingsJapgolly.react.mod.Component
import typingsJapgolly.stardustUiReactComponentRef.anon.Children
import typingsJapgolly.stardustUiReactComponentRef.anon.InnerRef
import typingsJapgolly.stardustUiReactComponentRef.typesMod.RefProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object refForwardMod {
  
  @JSImport("@stardust-ui/react-component-ref/dist/es/RefForward", JSImport.Default)
  @js.native
  class default () extends RefForward
  /* static members */
  object default {
    
    @JSImport("@stardust-ui/react-component-ref/dist/es/RefForward", JSImport.Default)
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("@stardust-ui/react-component-ref/dist/es/RefForward", "default.displayName")
    @js.native
    def displayName: String = js.native
    @scala.inline
    def displayName_=(x: String): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("displayName")(x.asInstanceOf[js.Any])
    
    @JSImport("@stardust-ui/react-component-ref/dist/es/RefForward", "default.propTypes")
    @js.native
    def propTypes: Children | InnerRef = js.native
    @scala.inline
    def propTypes_=(x: Children | InnerRef): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("propTypes")(x.asInstanceOf[js.Any])
  }
  
  @js.native
  trait RefForward
    extends Component[RefProps, js.Object, js.Any] {
    
    def handleRefOverride(node: HTMLElement): Unit = js.native
  }
}
