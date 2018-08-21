package ScalablyTyped
package StylisLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object StylisStylisModule {
  type Context = scala.Double
  type Plugin = js.Function10[/* this */ StylisLib.StylisStylisModule.Stylis, /* context */ StylisLib.StylisStylisModule.Context, /* content */ java.lang.String, /* selector */ StylisLib.StylisStylisModule.Selectors, /* parent */ StylisLib.StylisStylisModule.Selectors, /* line */ scala.Double, /* column */ scala.Double, /* length */ scala.Double, /* at */ scala.Double, /* depth */ scala.Double, scala.Null | scala.Unit | java.lang.String]
  type Selectors = StdLib.Array[java.lang.String]
  type Set = js.Function1[/* options */ js.UndefOr[StylisLib.StylisStylisModule.Options], js.Object]
  type Use = js.Function1[/* plugin */ js.UndefOr[StdLib.Array[StylisLib.StylisStylisModule.Plugin] | StylisLib.StylisStylisModule.Plugin | scala.Null], js.Object]
}
