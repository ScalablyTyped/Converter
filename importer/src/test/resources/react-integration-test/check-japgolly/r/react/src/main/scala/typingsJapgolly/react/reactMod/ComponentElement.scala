package typingsJapgolly.react.reactMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ComponentElement[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */] extends ReactElement {
  var ref: js.UndefOr[LegacyRef[T]] = js.undefined
}

object ComponentElement {
  @scala.inline
  def apply[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */](props: js.Any, `type`: js.Any, key: Key = null, ref: LegacyRef[T] = null): ComponentElement[P, T] = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    __obj.asInstanceOf[ComponentElement[P, T]]
  }
}

