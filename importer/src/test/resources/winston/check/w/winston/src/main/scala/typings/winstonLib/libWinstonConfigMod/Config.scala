package typings
package winstonLib.libWinstonConfigMod

import winstonLib.winstonLibStrings.bar
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Config extends js.Object {
  var foo: bar
}

object Config {
  @scala.inline
  def apply(foo: bar): Config = {
    val __obj = js.Dynamic.literal(foo = foo)
  
    __obj.asInstanceOf[Config]
  }
}

