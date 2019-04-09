package typings
package cldrjsLib.cldrjsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait CldrFactory extends js.Object {
  def load(json: js.Any, otherJson: js.Any*): scala.Unit
  def off(
    event: java.lang.String,
    listener: js.Function2[/* path */ java.lang.String, /* value */ js.Any, scala.Unit]
  ): scala.Unit
  def on(
    event: java.lang.String,
    listener: js.Function2[/* path */ java.lang.String, /* value */ js.Any, scala.Unit]
  ): scala.Unit
  def once(
    event: java.lang.String,
    listener: js.Function2[/* path */ java.lang.String, /* value */ js.Any, scala.Unit]
  ): scala.Unit
}

object CldrFactory {
  @scala.inline
  def apply(
    load: (js.Any, /* repeated */ js.Any) => scala.Unit,
    off: (java.lang.String, js.Function2[/* path */ java.lang.String, /* value */ js.Any, scala.Unit]) => scala.Unit,
    on: (java.lang.String, js.Function2[/* path */ java.lang.String, /* value */ js.Any, scala.Unit]) => scala.Unit,
    once: (java.lang.String, js.Function2[/* path */ java.lang.String, /* value */ js.Any, scala.Unit]) => scala.Unit
  ): CldrFactory = {
    val __obj = js.Dynamic.literal(load = js.Any.fromFunction2(load), off = js.Any.fromFunction2(off), on = js.Any.fromFunction2(on), once = js.Any.fromFunction2(once))
  
    __obj.asInstanceOf[CldrFactory]
  }
}

