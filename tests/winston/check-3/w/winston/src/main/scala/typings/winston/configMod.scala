package typings.winston

import org.scalablytyped.runtime.Shortcut
import org.scalablytyped.runtime.StringDictionary
import typings.winston.winstonStrings.bar
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object configMod extends Shortcut {
  
  @JSImport("winston/lib/winston/config", JSImport.Namespace)
  @js.native
  val ^ : Config = js.native
  
  type AbstractConfigSetLevels = StringDictionary[Double]
  
  @js.native
  trait Config extends StObject {
    
    var foo: bar = js.native
  }
  object Config {
    
    @scala.inline
    def apply(): Config = {
      val __obj = js.Dynamic.literal(foo = "bar")
      __obj.asInstanceOf[Config]
    }
    
    @scala.inline
    implicit class ConfigMutableBuilder[Self <: Config] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setFoo(value: bar): Self = StObject.set(x, "foo", value.asInstanceOf[js.Any])
    }
  }
  
  type _To = Config
  
  /* This means you don't have to write `^`, but can instead just say `configMod.foo` */
  override def _to: Config = ^
}
