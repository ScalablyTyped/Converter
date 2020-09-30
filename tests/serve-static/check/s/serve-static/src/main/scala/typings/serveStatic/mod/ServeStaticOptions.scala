package typings.serveStatic.mod

import typings.expressServeStaticCore.mod.Response
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ServeStaticOptions extends js.Object {
  var setHeaders: js.UndefOr[js.Function3[/* res */ Response, /* path */ String, /* stat */ js.Any, _]] = js.native
}

object ServeStaticOptions {
  @scala.inline
  def apply(): ServeStaticOptions = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ServeStaticOptions]
  }
  @scala.inline
  implicit class ServeStaticOptionsOps[Self <: ServeStaticOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setSetHeaders(value: (/* res */ Response, /* path */ String, /* stat */ js.Any) => _): Self = this.set("setHeaders", js.Any.fromFunction3(value))
    @scala.inline
    def deleteSetHeaders: Self = this.set("setHeaders", js.undefined)
  }
  
}

