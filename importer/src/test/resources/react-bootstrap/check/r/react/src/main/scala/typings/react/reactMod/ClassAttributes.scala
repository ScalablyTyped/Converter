package typings.react.reactMod

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait ClassAttributes[T] extends Attributes {
  var ref: js.UndefOr[Ref[T]] = js.undefined
}

object ClassAttributes {
  @inline
  def apply[T](key: Key = null, ref: Ref[T] = null): ClassAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    __obj.asInstanceOf[ClassAttributes[T]]
  }
}

