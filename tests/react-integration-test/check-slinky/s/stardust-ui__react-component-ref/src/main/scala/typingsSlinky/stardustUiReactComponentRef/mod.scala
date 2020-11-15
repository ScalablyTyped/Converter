package typingsSlinky.stardustUiReactComponentRef

import slinky.core.ReactComponentClass
import slinky.core.facade.ReactRef
import typingsSlinky.stardustUiReactComponentRef.anon.Children
import typingsSlinky.stardustUiReactComponentRef.anon.InnerRef
import typingsSlinky.stardustUiReactComponentRef.refFindNodeMod.default
import typingsSlinky.stardustUiReactComponentRef.typesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("@stardust-ui/react-component-ref", JSImport.Namespace)
@js.native
object mod extends js.Object {
  
  val Ref: ReactComponentClass[RefProps] = js.native
  
  /**
    * The function that correctly handles passing refs.
    *
    * @param ref An ref object or function
    * @param node A node that should be passed by ref
    */
  def handleRef[N](ref: typingsSlinky.react.mod.Ref[N], node: N): Unit = js.native
  
  /** Checks that the passed object is a valid React ref object. */
  def isRefObject(ref: js.Any): /* is react.react.RefObject<any> */ Boolean = js.native
  
  val refPropType: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Requireable<React.Ref<any>> */ js.Any = js.native
  
  /** Creates a React ref object from existing DOM node. */
  def toRefObject[T /* <: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any */](node: T): ReactRef[T] = js.native
  
  @js.native
  class RefFindNode () extends default
  /* static members */
  @js.native
  object RefFindNode extends js.Object {
    
    var displayName: String = js.native
    
    var propTypes: Children | InnerRef = js.native
  }
  
  @js.native
  class RefForward ()
    extends typingsSlinky.stardustUiReactComponentRef.refForwardMod.default
  /* static members */
  @js.native
  object RefForward extends js.Object {
    
    var displayName: String = js.native
    
    var propTypes: Children | InnerRef = js.native
  }
}
