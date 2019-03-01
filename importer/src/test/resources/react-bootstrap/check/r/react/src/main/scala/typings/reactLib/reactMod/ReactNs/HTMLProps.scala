package typings
package reactLib.reactMod.ReactNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait HTMLProps[T]
  extends AllHTMLAttributes[T]
     with ClassAttributes[T] {
  var defaultValue: reactLib.reactLibStrings.foo
  var onChange: reactLib.reactLibStrings.foo
  var `type`: reactLib.reactLibStrings.foo
  var value: reactLib.reactLibStrings.foo
}

object HTMLProps {
  @scala.inline
  def apply[T](
    defaultValue: reactLib.reactLibStrings.foo,
    onChange: reactLib.reactLibStrings.foo,
    `type`: reactLib.reactLibStrings.foo,
    value: reactLib.reactLibStrings.foo,
    accept: java.lang.String = null,
    acceptCharset: java.lang.String = null,
    children: ReactNode = null,
    dangerouslySetInnerHTML: reactLib.Anon_Html = null,
    defaultChecked: js.UndefOr[scala.Boolean] = js.undefined,
    key: Key = null,
    ref: Ref[T] = null
  ): HTMLProps[T] = {
    val __obj = js.Dynamic.literal(defaultValue = defaultValue, onChange = onChange, value = value)
    __obj.updateDynamic("type")(`type`)
    if (accept != null) __obj.updateDynamic("accept")(accept)
    if (acceptCharset != null) __obj.updateDynamic("acceptCharset")(acceptCharset)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML)
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked)
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    __obj.asInstanceOf[HTMLProps[T]]
  }
}

