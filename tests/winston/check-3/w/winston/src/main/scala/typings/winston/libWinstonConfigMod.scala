package typings.winston

import org.scalablytyped.runtime.Shortcut
import org.scalablytyped.runtime.StringDictionary
import typings.winston.winstonStrings.bar
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object libWinstonConfigMod extends Shortcut {
  
  @JSImport("winston/lib/winston/config", JSImport.Namespace)
  @js.native
  val ^ : Config = js.native
  
  type AbstractConfigSetLevels = StringDictionary[Double]
  
  trait Config extends StObject {
    
    var foo: bar
  }
  object Config {
    
    inline def apply(): Config = {
      val __obj = js.Dynamic.literal(foo = "bar")
      __obj.asInstanceOf[Config]
    }
    
    extension [Self <: Config](x: Self) {
      
      inline def setFoo(value: bar): Self = StObject.set(x, "foo", value.asInstanceOf[js.Any])
    }
  }
  
  type _To = Config
  
  /* This means you don't have to write `^`, but can instead just say `libWinstonConfigMod.foo` */
  override def _to: Config = ^
}
