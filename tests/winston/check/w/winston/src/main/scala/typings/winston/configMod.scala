package typings.winston

import org.scalablytyped.runtime.StringDictionary
import typings.winston.winstonStrings.bar
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
  trait Config extends js.Object {
    
    var foo: bar = js.native
  }
  object Config {
    
    @scala.inline
    def apply(foo: bar): Config = {
      val __obj = js.Dynamic.literal(foo = foo.asInstanceOf[js.Any])
      __obj.asInstanceOf[Config]
    }
    
    @scala.inline
    implicit class ConfigOps[Self <: Config] (val x: Self) extends AnyVal {
      
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
      def setFoo(value: bar): Self = this.set("foo", value.asInstanceOf[js.Any])
    }
  }
  
  type AbstractConfigSetLevels = StringDictionary[Double]
}
