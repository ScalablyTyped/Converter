package typingsJapgolly.react.mod

import japgolly.scalajs.react.facade.React.DomElement
import japgolly.scalajs.react.facade.React.Node
import org.scalajs.dom.Element
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait DOMFactory[P /* <: DOMAttributes[T] */, T /* <: Element */] extends StObject {
  
  def apply(props: ClassAttributes[T] & P, children: Node*): DomElement = js.native
  def apply(props: Null, children: Node*): DomElement = js.native
  def apply(props: Unit, children: Node*): DomElement = js.native
}
