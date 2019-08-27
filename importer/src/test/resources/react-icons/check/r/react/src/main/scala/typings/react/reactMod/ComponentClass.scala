package typings.react.reactMod

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import org.scalablytyped.runtime.UndefOr
import typings.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ComponentClass[P]
  extends ComponentType[P]
     with Instantiable1[/* props */ P, Component[P, ComponentState]]
     with Instantiable2[/* props */ P, /* context */ js.Any, Component[P, ComponentState]] {
  var defaultProps: UndefOr[Partial[P]] = js.native
  var displayName: UndefOr[String] = js.native
}

