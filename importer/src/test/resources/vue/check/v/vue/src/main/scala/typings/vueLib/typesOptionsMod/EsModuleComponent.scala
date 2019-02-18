package typings
package vueLib.typesOptionsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait EsModuleComponent extends js.Object {
  var default: Component[
    DefaultData[vueLib.typesVueMod.Vue], 
    DefaultMethods[vueLib.typesVueMod.Vue], 
    DefaultComputed, 
    DefaultProps
  ]
}

object EsModuleComponent {
  @scala.inline
  def apply(
    default: Component[
      DefaultData[vueLib.typesVueMod.Vue], 
      DefaultMethods[vueLib.typesVueMod.Vue], 
      DefaultComputed, 
      DefaultProps
    ]
  ): EsModuleComponent = {
    val __obj = js.Dynamic.literal(default = default.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[EsModuleComponent]
  }
}

