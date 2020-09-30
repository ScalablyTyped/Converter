package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Node
import org.scalajs.dom.raw.HTMLInputElement
import typingsJapgolly.react.reactStrings.input
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("react", "createElement")
@js.native
object createElement_input extends js.Object {
  // DOM Elements
  // TODO: generalize this to everything in `keyof ReactHTML`, not just "input"
  def apply(
    `type`: input,
    props: InputHTMLAttributes[HTMLInputElement] with ClassAttributes[HTMLInputElement],
    children: Node*
  ): DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement] = js.native
  def apply(`type`: input, props: js.UndefOr[scala.Nothing], children: Node*): DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement] = js.native
  def apply(`type`: input, props: Null, children: Node*): DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement] = js.native
}

