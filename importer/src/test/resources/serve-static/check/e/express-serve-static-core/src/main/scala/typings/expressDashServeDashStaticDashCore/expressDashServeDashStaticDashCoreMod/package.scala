package typings.expressDashServeDashStaticDashCore

import scala.scalajs.js
import scala.scalajs.js.`|`

package object expressDashServeDashStaticDashCoreMod {
  type Handler = RequestHandler
  type NextFunction = js.Function1[/* err */ js.UndefOr[js.Any], Unit]
  type RequestHandler = js.Function3[/* req */ Request, /* res */ Response, /* next */ NextFunction, js.Any]
}
