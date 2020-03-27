package typings.winston.configMod

import typings.winston.winstonStrings.bar
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Config extends js.Object {
  var foo: bar = js.native
}

object Config {
  @scala.inline
  def apply(foo: bar): Config = {
    val __obj = js.Dynamic.literal(foo = foo.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[Config]
  }
}

