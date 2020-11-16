package typingsSlinky.react.mod

import org.scalajs.dom.raw.HTMLInputElement
import typingsSlinky.react.reactStrings.input
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
    children: slinky.core.facade.ReactElement*
  ): DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement] = js.native
  def apply(`type`: input, props: js.UndefOr[scala.Nothing], children: slinky.core.facade.ReactElement*): DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement] = js.native
  def apply(`type`: input, props: Null, children: slinky.core.facade.ReactElement*): DetailedReactHTMLElement[InputHTMLAttributes[HTMLInputElement], HTMLInputElement] = js.native
}
