package typings.reactIconBase.mod

import typings.react.mod.ClassAttributes
import typings.react.mod.Key
import typings.react.mod.ReactSVGElement
import typings.react.mod.Ref
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait IconBaseProps extends ClassAttributes[ReactSVGElement] {
  var size: js.UndefOr[String | Double] = js.native
}

object IconBaseProps {
  @scala.inline
  def apply(key: Key = null, ref: Ref[ReactSVGElement] = null, size: String | Double = null): IconBaseProps = {
    val __obj = js.Dynamic.literal()
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    __obj.asInstanceOf[IconBaseProps]
  }
}

