package typingsSlinky.react.mod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ComponentSpec[P, S]
  extends Mixin[P, S]
     with /* propertyName */ StringDictionary[js.Any] {
  
  def render(): slinky.core.facade.ReactElement = js.native
}
object ComponentSpec {
  
  @scala.inline
  def apply[P, S](render: () => slinky.core.facade.ReactElement): ComponentSpec[P, S] = {
    val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
    __obj.asInstanceOf[ComponentSpec[P, S]]
  }
  
  @scala.inline
  implicit class ComponentSpecOps[Self <: ComponentSpec[_, _], P, S] (val x: Self with (ComponentSpec[P, S])) extends AnyVal {
    
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    
    @scala.inline
    def set(key: String, value: js.Any): Self = {
      x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
      x
    }
    
    @scala.inline
    def setRender(value: () => slinky.core.facade.ReactElement): Self = this.set("render", js.Any.fromFunction0(value))
  }
}
