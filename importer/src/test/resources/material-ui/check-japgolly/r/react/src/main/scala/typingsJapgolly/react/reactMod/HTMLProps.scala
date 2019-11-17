package typingsJapgolly.react.reactMod

import japgolly.scalajs.react.vdom.VdomNode
import typingsJapgolly.react.Anon_Html
import typingsJapgolly.react.reactStrings.foo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait HTMLProps[T] extends AllHTMLAttributes[T] {
  var defaultValue: foo
  var onChange: foo
  var `type`: foo
  var value: foo
}

object HTMLProps {
  @scala.inline
  def apply[T](
    defaultValue: foo,
    onChange: foo,
    `type`: foo,
    value: foo,
    accept: String = null,
    acceptCharset: String = null,
    children: VdomNode = null,
    dangerouslySetInnerHTML: Anon_Html = null,
    defaultChecked: js.UndefOr[Boolean] = js.undefined
  ): HTMLProps[T] = {
    val __obj = js.Dynamic.literal(defaultValue = defaultValue.asInstanceOf[js.Any], onChange = onChange.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
    if (acceptCharset != null) __obj.updateDynamic("acceptCharset")(acceptCharset.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
    __obj.asInstanceOf[HTMLProps[T]]
  }
}

