package typingsSlinky.stardustUiReactComponentRef.mod.dist.es

import org.scalajs.dom.raw.HTMLElement
import typingsSlinky.react.mod.Component
import typingsSlinky.stardustUiReactComponentRef.Anon_Children
import typingsSlinky.stardustUiReactComponentRef.Anon_ChildrenInnerRef
import typingsSlinky.stardustUiReactComponentRef.mod.dist.es.types.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@stardust-ui/react-component-ref/dist/es/RefForward", JSImport.Namespace)
@js.native
object RefForward extends js.Object {
  @js.native
  trait RefForward
    extends Component[RefProps, js.Object, js.Any] {
    def handleRefOverride(node: HTMLElement): Unit = js.native
  }
  
  @js.native
  class default ()
    extends typingsSlinky.stardustUiReactComponentRef.mod.dist.es.RefForward.RefForward
  
  /* static members */
  @js.native
  object default extends js.Object {
    var displayName: String = js.native
    var propTypes: Anon_Children | Anon_ChildrenInnerRef = js.native
  }
  
}

