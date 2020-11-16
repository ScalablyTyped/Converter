package typingsSlinky.stardustUiReactComponentRef

import typingsSlinky.react.mod.Component
import typingsSlinky.stardustUiReactComponentRef.anon.Children
import typingsSlinky.stardustUiReactComponentRef.anon.InnerRef
import typingsSlinky.stardustUiReactComponentRef.typesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("@stardust-ui/react-component-ref/dist/es/RefFindNode", JSImport.Namespace)
@js.native
object refFindNodeMod extends js.Object {
  
  @js.native
  trait RefFindNode
    extends Component[RefProps, js.Object, js.Any] {
    
    @JSName("componentDidMount")
    def componentDidMount_MRefFindNode(): Unit = js.native
    
    @JSName("componentDidUpdate")
    def componentDidUpdate_MRefFindNode(prevProps: RefProps): Unit = js.native
    
    @JSName("componentWillUnmount")
    def componentWillUnmount_MRefFindNode(): Unit = js.native
    
    var prevNode: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any) | Null = js.native
  }
  
  @js.native
  class default () extends RefFindNode
  /* static members */
  @js.native
  object default extends js.Object {
    
    var displayName: String = js.native
    
    var propTypes: Children | InnerRef = js.native
  }
}
