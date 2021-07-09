package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Node
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ComponentFactory[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */] extends StObject {
  
  def apply(props: ClassAttributes[T] with P, children: Node*): CElement[P, T] = js.native
  def apply(props: Unit, children: Node*): CElement[P, T] = js.native
}
