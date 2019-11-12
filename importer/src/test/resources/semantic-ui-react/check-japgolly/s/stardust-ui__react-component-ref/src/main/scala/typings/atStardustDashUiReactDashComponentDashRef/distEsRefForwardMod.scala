package typings.atStardustDashUiReactDashComponentDashRef

import org.scalajs.dom.raw.HTMLElement
import typings.atStardustDashUiReactDashComponentDashRef.distEsRefForwardMod.RefForward
import typings.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps
import typings.react.reactMod.Component
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@stardust-ui/react-component-ref/dist/es/RefForward", JSImport.Namespace)
@js.native
object distEsRefForwardMod extends js.Object {
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

