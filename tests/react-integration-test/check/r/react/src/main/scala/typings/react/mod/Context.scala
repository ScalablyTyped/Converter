package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Context[T] extends js.Object {
  var Consumer: typings.react.mod.Consumer[T] = js.native
  var Provider: typings.react.mod.Provider[T] = js.native
  var displayName: js.UndefOr[String] = js.native
}

object Context {
  @scala.inline
  def apply[T](Consumer: Consumer[T], Provider: Provider[T], displayName: String = null): Context[T] = {
    val __obj = js.Dynamic.literal(Consumer = Consumer.asInstanceOf[js.Any], Provider = Provider.asInstanceOf[js.Any])
    if (displayName != null) __obj.updateDynamic("displayName")(displayName.asInstanceOf[js.Any])
    __obj.asInstanceOf[Context[T]]
  }
}

