package typings.stardustUiReactComponentRef.mod.dist.es

import typings.react.mod.Component
import typings.stardustUiReactComponentRef.Anon_Children
import typings.stardustUiReactComponentRef.Anon_ChildrenInnerRef
import typings.stardustUiReactComponentRef.mod.dist.es.types.RefProps
import typings.std.HTMLElement
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
    extends typings.stardustUiReactComponentRef.mod.dist.es.RefForward.RefForward
  
  /* static members */
  @js.native
  object default extends js.Object {
    var displayName: String = js.native
    var propTypes: Anon_Children | Anon_ChildrenInnerRef = js.native
  }
  
}

