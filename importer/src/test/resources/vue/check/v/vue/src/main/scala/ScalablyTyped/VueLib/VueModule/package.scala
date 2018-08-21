package ScalablyTyped
package VueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object VueModule {
  type AsyncComponent[Data, Methods, Computed, Props] = js.Function2[/* resolve */ js.Function1[/* component */ VueLib.VueTypesOptionsModule.Component[Data, Methods, Computed, Props], scala.Unit], /* reject */ js.Function1[/* reason */ js.UndefOr[js.Any], scala.Unit], StdLib.Promise | scala.Unit]
  type Component[Data, Methods, Computed, Props] = VueLib.VueTypesVueModule.VueConstructor[VueLib.VueTypesVueModule.Vue] | (VueLib.VueTypesOptionsModule.FunctionalComponentOptions[Props, VueLib.VueTypesOptionsModule.PropsDefinition[Props]]) | (VueLib.VueTypesOptionsModule.ComponentOptions[VueLib.VueTypesVueModule.Vue, Data, Methods, Computed, Props])
  type DirectiveFunction = js.Function4[/* el */ StdLib.HTMLElement, /* binding */ VueLib.VueTypesVnodeModule.VNodeDirective, /* vnode */ VueLib.VueTypesVnodeModule.VNode, /* oldVnode */ VueLib.VueTypesVnodeModule.VNode, scala.Unit]
  type PluginFunction[T] = js.Function2[/* Vue */ VueLib.VueTypesVueModule.VueConstructor[VueLib.VueTypesVueModule.Vue], /* options */ js.UndefOr[T], scala.Unit]
  type VNodeChildren = VueLib.VueTypesVnodeModule.VNodeChildrenArrayContents | js.Array[VueLib.VueTypesVnodeModule.ScopedSlot] | java.lang.String
  type WatchHandler[T] = js.Function2[/* val */ T, /* oldVal */ T, scala.Unit]
  type default = VueLib.VueTypesVueModule.Vue
}
