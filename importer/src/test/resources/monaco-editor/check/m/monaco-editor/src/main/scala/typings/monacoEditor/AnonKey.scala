package typings.monacoEditor

import typings.monacoEditor.monaco.Promise
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonKey[T] extends js.Object {
  var key: String = js.native
  var value: Promise[T, _] = js.native
}

object AnonKey {
  @scala.inline
  def apply[T](key: String, value: Promise[T, _]): AnonKey[T] = {
    val __obj = js.Dynamic.literal(key = key.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[AnonKey[T]]
  }
}

