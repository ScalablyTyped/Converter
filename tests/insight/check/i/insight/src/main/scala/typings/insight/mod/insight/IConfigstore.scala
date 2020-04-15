package typings.insight.mod.insight

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait IConfigstore extends js.Object {
  var all: js.Any = js.native
  var path: String = js.native
  def del(key: String): Unit = js.native
  def get(key: String): js.Any = js.native
  def set(key: String, `val`: js.Any): Unit = js.native
}

object IConfigstore {
  @scala.inline
  def apply(
    all: js.Any,
    del: String => Unit,
    get: String => js.Any,
    path: String,
    set: (String, js.Any) => Unit
  ): IConfigstore = {
    val __obj = js.Dynamic.literal(all = all.asInstanceOf[js.Any], del = js.Any.fromFunction1(del), get = js.Any.fromFunction1(get), path = path.asInstanceOf[js.Any], set = js.Any.fromFunction2(set))
    __obj.asInstanceOf[IConfigstore]
  }
}

