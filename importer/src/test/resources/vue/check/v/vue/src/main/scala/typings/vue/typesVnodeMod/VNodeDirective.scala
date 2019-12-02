package typings.vue.typesVnodeMod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait VNodeDirective extends js.Object {
  val arg: String
  val expression: js.Any
  val modifiers: StringDictionary[Boolean]
  val name: String
  val oldValue: js.Any
  val value: js.Any
}

object VNodeDirective {
  @scala.inline
  def apply(
    arg: String,
    expression: js.Any,
    modifiers: StringDictionary[Boolean],
    name: String,
    oldValue: js.Any,
    value: js.Any
  ): VNodeDirective = {
    val __obj = js.Dynamic.literal(arg = arg.asInstanceOf[js.Any], expression = expression.asInstanceOf[js.Any], modifiers = modifiers.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any], oldValue = oldValue.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[VNodeDirective]
  }
}

