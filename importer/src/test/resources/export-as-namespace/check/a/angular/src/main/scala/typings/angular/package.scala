package typings

import scala.scalajs.js
import scala.scalajs.js.`|`

package object angular {
  import typings.std.ArrayLike
  import typings.std.Document
  import typings.std.Element

  type JQueryStatic = js.Function1[
    /* element */ String | Element | Document | JQuery | ArrayLike[Element] | js.Function0[Unit], 
    JQLite
  ]
}
