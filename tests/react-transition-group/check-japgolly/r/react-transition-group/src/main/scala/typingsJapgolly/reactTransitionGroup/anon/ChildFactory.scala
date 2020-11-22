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
  def apply(childFactory: /* child */ Element => Element = null): ChildFactory = {
    val __obj = js.Dynamic.literal()
    if (childFactory != null) __obj.updateDynamic("childFactory")(js.Any.fromFunction1(childFactory))
    __obj.asInstanceOf[ChildFactory]
  }
}
