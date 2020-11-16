package typings.swiz.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ISerializable extends js.Object {
  
  def getSerializerType(): String = js.native
}
object ISerializable {
  
  @scala.inline
  def apply(getSerializerType: () => String): ISerializable = {
    val __obj = js.Dynamic.literal(getSerializerType = js.Any.fromFunction0(getSerializerType))
    __obj.asInstanceOf[ISerializable]
  }
  
  @scala.inline
  implicit class ISerializableOps[Self <: ISerializable] (val x: Self) extends AnyVal {
    
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
    def setGetSerializerType(value: () => String): Self = this.set("getSerializerType", js.Any.fromFunction0(value))
  }
}
