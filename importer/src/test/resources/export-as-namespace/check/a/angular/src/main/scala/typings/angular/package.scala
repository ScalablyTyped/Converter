package typings

import typings.std.ArrayLike
import typings.std.Document
import typings.std.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object angular {
  type JQueryStatic = js.Function1[
    /* element */ String | Element | Document | JQuery | ArrayLike[Element] | js.Function0[Unit], 
    JQLite
  ]
}
