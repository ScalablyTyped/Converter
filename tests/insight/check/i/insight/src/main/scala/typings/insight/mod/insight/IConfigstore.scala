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
  @scala.inline
  implicit class IConfigstoreOps[Self <: IConfigstore] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAll(all: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("all")(all.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withDel(del: String => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("del")(js.Any.fromFunction1(del))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withGet(get: String => js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("get")(js.Any.fromFunction1(get))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPath(path: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("path")(path.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withSet(set: (String, js.Any) => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("set")(js.Any.fromFunction2(set))
        ret.asInstanceOf[Self]
    }
  }
  
}

