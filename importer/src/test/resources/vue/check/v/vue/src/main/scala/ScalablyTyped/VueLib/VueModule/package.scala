package ScalablyTyped
package VueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object VueModule {
  type AsyncComponent[Data, Methods, Computed, Props] = VueLib.VueTypesOptionsModule.AsyncComponent[Data, Methods, Computed, Props]
  type Component[Data, Methods, Computed, Props] = VueLib.VueTypesOptionsModule.Component[Data, Methods, Computed, Props]
  type ComponentOptions[V /* <: VueLib.VueTypesVueModule.Vue */, Data, Methods, Computed, PropsDef] = VueLib.VueTypesOptionsModule.ComponentOptions[V, Data, Methods, Computed, PropsDef]
  type ComputedOptions[T] = VueLib.VueTypesOptionsModule.ComputedOptions[T]
  type CreateElement = VueLib.VueTypesVueModule.CreateElement
  type DirectiveFunction = VueLib.VueTypesOptionsModule.DirectiveFunction
  type DirectiveOptions = VueLib.VueTypesOptionsModule.DirectiveOptions
  type FunctionalComponentOptions[Props, PropDefs] = VueLib.VueTypesOptionsModule.FunctionalComponentOptions[Props, PropDefs]
  type PluginFunction[T] = VueLib.VueTypesPluginModule.PluginFunction[T]
  type PluginObject[T] = VueLib.VueTypesPluginModule.PluginObject[T]
  type PropOptions[T] = VueLib.VueTypesOptionsModule.PropOptions[T]
  type RenderContext[Props] = VueLib.VueTypesOptionsModule.RenderContext[Props]
  type VNode = VueLib.VueTypesVnodeModule.VNode
  type VNodeChildren = VueLib.VueTypesVnodeModule.VNodeChildren
  type VNodeChildrenArrayContents = VueLib.VueTypesVnodeModule.VNodeChildrenArrayContents
  type VNodeComponentOptions = VueLib.VueTypesVnodeModule.VNodeComponentOptions
  type VNodeData = VueLib.VueTypesVnodeModule.VNodeData
  type VNodeDirective = VueLib.VueTypesVnodeModule.VNodeDirective
  type VueConstructor[V /* <: VueLib.VueTypesVueModule.Vue */] = VueLib.VueTypesVueModule.VueConstructor[V]
  type WatchHandler[T] = VueLib.VueTypesOptionsModule.WatchHandler[T]
  type WatchOptions = VueLib.VueTypesOptionsModule.WatchOptions
  type WatchOptionsWithHandler[T] = VueLib.VueTypesOptionsModule.WatchOptionsWithHandler[T]
  type default = VueLib.VueTypesVueModule.Vue
}
