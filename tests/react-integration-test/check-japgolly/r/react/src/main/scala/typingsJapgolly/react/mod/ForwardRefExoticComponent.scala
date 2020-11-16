package typingsJapgolly.react.mod

import typingsJapgolly.std.Partial
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

// will show `ForwardRef(${Component.displayName || Component.name})` in devtools by default,
// but can be given its own specific name
@js.native
trait ForwardRefExoticComponent[P] extends NamedExoticComponent[P] {
  
  var defaultProps: js.UndefOr[Partial[P]] = js.native
}
