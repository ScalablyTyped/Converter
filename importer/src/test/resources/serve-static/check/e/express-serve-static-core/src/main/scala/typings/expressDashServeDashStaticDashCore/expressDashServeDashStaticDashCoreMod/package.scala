package typings.expressDashServeDashStaticDashCore

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object expressDashServeDashStaticDashCoreMod {
  import org.scalablytyped.runtime.UndefOr

  type Handler = RequestHandler
  type NextFunction = js.Function1[UndefOr[js.Any], Unit]
  type RequestHandler = js.Function3[/* req */ Request, /* res */ Response, /* next */ NextFunction, js.Any]
}
