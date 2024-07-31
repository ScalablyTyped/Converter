package typingsJapgolly.react.mod

import _root_.typingsJapgolly.std.Partial
import japgolly.scalajs.react.facade.React.Element
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait FunctionComponent[P] extends StObject {
  
  def apply(props: PropsWithChildren[P]): Element | Null = js.native
  def apply(props: PropsWithChildren[P], context: Any): Element | Null = js.native
  
  var contextTypes: js.UndefOr[ValidationMap[Any]] = js.native
  
  var defaultProps: js.UndefOr[Partial[P]] = js.native
  
  var displayName: js.UndefOr[String] = js.native
  
  var propTypes: js.UndefOr[WeakValidationMap[P]] = js.native
}
