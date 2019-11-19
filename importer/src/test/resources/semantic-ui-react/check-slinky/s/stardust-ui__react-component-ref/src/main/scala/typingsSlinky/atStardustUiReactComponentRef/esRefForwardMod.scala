package typingsSlinky.atStardustUiReactComponentRef

import org.scalajs.dom.raw.HTMLElement
import typingsSlinky.atStardustUiReactComponentRef.esRefForwardMod.RefForward
import typingsSlinky.atStardustUiReactComponentRef.esTypesMod.RefProps
import typingsSlinky.react.reactMod.Component
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@stardust-ui/react-component-ref/dist/es/RefForward", JSImport.Namespace)
@js.native
object esRefForwardMod extends js.Object {
  @js.native
  trait RefForward
    extends Component[RefProps, js.Object, js.Any] {
    def handleRefOverride(node: HTMLElement): Unit = js.native
  }
  
  @js.native
  class default () extends RefForward
  
  /* static members */
  @js.native
  object default extends js.Object {
    var displayName: String = js.native
    var propTypes: Anon_Children | Anon_ChildrenInnerRef = js.native
  }
  
}

