package typings.phaser

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object p2 {
  
  @js.native
  trait AABB extends js.Object {
    
    def copy(aabb: AABB): Unit = js.native
  }
  object AABB {
    
    @scala.inline
    def apply(copy: AABB => Unit): AABB = {
      val __obj = js.Dynamic.literal(copy = js.Any.fromFunction1(copy))
      __obj.asInstanceOf[AABB]
    }
    
    @scala.inline
    implicit class AABBOps[Self <: AABB] (val x: Self) extends AnyVal {
      
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
      def setCopy(value: AABB => Unit): Self = this.set("copy", js.Any.fromFunction1(value))
    }
  }
}
