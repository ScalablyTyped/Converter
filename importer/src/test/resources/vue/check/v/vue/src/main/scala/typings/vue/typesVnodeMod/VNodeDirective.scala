package typings.vue.typesVnodeMod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait VNodeDirective extends js.Object {
  val arg: String
  val expression: js.Any
  val modifiers: StringDictionary[Boolean]
  val name: String
  val oldValue: js.Any
  val value: js.Any
}

object VNodeDirective {
  @inline
  def apply(
    arg: String,
    expression: js.Any,
    modifiers: StringDictionary[Boolean],
    name: String,
    oldValue: js.Any,
    value: js.Any
  ): VNodeDirective = {
    val __obj = js.Dynamic.literal(arg = arg, expression = expression, modifiers = modifiers, name = name, oldValue = oldValue, value = value)
  
    __obj.asInstanceOf[VNodeDirective]
  }
}

