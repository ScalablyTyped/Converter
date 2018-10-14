package ScalablyTyped
package CldrjsLib.CldrjsModule.selfNamespace

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

