package typingsSlinky.react.reactMod

import slinky.core.TagMod
import typingsSlinky.react.Anon_Html
import typingsSlinky.react.reactStrings.foo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait HTMLProps[T] extends AllHTMLAttributes[T] {
  var defaultValue: foo = js.native
  var onChange: foo = js.native
  var `type`: foo = js.native
  var value: foo = js.native
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
    children: TagMod[Any] = null,
    dangerouslySetInnerHTML: Anon_Html = null,
    defaultChecked: js.UndefOr[Boolean] = js.undefined
  ): HTMLProps[T] = {
    val __obj = js.Dynamic.literal(defaultValue = defaultValue.asInstanceOf[js.Any], onChange = onChange.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
    if (acceptCharset != null) __obj.updateDynamic("acceptCharset")(acceptCharset.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
    __obj.asInstanceOf[HTMLProps[T]]
  }
}

