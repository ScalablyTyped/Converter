package ScalablyTyped
package VueLib.VueModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait PropOptions[T] extends js.Object {
  val default: js.UndefOr[T | scala.Null | js.Function0[js.Object]] = js.undefined
  val required: js.UndefOr[scala.Boolean] = js.undefined
  val `type`: js.UndefOr[VueLib.VueTypesOptionsModule.Prop[T] | StdLib.Array[VueLib.VueTypesOptionsModule.Prop[T]]] = js.undefined
  val validator: js.UndefOr[js.Function1[/* value */ T, scala.Boolean]] = js.undefined
}

