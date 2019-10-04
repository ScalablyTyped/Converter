package typings.monacoDashEditor

import typings.monacoDashEditor.monaco.Promise
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Anon_Key[T] extends js.Object {
  var key: String
  var value: Promise[T, _]
}

object Anon_Key {
  @scala.inline
  def apply[T](key: String, value: Promise[T, _]): Anon_Key[T] = {
    val __obj = js.Dynamic.literal(key = key, value = value)
  
    __obj.asInstanceOf[Anon_Key[T]]
  }
}

