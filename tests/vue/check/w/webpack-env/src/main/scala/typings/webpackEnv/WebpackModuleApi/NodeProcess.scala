package typings.webpackEnv.WebpackModuleApi

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/**
  * Inside env you can pass any variable
  */
@js.native
trait NodeProcess extends js.Object {
  var env: js.UndefOr[js.Any] = js.native
}

object NodeProcess {
  @scala.inline
  def apply(env: js.Any = null): NodeProcess = {
    val __obj = js.Dynamic.literal()
    if (env != null) __obj.updateDynamic("env")(env.asInstanceOf[js.Any])
    __obj.asInstanceOf[NodeProcess]
  }
  @scala.inline
  implicit class NodeProcessOps[Self <: NodeProcess] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withEnv(env: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (env != null) ret.updateDynamic("env")(env.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutEnv: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "env")
        ret.asInstanceOf[Self]
    }
  }
  
}

