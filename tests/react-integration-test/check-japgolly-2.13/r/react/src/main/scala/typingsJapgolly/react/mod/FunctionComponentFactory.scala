package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Node
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait FunctionComponentFactory[P] extends StObject {
  
  def apply(props: Attributes with P, children: Node*): FunctionComponentElement[P] = js.native
  def apply(props: Unit, children: Node*): FunctionComponentElement[P] = js.native
}
