package ScalablyTyped
package VueLib
package VueTypesOptionsModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait ComputedOptions[T] extends js.Object {
  val cache: js.UndefOr[scala.Boolean] = js.undefined
  val get: js.UndefOr[js.Function0[T]] = js.undefined
  val set: js.UndefOr[js.Function1[/* value */ T, scala.Unit]] = js.undefined
}

