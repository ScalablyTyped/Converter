package typingsSlinky.stardustUiReactComponentRef

import slinky.core.ReactComponentClass
import slinky.core.facade.ReactRef
import typingsSlinky.stardustUiReactComponentRef.refFindNodeMod.default
import typingsSlinky.stardustUiReactComponentRef.typesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("@stardust-ui/react-component-ref", JSImport.Namespace)
@js.native
object mod extends js.Object {
  @js.native
  class RefFindNode () extends default
  
  @js.native
  class RefForward ()
    extends typingsSlinky.stardustUiReactComponentRef.refForwardMod.default
  
  val Ref: ReactComponentClass[RefProps] = js.native
  val refPropType: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Requireable<React.Ref<any>> */ js.Any = js.native
  /**
    * The function that correctly handles passing refs.
    *
    * @param ref An ref object or function
    * @param node A node that should be passed by ref
    */
  def handleRef[N](ref: typingsSlinky.react.mod.Ref[N], node: N): Unit = js.native
  /** Checks that the passed object is a valid React ref object. */
  def isRefObject(ref: js.Any): /* is react.react.RefObject<any> */ Boolean = js.native
  /** Creates a React ref object from existing DOM node. */
  def toRefObject[T /* <: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any */](node: T): ReactRef[T] = js.native
  /* static members */
  @js.native
  object RefFindNode extends js.Object {
    var displayName: String = js.native
    var propTypes: AnonChildren | AnonInnerRef = js.native
  }
  
  /* static members */
  @js.native
  object RefForward extends js.Object {
    var displayName: String = js.native
    var propTypes: AnonChildren | AnonInnerRef = js.native
  }
  
}

