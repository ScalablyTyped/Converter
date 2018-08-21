package ScalablyTyped
package ExpressDashServeDashStaticDashCoreLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object ExpressDashServeDashStaticDashCoreModule {
  type Handler = ExpressDashServeDashStaticDashCoreLib.ExpressDashServeDashStaticDashCoreModule.RequestHandler
  type NextFunction = js.Function1[/* err */ js.UndefOr[js.Any], scala.Unit]
  type RequestHandler = js.Function3[/* req */ ExpressDashServeDashStaticDashCoreLib.ExpressDashServeDashStaticDashCoreModule.Request, /* res */ ExpressDashServeDashStaticDashCoreLib.ExpressDashServeDashStaticDashCoreModule.Response, /* next */ ExpressDashServeDashStaticDashCoreLib.ExpressDashServeDashStaticDashCoreModule.NextFunction, js.Any]
}
