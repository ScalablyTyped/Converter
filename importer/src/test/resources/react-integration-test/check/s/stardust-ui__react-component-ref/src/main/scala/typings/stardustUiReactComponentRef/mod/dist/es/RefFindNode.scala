package typings.stardustUiReactComponentRef.mod.dist.es

import typings.react.mod.Component
import typings.stardustUiReactComponentRef.Anon_Children
import typings.stardustUiReactComponentRef.Anon_ChildrenInnerRef
import typings.stardustUiReactComponentRef.mod.dist.es.types.RefProps
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
    extends typings.stardustUiReactComponentRef.mod.dist.es.RefFindNode.RefFindNode
  
  /* static members */
  @js.native
  object default extends js.Object {
    var displayName: String = js.native
    var propTypes: Anon_Children | Anon_ChildrenInnerRef = js.native
  }
  
}

