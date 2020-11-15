package typingsSlinky.react.mod

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import slinky.core.ReactComponentClass
import typingsSlinky.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ComponentClass[P]
  extends Instantiable1[/* props */ P, ReactComponentClass[P]]
     with Instantiable2[/* props */ P, /* context */ js.Any, ReactComponentClass[P]] {
  
  var defaultProps: js.UndefOr[Partial[P]] = js.native
  
  var displayName: js.UndefOr[String] = js.native
}
