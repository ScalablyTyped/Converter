package typingsSlinky.react.mod

import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Context[T] extends js.Object {
  
  var Consumer: ReactComponentClass[ConsumerProps[T]] = js.native
  
  var Provider: ReactComponentClass[ProviderProps[T]] = js.native
  
  var displayName: js.UndefOr[String] = js.native
}
object Context {
  
  @scala.inline
  def apply[T](Consumer: ReactComponentClass[ConsumerProps[T]], Provider: ReactComponentClass[ProviderProps[T]]): Context[T] = {
    val __obj = js.Dynamic.literal(Consumer = Consumer.asInstanceOf[js.Any], Provider = Provider.asInstanceOf[js.Any])
    __obj.asInstanceOf[Context[T]]
  }
  
  @scala.inline
  implicit class ContextOps[Self <: Context[_], T] (val x: Self with Context[T]) extends AnyVal {
    
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
    def setConsumer(value: ReactComponentClass[ConsumerProps[T]]): Self = this.set("Consumer", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setProvider(value: ReactComponentClass[ProviderProps[T]]): Self = this.set("Provider", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setDisplayName(value: String): Self = this.set("displayName", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteDisplayName: Self = this.set("displayName", js.undefined)
  }
}
