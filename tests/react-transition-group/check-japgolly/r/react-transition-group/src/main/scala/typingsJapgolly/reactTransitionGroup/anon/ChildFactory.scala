package typingsJapgolly.reactTransitionGroup.anon

import japgolly.scalajs.react.raw.React.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ChildFactory extends js.Object {
  
  var childFactory: js.UndefOr[js.Function1[/* child */ Element, Element]] = js.native
}
object ChildFactory {
  
  @scala.inline
  def apply(): ChildFactory = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ChildFactory]
  }
  
  @scala.inline
  implicit class ChildFactoryOps[Self <: ChildFactory] (val x: Self) extends AnyVal {
    
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
    def setChildFactory(value: /* child */ Element => Element): Self = this.set("childFactory", js.Any.fromFunction1(value))
    
    @scala.inline
    def deleteChildFactory: Self = this.set("childFactory", js.undefined)
  }
}
