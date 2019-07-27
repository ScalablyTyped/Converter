package typings

import typings.stdLib.ArrayLike
import typings.stdLib.Document
import typings.stdLib.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object angularLib {
  type JQueryStatic = js.Function1[
    /* element */ String | Element | Document | JQuery | ArrayLike[Element] | js.Function0[Unit], 
    JQLite
  ]
}
