package typings.winston

import org.scalablytyped.runtime.Shortcut
import org.scalablytyped.runtime.StringDictionary
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object configMod extends Shortcut {
  
  @JSImport("winston/lib/winston/config", JSImport.Namespace)
  @js.native
  val ^ : Config = js.native
  
  type AbstractConfigSetLevels = StringDictionary[Double]
  
  trait Config extends StObject {
    
    var foo: /* scala3 limitation: Should be type 'bar' */ java.lang.String
  }
  object Config {
    
    inline def apply(): Config = {
      val __obj = js.Dynamic.literal(foo = "bar")
      __obj.asInstanceOf[Config]
    }
    
    extension [Self <: Config](x: Self) {
      
      inline def setFoo(value: "bar"): Self = StObject.set(x, "foo", value.asInstanceOf[js.Any])
    }
  }
  
  type _To = Config
  
  /* This means you don't have to write `^`, but can instead just say `configMod.foo` */
  override def _to: Config = ^
}
