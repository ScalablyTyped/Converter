package typings.phaser

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object p2 {
  
  @js.native
  trait AABB extends StObject {
    
    def copy(aabb: AABB): Unit = js.native
  }
  object AABB {
    
    @scala.inline
    def apply(copy: AABB => Unit): AABB = {
      val __obj = js.Dynamic.literal(copy = js.Any.fromFunction1(copy))
      __obj.asInstanceOf[AABB]
    }
    
    @scala.inline
    implicit class AABBMutableBuilder[Self <: AABB] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setCopy(value: AABB => Unit): Self = StObject.set(x, "copy", js.Any.fromFunction1(value))
    }
  }
}
