package typingsJapgolly.react.mod

import org.scalajs.dom.raw.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DetailedReactHTMLElement[P /* <: HTMLAttributes[T] */, T /* <: HTMLElement */] extends DOMElement[P, T]

object DetailedReactHTMLElement {
  @scala.inline
  def apply[/* <: typingsJapgolly.react.mod.HTMLAttributes[T] */ P, /* <: typingsJapgolly.std.HTMLElement */ T](props: js.Any, `type`: js.Any): DetailedReactHTMLElement[P, T] = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[DetailedReactHTMLElement[P, T]]
  }
}

