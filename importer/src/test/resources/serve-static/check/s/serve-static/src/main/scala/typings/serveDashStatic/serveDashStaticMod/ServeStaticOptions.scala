package typings.serveDashStatic.serveDashStaticMod

import org.scalablytyped.runtime.UndefOr
import typings.expressDashServeDashStaticDashCore.expressDashServeDashStaticDashCoreMod.Response
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ServeStaticOptions extends js.Object {
  var setHeaders: UndefOr[js.Function3[/* res */ Response, /* path */ String, /* stat */ js.Any, _]] = js.undefined
}

object ServeStaticOptions {
  @scala.inline
  def apply(setHeaders: (/* res */ Response, /* path */ String, /* stat */ js.Any) => _ = null): ServeStaticOptions = {
    val __obj = js.Dynamic.literal()
    if (setHeaders != null) __obj.updateDynamic("setHeaders")(js.Any.fromFunction3(setHeaders))
    __obj.asInstanceOf[ServeStaticOptions]
  }
}

