package typingsJapgolly.react.mod

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.facade.React.Node
import org.scalablytyped.runtime.StringDictionary
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait ComponentSpec[P, S]
  extends StObject
     with Mixin[P, S]
     with /* propertyName */ StringDictionary[js.Any] {
  
  def render(): Node
}
object ComponentSpec {
  
  inline def apply[P, S](render: CallbackTo[Node]): ComponentSpec[P, S] = {
    val __obj = js.Dynamic.literal(render = render.toJsFn)
    __obj.asInstanceOf[ComponentSpec[P, S]]
  }
  
  extension [Self <: ComponentSpec[?, ?], P, S](x: Self & (ComponentSpec[P, S])) {
    
    inline def setRender(value: CallbackTo[Node]): Self = StObject.set(x, "render", value.toJsFn)
  }
}
