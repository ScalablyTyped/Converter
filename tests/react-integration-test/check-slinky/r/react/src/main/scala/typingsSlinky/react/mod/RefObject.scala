package typingsSlinky.react.mod

import slinky.core.facade.ReactRef
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait RefObject[T] extends StObject {
  
  val current: T | Null = js.native
}
object RefObject {
  
  @scala.inline
  def apply[T](): ReactRef[T] = {
    val current = null
    val __obj = js.Dynamic.literal(current = current.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactRef[T]]
  }
  
  @scala.inline
  implicit class RefObjectMutableBuilder[Self <: ReactRef[_], T] (val x: Self with ReactRef[T]) extends AnyVal {
    
    @scala.inline
    def setCurrent(value: T): Self = StObject.set(x, "current", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setCurrentNull: Self = StObject.set(x, "current", null)
  }
}
