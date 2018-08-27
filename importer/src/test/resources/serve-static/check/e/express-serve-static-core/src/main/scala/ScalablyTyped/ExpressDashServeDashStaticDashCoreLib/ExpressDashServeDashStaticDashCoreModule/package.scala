package ScalablyTyped
package ExpressDashServeDashStaticDashCoreLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object ExpressDashServeDashStaticDashCoreModule {
  type Handler = RequestHandler
  type NextFunction = js.Function1[/* err */ js.UndefOr[js.Any], scala.Unit]
  type RequestHandler = js.Function3[/* req */ Request, /* res */ Response, /* next */ NextFunction, js.Any]
}
