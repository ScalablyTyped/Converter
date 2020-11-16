package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Node
import org.scalajs.dom.raw.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait DetailedHTMLFactory[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */] extends DOMFactory[P, T] {
  
  def apply(props: ClassAttributes[T] with P, children: Node*): DetailedReactHTMLElement[P, T] = js.native
  def apply(props: js.UndefOr[scala.Nothing], children: Node*): DetailedReactHTMLElement[P, T] = js.native
  def apply(props: Null, children: Node*): DetailedReactHTMLElement[P, T] = js.native
}
