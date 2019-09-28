package typings.fullcalendar

import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace
import typings.fullcalendar.mixinMod.Default
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("fullcalendar/Mixin", Namespace)
@js.native
object mixinMod extends js.Object {
  @js.native
  class Default () extends js.Object
  
  @js.native
  class default () extends Default
  
  /* static members */
  @js.native
  object Default extends js.Object {
    def mixInto(destClass: js.Any): Unit = js.native
    def mixOver(destClass: js.Any): Unit = js.native
  }
  
  /* static members */
  @js.native
  object default extends js.Object {
    def mixInto(destClass: js.Any): Unit = js.native
    def mixOver(destClass: js.Any): Unit = js.native
  }
  
}

