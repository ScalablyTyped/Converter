package typingsSlinky.react.mod

import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Context[T] extends js.Object {
  var Consumer: ReactComponentClass[ConsumerProps[T]] = js.native
  var Provider: ReactComponentClass[ProviderProps[T]] = js.native
  var displayName: js.UndefOr[String] = js.native
}

object Context {
  @scala.inline
  def apply[T](
    Consumer: ReactComponentClass[ConsumerProps[T]],
    Provider: ReactComponentClass[ProviderProps[T]],
    displayName: String = null
  ): Context[T] = {
    val __obj = js.Dynamic.literal(Consumer = Consumer.asInstanceOf[js.Any], Provider = Provider.asInstanceOf[js.Any])
    if (displayName != null) __obj.updateDynamic("displayName")(displayName.asInstanceOf[js.Any])
    __obj.asInstanceOf[Context[T]]
  }
}

