package typings.vue.optionsMod

import typings.vue.vueMod.Vue
import typings.vue.vueMod.VueConstructor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.vue.vueMod.VueConstructor[typings.vue.vueMod.Vue]
  - typings.vue.optionsMod.FunctionalComponentOptions[Props, typings.vue.optionsMod.PropsDefinition[Props]]
  - typings.vue.optionsMod.ComponentOptions[typings.vue.vueMod.Vue, Data, Methods, Computed, Props]
*/
trait Component[Data, Methods, Computed, Props] extends js.Object

object Component {
  @scala.inline
  implicit def apply[Data, Methods, Computed, Props](value: ComponentOptions[Vue, Data, Methods, Computed, Props]): Component[Data, Methods, Computed, Props] = value.asInstanceOf[Component[Data, Methods, Computed, Props]]
  @scala.inline
  implicit def apply[Data, Methods, Computed, Props](value: FunctionalComponentOptions[Props, PropsDefinition[Props]]): Component[Data, Methods, Computed, Props] = value.asInstanceOf[Component[Data, Methods, Computed, Props]]
  @scala.inline
  implicit def apply[Data, Methods, Computed, Props](value: VueConstructor[Vue]): Component[Data, Methods, Computed, Props] = value.asInstanceOf[Component[Data, Methods, Computed, Props]]
}

