package typings
package vueLib.typesVnodeMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait VNodeDirective extends js.Object {
  val arg: java.lang.String
  val expression: js.Any
  val modifiers: org.scalablytyped.runtime.StringDictionary[scala.Boolean]
  val name: java.lang.String
  val oldValue: js.Any
  val value: js.Any
}

object VNodeDirective {
  @scala.inline
  def apply(
    arg: java.lang.String,
    expression: js.Any,
    modifiers: org.scalablytyped.runtime.StringDictionary[scala.Boolean],
    name: java.lang.String,
    oldValue: js.Any,
    value: js.Any
  ): VNodeDirective = {
    val __obj = js.Dynamic.literal(arg = arg, expression = expression, modifiers = modifiers, name = name, oldValue = oldValue, value = value)
  
    __obj.asInstanceOf[VNodeDirective]
  }
}

