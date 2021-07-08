package typingsJapgolly.stardustUiReactComponentRef

import japgolly.scalajs.react.raw.React.RefHandle
import typingsJapgolly.react.mod.FunctionComponent
import typingsJapgolly.stardustUiReactComponentRef.anon.Children
import typingsJapgolly.stardustUiReactComponentRef.anon.InnerRef
import typingsJapgolly.stardustUiReactComponentRef.refFindNodeMod.default
import typingsJapgolly.stardustUiReactComponentRef.typesMod.RefProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("@stardust-ui/react-component-ref", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  @JSImport("@stardust-ui/react-component-ref", "Ref")
  @js.native
  val Ref: FunctionComponent[RefProps] = js.native
  
  @JSImport("@stardust-ui/react-component-ref", "RefFindNode")
  @js.native
  class RefFindNode () extends default
  /* static members */
  object RefFindNode {
    
    @JSImport("@stardust-ui/react-component-ref", "RefFindNode")
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("@stardust-ui/react-component-ref", "RefFindNode.displayName")
    @js.native
    def displayName: String = js.native
    @scala.inline
    def displayName_=(x: String): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("displayName")(x.asInstanceOf[js.Any])
    
    @JSImport("@stardust-ui/react-component-ref", "RefFindNode.propTypes")
    @js.native
    def propTypes: Children | InnerRef = js.native
    @scala.inline
    def propTypes_=(x: Children | InnerRef): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("propTypes")(x.asInstanceOf[js.Any])
  }
  
  @JSImport("@stardust-ui/react-component-ref", "RefForward")
  @js.native
  class RefForward ()
    extends typingsJapgolly.stardustUiReactComponentRef.refForwardMod.default
  /* static members */
  object RefForward {
    
    @JSImport("@stardust-ui/react-component-ref", "RefForward")
    @js.native
    val ^ : js.Any = js.native
    
    @JSImport("@stardust-ui/react-component-ref", "RefForward.displayName")
    @js.native
    def displayName: String = js.native
    @scala.inline
    def displayName_=(x: String): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("displayName")(x.asInstanceOf[js.Any])
    
    @JSImport("@stardust-ui/react-component-ref", "RefForward.propTypes")
    @js.native
    def propTypes: Children | InnerRef = js.native
    @scala.inline
    def propTypes_=(x: Children | InnerRef): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("propTypes")(x.asInstanceOf[js.Any])
  }
  
  /**
    * The function that correctly handles passing refs.
    *
    * @param ref An ref object or function
    * @param node A node that should be passed by ref
    */
  @scala.inline
  def handleRef[N](ref: typingsJapgolly.react.mod.Ref[N], node: N): Unit = (^.asInstanceOf[js.Dynamic].applyDynamic("handleRef")(ref.asInstanceOf[js.Any], node.asInstanceOf[js.Any])).asInstanceOf[Unit]
  
  /** Checks that the passed object is a valid React ref object. */
  @scala.inline
  def isRefObject(ref: js.Any): /* is react.react.RefObject<any> */ Boolean = ^.asInstanceOf[js.Dynamic].applyDynamic("isRefObject")(ref.asInstanceOf[js.Any]).asInstanceOf[/* is react.react.RefObject<any> */ Boolean]
  
  @JSImport("@stardust-ui/react-component-ref", "refPropType")
  @js.native
  val refPropType: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Requireable<React.Ref<any>> */ js.Any = js.native
  
  /** Creates a React ref object from existing DOM node. */
  @scala.inline
  def toRefObject[T /* <: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any */](node: T): RefHandle[T] = ^.asInstanceOf[js.Dynamic].applyDynamic("toRefObject")(node.asInstanceOf[js.Any]).asInstanceOf[RefHandle[T]]
}
