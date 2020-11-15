package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.raw.React.RefHandle
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait RefAttributes[T] extends Attributes {
  
  var ref: js.UndefOr[japgolly.scalajs.react.raw.React.Ref] = js.native
}
object RefAttributes {
  
  @scala.inline
  def apply[T](): RefAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[RefAttributes[T]]
  }
  
  @scala.inline
  implicit class RefAttributesOps[Self <: RefAttributes[_], T] (val x: Self with RefAttributes[T]) extends AnyVal {
    
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
    def setRefRefObject(value: RefHandle[T]): Self = this.set("ref", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setRefFunction1(value: /* instance */ T | Null => Callback): Self = this.set("ref", js.Any.fromFunction1((t0: /* instance */ T | Null) => value(t0).runNow()))
    
    @scala.inline
    def setRef(value: japgolly.scalajs.react.raw.React.Ref): Self = this.set("ref", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteRef: Self = this.set("ref", js.undefined)
    
    @scala.inline
    def setRefNull: Self = this.set("ref", null)
  }
}
