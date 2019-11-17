package typingsJapgolly.react.reactMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait RefAttributes[T] extends Attributes {
  var ref: js.UndefOr[japgolly.scalajs.react.raw.React.Ref] = js.undefined
}

object RefAttributes {
  @scala.inline
  def apply[T](key: Key = null, ref: japgolly.scalajs.react.raw.React.Ref = null): RefAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    __obj.asInstanceOf[RefAttributes[T]]
  }
}

