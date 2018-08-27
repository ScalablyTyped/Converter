package ScalablyTyped
package VueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object VueTypesVueModule {
  type CombinedVueInstance[Instance /* <: Vue */, Data, Methods, Computed, Props] = Computed with Data with Instance with Methods with Props
  type ExtendedVue[Instance /* <: Vue */, Data, Methods, Computed, Props] = VueConstructor[(CombinedVueInstance[Instance, Data, Methods, Computed, Props]) with Vue]
}
