package typingsJapgolly.stardustUiReactComponentRef.mod.dist.es

import typingsJapgolly.react.mod.Component
import typingsJapgolly.stardustUiReactComponentRef.Anon_Children
import typingsJapgolly.stardustUiReactComponentRef.Anon_ChildrenInnerRef
import typingsJapgolly.stardustUiReactComponentRef.mod.dist.es.types.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@stardust-ui/react-component-ref/dist/es/RefFindNode", JSImport.Namespace)
@js.native
object RefFindNode extends js.Object {
  @js.native
  trait RefFindNode
    extends Component[RefProps, js.Object, js.Any] {
    var prevNode: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any) | Null = js.native
    @JSName("componentDidMount")
    def componentDidMount_MRefFindNode(): Unit = js.native
    @JSName("componentDidUpdate")
    def componentDidUpdate_MRefFindNode(prevProps: RefProps): Unit = js.native
    @JSName("componentWillUnmount")
    def componentWillUnmount_MRefFindNode(): Unit = js.native
  }
  
  @js.native
  class default ()
    extends typingsJapgolly.stardustUiReactComponentRef.mod.dist.es.RefFindNode.RefFindNode
  
  /* static members */
  @js.native
  object default extends js.Object {
    var displayName: String = js.native
    var propTypes: Anon_Children | Anon_ChildrenInnerRef = js.native
  }
  
}

