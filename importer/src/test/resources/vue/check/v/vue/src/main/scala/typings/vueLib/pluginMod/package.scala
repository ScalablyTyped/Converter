package typings
package vueLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object pluginMod {
  type PluginFunction[T] = js.Function2[
    /* Vue */ vueLib.vueVueMod.VueConstructor[vueLib.vueVueMod.Vue], 
    /* options */ js.UndefOr[T], 
    scala.Unit
  ]
}
