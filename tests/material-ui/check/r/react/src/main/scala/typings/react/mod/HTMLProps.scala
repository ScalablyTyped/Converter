package typings.react.mod

import typings.react.AnonHtml
import typings.react.reactStrings.foo
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
    children: ReactNode = null,
    dangerouslySetInnerHTML: AnonHtml = null,
    defaultChecked: js.UndefOr[Boolean] = js.undefined,
    onClick: Double | (js.Function1[/* x */ String, Unit]) = null
  ): HTMLProps[T] = {
    val __obj = js.Dynamic.literal(defaultValue = defaultValue.asInstanceOf[js.Any], onChange = onChange.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
    if (acceptCharset != null) __obj.updateDynamic("acceptCharset")(acceptCharset.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(onClick.asInstanceOf[js.Any])
    __obj.asInstanceOf[HTMLProps[T]]
  }
  @scala.inline
  implicit class HTMLPropsOps[Self[t] <: HTMLProps[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withDefaultValue(defaultValue: foo): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("defaultValue")(defaultValue.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnChange(onChange: foo): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("onChange")(onChange.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withType(`type`: foo): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("type")(`type`.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withValue(value: foo): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("value")(value.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

