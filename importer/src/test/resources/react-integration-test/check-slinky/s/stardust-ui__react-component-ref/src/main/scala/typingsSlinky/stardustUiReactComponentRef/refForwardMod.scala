package typingsSlinky.stardustUiReactComponentRef

import org.scalajs.dom.raw.HTMLElement
import typingsSlinky.react.mod.Component
import typingsSlinky.stardustUiReactComponentRef.typesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@stardust-ui/react-component-ref/dist/es/RefForward", JSImport.Namespace)
@js.native
object refForwardMod extends js.Object {
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
    var propTypes: AnonChildren | AnonInnerRef = js.native
  }
  
}

