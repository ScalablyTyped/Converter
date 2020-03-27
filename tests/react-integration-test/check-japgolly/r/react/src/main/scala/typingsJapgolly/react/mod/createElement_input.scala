package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Node
import org.scalajs.dom.raw.HTMLInputElement
import typingsJapgolly.react.reactStrings.input
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react", "createElement")
@js.native
object createElement_input extends js.Object {
  // DOM Elements
  // TODO: generalize this to everything in `keyof ReactHTML`, not just "input"
  def apply(`type`: input): DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement] = js.native
  def apply(`type`: input, children: ReactNode*): DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement] = js.native
  def apply(
    `type`: input,
    props: InputHTMLAttributes[typingsJapgolly.std.HTMLInputElement] with ClassAttributes[typingsJapgolly.std.HTMLInputElement],
    children: Node*
  ): DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement] = js.native
}

