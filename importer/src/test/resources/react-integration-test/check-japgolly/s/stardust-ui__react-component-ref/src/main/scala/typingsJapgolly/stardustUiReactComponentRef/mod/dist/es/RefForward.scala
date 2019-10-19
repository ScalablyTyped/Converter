package typingsJapgolly.stardustUiReactComponentRef.mod.dist.es

import org.scalajs.dom.raw.HTMLElement
import typingsJapgolly.react.mod.Component
import typingsJapgolly.stardustUiReactComponentRef.Anon_Children
import typingsJapgolly.stardustUiReactComponentRef.Anon_ChildrenInnerRef
import typingsJapgolly.stardustUiReactComponentRef.mod.dist.es.types.RefProps
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
    extends typingsJapgolly.stardustUiReactComponentRef.mod.dist.es.RefForward.RefForward
  
  /* static members */
  @js.native
  object default extends js.Object {
    var displayName: String = js.native
    var propTypes: Anon_Children | Anon_ChildrenInnerRef = js.native
  }
  
}

