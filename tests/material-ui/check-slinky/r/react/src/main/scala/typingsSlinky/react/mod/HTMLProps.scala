package typingsSlinky.react.mod

import typingsSlinky.react.reactStrings.foo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait HTMLProps[T] extends AllHTMLAttributes[T] {
  
  var defaultValue: foo = js.native
  
  var onChange: foo = js.native
  
  var `type`: foo = js.native
  
  var value: foo = js.native
}
object HTMLProps {
  
  @scala.inline
  def apply[T](defaultValue: foo, onChange: foo, `type`: foo, value: foo): HTMLProps[T] = {
    val __obj = js.Dynamic.literal(defaultValue = defaultValue.asInstanceOf[js.Any], onChange = onChange.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[HTMLProps[T]]
  }
  
  @scala.inline
  implicit class HTMLPropsOps[Self <: HTMLProps[_], T] (val x: Self with HTMLProps[T]) extends AnyVal {
    
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    
    @scala.inline
    def set(key: String, value: js.Any): Self = {
      x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
      x
    }
    
    @scala.inline
    def setDefaultValue(value: foo): Self = this.set("defaultValue", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setOnChange(value: foo): Self = this.set("onChange", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setType(value: foo): Self = this.set("type", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setValue(value: foo): Self = this.set("value", value.asInstanceOf[js.Any])
  }
}
