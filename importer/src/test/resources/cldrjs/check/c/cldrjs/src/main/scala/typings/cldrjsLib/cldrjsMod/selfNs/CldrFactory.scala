package typings
package cldrjsLib.cldrjsMod.selfNs

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
    load: js.Function2[js.Any, /* repeated */ js.Any, scala.Unit],
    off: js.Function2[
      java.lang.String, 
      js.Function2[/* path */ java.lang.String, /* value */ js.Any, scala.Unit], 
      scala.Unit
    ],
    on: js.Function2[
      java.lang.String, 
      js.Function2[/* path */ java.lang.String, /* value */ js.Any, scala.Unit], 
      scala.Unit
    ],
    once: js.Function2[
      java.lang.String, 
      js.Function2[/* path */ java.lang.String, /* value */ js.Any, scala.Unit], 
      scala.Unit
    ]
  ): CldrFactory = {
    val __obj = js.Dynamic.literal(load = load, off = off, on = on, once = once)
  
    __obj.asInstanceOf[CldrFactory]
  }
}

