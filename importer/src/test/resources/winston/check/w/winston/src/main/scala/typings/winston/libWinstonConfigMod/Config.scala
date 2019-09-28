package typings.winston.libWinstonConfigMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.winston.winstonStrings.bar
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Config extends js.Object {
  var foo: bar
}

object Config {
  @inline
  def apply(foo: bar): Config = {
    val __obj = js.Dynamic.literal(foo = foo)
  
    __obj.asInstanceOf[Config]
  }
}

