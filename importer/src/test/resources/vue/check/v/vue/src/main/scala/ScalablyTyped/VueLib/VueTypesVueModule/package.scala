package ScalablyTyped
package VueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object VueTypesVueModule {
  type CombinedVueInstance[Instance /* <: VueLib.VueTypesVueModule.Vue */, Data, Methods, Computed, Props] = Computed with Data with Instance with Methods with Props
  type ExtendedVue[Instance /* <: VueLib.VueTypesVueModule.Vue */, Data, Methods, Computed, Props] = VueLib.VueTypesVueModule.VueConstructor[(VueLib.VueTypesVueModule.CombinedVueInstance[Instance, Data, Methods, Computed, Props]) with VueLib.VueTypesVueModule.Vue]
}
