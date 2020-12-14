package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.RefHandle
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
  def apply[T](): RefHandle[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[RefHandle[T]]
  }
  
  @scala.inline
  implicit class RefObjectMutableBuilder[Self <: RefHandle[_], T] (val x: Self with RefHandle[T]) extends AnyVal {
    
    @scala.inline
    def setCurrent(value: T): Self = StObject.set(x, "current", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setCurrentNull: Self = StObject.set(x, "current", null)
  }
}
