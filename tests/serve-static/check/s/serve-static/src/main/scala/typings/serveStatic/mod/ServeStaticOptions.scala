package typings.serveStatic.mod

import typings.expressServeStaticCore.mod.Response
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ServeStaticOptions extends js.Object {
  var setHeaders: js.UndefOr[js.Function3[/* res */ Response, /* path */ String, /* stat */ js.Any, _]] = js.native
}

object ServeStaticOptions {
  @scala.inline
  def apply(setHeaders: (/* res */ Response, /* path */ String, /* stat */ js.Any) => _ = null): ServeStaticOptions = {
    val __obj = js.Dynamic.literal()
    if (setHeaders != null) __obj.updateDynamic("setHeaders")(js.Any.fromFunction3(setHeaders))
    __obj.asInstanceOf[ServeStaticOptions]
  }
  @scala.inline
  implicit class ServeStaticOptionsOps[Self <: ServeStaticOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withSetHeaders(setHeaders: (/* res */ Response, /* path */ String, /* stat */ js.Any) => _): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (setHeaders != null) ret.updateDynamic("setHeaders")(js.Any.fromFunction3(setHeaders))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutSetHeaders: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "setHeaders")
        ret.asInstanceOf[Self]
    }
  }
  
}

