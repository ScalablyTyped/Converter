package typings.withTheme

import typings.react.mod.ComponentClass
import typings.react.mod.ComponentType
import typings.react.mod.Ref
import typings.react.mod.RefObject
import typings.std.Pick
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("with-theme", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  @scala.inline
  def default(): js.Function1[/* component */ ComponentType[js.Any with WithTheme], ComponentClass[js.Any]] = ^.asInstanceOf[js.Dynamic].applyDynamic("default")().asInstanceOf[js.Function1[/* component */ ComponentType[js.Any with WithTheme], ComponentClass[js.Any]]]
  
  type ConsistentWith[T, U] = Pick[U, /* keyof T */ String]
  
  @js.native
  trait WithTheme extends StObject {
    
    var innerRef: js.UndefOr[Ref[js.Any] | RefObject[js.Any]] = js.native
    
    var theme: String = js.native
  }
  object WithTheme {
    
    @scala.inline
    def apply(theme: String): WithTheme = {
      val __obj = js.Dynamic.literal(theme = theme.asInstanceOf[js.Any])
      __obj.asInstanceOf[WithTheme]
    }
    
    @scala.inline
    implicit class WithThemeMutableBuilder[Self <: WithTheme] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setInnerRef(value: Ref[js.Any] | RefObject[js.Any]): Self = StObject.set(x, "innerRef", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setInnerRefUndefined: Self = StObject.set(x, "innerRef", js.undefined)
      
      @scala.inline
      def setTheme(value: String): Self = StObject.set(x, "theme", value.asInstanceOf[js.Any])
    }
  }
}
