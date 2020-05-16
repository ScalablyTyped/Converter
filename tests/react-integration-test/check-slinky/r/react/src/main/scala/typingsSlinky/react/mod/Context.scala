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
  @scala.inline
  implicit class ContextOps[Self[t] <: Context[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withConsumer(Consumer: ReactComponentClass[ConsumerProps[T]]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("Consumer")(Consumer.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withProvider(Provider: ReactComponentClass[ProviderProps[T]]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("Provider")(Provider.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withDisplayName(displayName: String): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (displayName != null) ret.updateDynamic("displayName")(displayName.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDisplayName: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "displayName")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

