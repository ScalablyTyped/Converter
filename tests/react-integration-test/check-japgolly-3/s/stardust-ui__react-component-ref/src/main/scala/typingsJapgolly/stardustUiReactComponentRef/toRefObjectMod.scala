package typingsJapgolly.stardustUiReactComponentRef

import japgolly.scalajs.react.facade.React.RefHandle
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object toRefObjectMod {
  
  @JSImport("@stardust-ui/react-component-ref/dist/es/toRefObject", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  /** Creates a React ref object from existing DOM node. */
  inline def default[T /* <: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any */](node: T): RefHandle[T] = ^.asInstanceOf[js.Dynamic].applyDynamic("default")(node.asInstanceOf[js.Any]).asInstanceOf[RefHandle[T]]
}
