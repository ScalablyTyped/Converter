package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ComponentElement[P, T /* <: japgolly.scalajs.react.raw.React.Component[P & js.Object, js.Object] */]
  extends StObject
     with ReactElement {
  
  var ref: js.UndefOr[LegacyRef[T]] = js.native
}
object ComponentElement {
  
  @scala.inline
  def apply[P, T /* <: japgolly.scalajs.react.raw.React.Component[P & js.Object, js.Object] */](props: js.Any, `type`: js.Any): ComponentElement[P, T] = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], key = null)
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[ComponentElement[P, T]]
  }
  
  @scala.inline
  implicit class ComponentElementMutableBuilder[Self <: ComponentElement[?, ?], P, T /* <: japgolly.scalajs.react.raw.React.Component[P & js.Object, js.Object] */] (val x: Self & (ComponentElement[P, T])) extends AnyVal {
    
    @scala.inline
    def setRef(value: LegacyRef[T]): Self = StObject.set(x, "ref", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setRefFunction1(value: /* instance */ T | Null => Callback): Self = StObject.set(x, "ref", js.Any.fromFunction1((t0: /* instance */ T | Null) => value(t0).runNow()))
    
    @scala.inline
    def setRefNull: Self = StObject.set(x, "ref", null)
    
    @scala.inline
    def setRefUndefined: Self = StObject.set(x, "ref", js.undefined)
  }
}
