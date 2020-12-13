package typings.winston

import org.scalablytyped.runtime.StringDictionary
import typings.winston.winstonStrings.bar
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object configMod {
  
  @JSImport("winston/lib/winston/config", JSImport.Namespace)
  @js.native
  val ^ : Config = js.native
  
  /* Syntax to write `configMod` instead of `configMod.^` */
  @scala.inline
  implicit def __is(ignored: configMod.type): Config = typings.winston.configMod.^
  
  @js.native
  trait Config extends StObject {
    
    var foo: bar = js.native
  }
  object Config {
    
    @scala.inline
    def apply(foo: bar): Config = {
      val __obj = js.Dynamic.literal(foo = foo.asInstanceOf[js.Any])
      __obj.asInstanceOf[Config]
    }
    
    @scala.inline
    implicit class ConfigMutableBuilder[Self <: Config] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setFoo(value: bar): Self = StObject.set(x, "foo", value.asInstanceOf[js.Any])
    }
  }
  
  type AbstractConfigSetLevels = StringDictionary[Double]
}
