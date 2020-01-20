package typingsJapgolly.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// interface SyntheticEvent<T> {
//     currentTarget: EventTarget & T;
// }
// interface AnimationEvent<T> extends SyntheticEvent<T> {
//     nativeEvent: NativeAnimationEvent;
// }
@js.native
trait Attributes extends js.Object {
  var key: js.UndefOr[Key] = js.native
}

object Attributes {
  @scala.inline
  def apply(key: Key = null): Attributes = {
    val __obj = js.Dynamic.literal()
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    __obj.asInstanceOf[Attributes]
  }
}

