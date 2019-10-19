package typings.cldrjs.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait CldrFactory extends js.Object {
  def load(json: js.Any, otherJson: js.Any*): Unit
  def off(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit
  def on(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit
  def once(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit
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
}

