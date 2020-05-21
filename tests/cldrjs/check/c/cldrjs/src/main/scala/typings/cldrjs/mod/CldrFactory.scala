package typings.cldrjs.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait CldrFactory extends js.Object {
  def load(json: js.Any, otherJson: js.Any*): Unit = js.native
  def off(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
  def on(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
  def once(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
}

object CldrFactory {
  @scala.inline
  def apply(
    load: (js.Any, /* repeated */ js.Any) => Unit,
    off: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit,
    on: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit,
    once: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit
  ): CldrFactory = {
    val __obj = js.Dynamic.literal(load = js.Any.fromFunction2(load), off = js.Any.fromFunction2(off), on = js.Any.fromFunction2(on), once = js.Any.fromFunction2(once))
    __obj.asInstanceOf[CldrFactory]
  }
  @scala.inline
  implicit class CldrFactoryOps[Self <: CldrFactory] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setLoad(value: (js.Any, /* repeated */ js.Any) => Unit): Self = this.set("load", js.Any.fromFunction2(value))
    @scala.inline
    def setOff(value: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit): Self = this.set("off", js.Any.fromFunction2(value))
    @scala.inline
    def setOn(value: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit): Self = this.set("on", js.Any.fromFunction2(value))
    @scala.inline
    def setOnce(value: (String, js.Function2[/* path */ String, /* value */ js.Any, Unit]) => Unit): Self = this.set("once", js.Any.fromFunction2(value))
  }
  
}

