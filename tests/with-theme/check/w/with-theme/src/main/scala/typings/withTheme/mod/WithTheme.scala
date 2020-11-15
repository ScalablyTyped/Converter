package typings.withTheme.mod

import typings.react.mod.Ref
import typings.react.mod.RefObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait WithTheme extends js.Object {
  
  var innerRef: js.UndefOr[Ref[_] | RefObject[_]] = js.native
  
  var theme: String = js.native
}
object WithTheme {
  
  @scala.inline
  def apply(theme: String): WithTheme = {
    val __obj = js.Dynamic.literal(theme = theme.asInstanceOf[js.Any])
    __obj.asInstanceOf[WithTheme]
  }
  
  @scala.inline
  implicit class WithThemeOps[Self <: WithTheme] (val x: Self) extends AnyVal {
    
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
    def setTheme(value: String): Self = this.set("theme", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setInnerRef(value: Ref[_] | RefObject[_]): Self = this.set("innerRef", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteInnerRef: Self = this.set("innerRef", js.undefined)
  }
}
