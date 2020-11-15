package typings.electron.Electron

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait EventEmitter extends js.Object {
  
  def addListener(event: String, listener: js.Function): this.type = js.native
}
object EventEmitter {
  
  @scala.inline
  def apply(addListener: (String, js.Function) => EventEmitter): EventEmitter = {
    val __obj = js.Dynamic.literal(addListener = js.Any.fromFunction2(addListener))
    __obj.asInstanceOf[EventEmitter]
  }
  
  @scala.inline
  implicit class EventEmitterOps[Self <: EventEmitter] (val x: Self) extends AnyVal {
    
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
    def setAddListener(value: (String, js.Function) => EventEmitter): Self = this.set("addListener", js.Any.fromFunction2(value))
  }
}
