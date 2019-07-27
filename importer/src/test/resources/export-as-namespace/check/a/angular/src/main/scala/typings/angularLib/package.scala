package typings

import stdLib.ArrayLike
import stdLib.Document
import stdLib.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object angularLib {
  type JQueryStatic = js.Function1[
    /* element */ String | Element | Document | JQuery | ArrayLike[Element] | js.Function0[Unit], 
    JQLite
  ]
}
