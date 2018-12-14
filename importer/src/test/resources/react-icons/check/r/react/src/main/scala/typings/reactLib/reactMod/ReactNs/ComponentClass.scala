package typings
package reactLib.reactMod.ReactNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ComponentClass[P]
  extends org.scalablytyped.runtime.Instantiable1[/* props */ P, Component[P, ComponentState]]
     with org.scalablytyped.runtime.Instantiable2[/* props */ P, /* context */ js.Any, Component[P, ComponentState]] {
  var defaultProps: js.UndefOr[stdLib.Partial[P]] = js.native
  var displayName: js.UndefOr[java.lang.String] = js.native
}

