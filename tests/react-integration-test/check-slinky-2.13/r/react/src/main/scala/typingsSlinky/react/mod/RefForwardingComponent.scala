package typingsSlinky.react.mod

import typingsSlinky.std.Partial
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait RefForwardingComponent[T, P] extends StObject {
  
  def apply(props: PropsWithChildren[P], ref: Ref[T]): slinky.core.facade.ReactElement | Null = js.native
  
  var contextTypes: js.UndefOr[ValidationMap[js.Any]] = js.native
  
  var defaultProps: js.UndefOr[Partial[P]] = js.native
  
  var displayName: js.UndefOr[String] = js.native
  
  var propTypes: js.UndefOr[WeakValidationMap[P]] = js.native
}
