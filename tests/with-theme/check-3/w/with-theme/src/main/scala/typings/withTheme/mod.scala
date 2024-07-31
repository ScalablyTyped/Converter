package typings.withTheme

import _root_.typings.react.mod.ComponentClass
import _root_.typings.react.mod.ComponentType
import _root_.typings.react.mod.Ref
import _root_.typings.react.mod.RefObject
import _root_.typings.std.Pick
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("with-theme", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def default(): js.Function1[/* component */ ComponentType[Any & WithTheme], ComponentClass[Any]] = ^.asInstanceOf[js.Dynamic].applyDynamic("default")().asInstanceOf[js.Function1[/* component */ ComponentType[Any & WithTheme], ComponentClass[Any]]]
  
  type ConsistentWith[T, U] = Pick[U, /* keyof T */ String]
  
  trait WithTheme extends StObject {
    
    var innerRef: js.UndefOr[Ref[Any] | RefObject[Any]] = js.undefined
    
    var theme: String
  }
  object WithTheme {
    
    inline def apply(theme: String): WithTheme = {
      val __obj = js.Dynamic.literal(theme = theme.asInstanceOf[js.Any])
      __obj.asInstanceOf[WithTheme]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: WithTheme] (val x: Self) extends AnyVal {
      
      inline def setInnerRef(value: Ref[Any] | RefObject[Any]): Self = StObject.set(x, "innerRef", value.asInstanceOf[js.Any])
      
      inline def setInnerRefUndefined: Self = StObject.set(x, "innerRef", js.undefined)
      
      inline def setTheme(value: String): Self = StObject.set(x, "theme", value.asInstanceOf[js.Any])
    }
  }
}
