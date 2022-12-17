package typingsSlinky.react.mod

import org.scalablytyped.runtime.StringDictionary
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait ComponentSpec[P, S]
  extends StObject
     with Mixin[P, S]
     with /* propertyName */ StringDictionary[Any] {
  
  def render(): slinky.core.facade.ReactElement
}
object ComponentSpec {
  
  inline def apply[P, S](render: () => slinky.core.facade.ReactElement): ComponentSpec[P, S] = {
    val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
    __obj.asInstanceOf[ComponentSpec[P, S]]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: ComponentSpec[?, ?], P, S] (val x: Self & (ComponentSpec[P, S])) extends AnyVal {
    
    inline def setRender(value: () => slinky.core.facade.ReactElement): Self = StObject.set(x, "render", js.Any.fromFunction0(value))
  }
}
