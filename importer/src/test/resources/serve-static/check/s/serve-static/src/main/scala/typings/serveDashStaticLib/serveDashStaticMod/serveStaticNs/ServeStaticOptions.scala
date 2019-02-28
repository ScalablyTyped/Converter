package typings
package serveDashStaticLib.serveDashStaticMod.serveStaticNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ServeStaticOptions extends js.Object {
  var setHeaders: js.UndefOr[
    js.Function3[
      /* res */ expressDashServeDashStaticDashCoreLib.expressDashServeDashStaticDashCoreMod.Response, 
      /* path */ java.lang.String, 
      /* stat */ js.Any, 
      _
    ]
  ] = js.undefined
}

object ServeStaticOptions {
  @scala.inline
  def apply(
    setHeaders: js.Function3[
      /* res */ expressDashServeDashStaticDashCoreLib.expressDashServeDashStaticDashCoreMod.Response, 
      /* path */ java.lang.String, 
      /* stat */ js.Any, 
      _
    ] = null
  ): ServeStaticOptions = {
    val __obj = js.Dynamic.literal()
    if (setHeaders != null) __obj.updateDynamic("setHeaders")(setHeaders)
    __obj.asInstanceOf[ServeStaticOptions]
  }
}

