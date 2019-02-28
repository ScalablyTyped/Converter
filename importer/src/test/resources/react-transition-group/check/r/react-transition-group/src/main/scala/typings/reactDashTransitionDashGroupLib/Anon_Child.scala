package typings
package reactDashTransitionDashGroupLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Anon_Child extends js.Object {
  var childFactory: js.UndefOr[
    js.Function1[
      /* child */ reactLib.reactMod.ReactNs.ReactElement[_], 
      reactLib.reactMod.ReactNs.ReactElement[_]
    ]
  ] = js.undefined
}

object Anon_Child {
  @scala.inline
  def apply(
    childFactory: js.Function1[
      /* child */ reactLib.reactMod.ReactNs.ReactElement[_], 
      reactLib.reactMod.ReactNs.ReactElement[_]
    ] = null
  ): Anon_Child = {
    val __obj = js.Dynamic.literal()
    if (childFactory != null) __obj.updateDynamic("childFactory")(childFactory)
    __obj.asInstanceOf[Anon_Child]
  }
}

