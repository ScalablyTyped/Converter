package typings
package winstonLib.libWinstonConfigMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Config extends js.Object {
  var foo: winstonLib.winstonLibStrings.bar
}

object Config {
  @scala.inline
  def apply(foo: winstonLib.winstonLibStrings.bar): Config = {
    val __obj = js.Dynamic.literal(foo = foo)
  
    __obj.asInstanceOf[Config]
  }
}

