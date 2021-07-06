package typings.storybookVue

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Kind extends StObject {
    
    var kind: String = js.native
    
    var story: String = js.native
  }
  object Kind {
    
    @scala.inline
    def apply(kind: String, story: String): Kind = {
      val __obj = js.Dynamic.literal(kind = kind.asInstanceOf[js.Any], story = story.asInstanceOf[js.Any])
      __obj.asInstanceOf[Kind]
    }
    
    @scala.inline
    implicit class KindMutableBuilder[Self <: Kind] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setKind(value: String): Self = StObject.set(x, "kind", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setStory(value: String): Self = StObject.set(x, "story", value.asInstanceOf[js.Any])
    }
  }
}
