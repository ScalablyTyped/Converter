package typings.phaser

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object p2 {
  
  trait AABB extends StObject {
    
    def copy(aabb: AABB): Unit
  }
  object AABB {
    
    inline def apply(copy: AABB => Unit): AABB = {
      val __obj = js.Dynamic.literal(copy = js.Any.fromFunction1(copy))
      __obj.asInstanceOf[AABB]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: AABB] (val x: Self) extends AnyVal {
      
      inline def setCopy(value: AABB => Unit): Self = StObject.set(x, "copy", js.Any.fromFunction1(value))
    }
  }
}
