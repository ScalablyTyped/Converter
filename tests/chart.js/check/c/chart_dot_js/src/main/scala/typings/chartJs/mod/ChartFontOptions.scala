package typings.chartJs.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ChartFontOptions extends js.Object {
  
  var foo: Boolean = js.native
}
object ChartFontOptions {
  
  @scala.inline
  def apply(foo: Boolean): ChartFontOptions = {
    val __obj = js.Dynamic.literal(foo = foo.asInstanceOf[js.Any])
    __obj.asInstanceOf[ChartFontOptions]
  }
  
  @scala.inline
  implicit class ChartFontOptionsOps[Self <: ChartFontOptions] (val x: Self) extends AnyVal {
    
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
    def setFoo(value: Boolean): Self = this.set("foo", value.asInstanceOf[js.Any])
  }
}
