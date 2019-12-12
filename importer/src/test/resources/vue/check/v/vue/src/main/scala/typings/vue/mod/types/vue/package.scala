package typings.vue.mod.types

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object vue {
  type CombinedVueInstance[Instance /* <: Vue */, Data, Methods, Computed, Props] = Data with Methods with Computed with Props with Instance
  type ExtendedVue[Instance /* <: Vue */, Data, Methods, Computed, Props] = VueConstructor[(CombinedVueInstance[Instance, Data, Methods, Computed, Props]) with Vue]
}
