package typings.winston

import typings.winston.configMod.AbstractConfigSetLevels
import typings.winston.configMod.Config
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @js.native
  trait LoggerOptions extends StObject {
    
    var levels: js.UndefOr[AbstractConfigSetLevels] = js.native
  }
  object LoggerOptions {
    
    @scala.inline
    def apply(): LoggerOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[LoggerOptions]
    }
    
    @scala.inline
    implicit class LoggerOptionsMutableBuilder[Self <: LoggerOptions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setLevels(value: AbstractConfigSetLevels): Self = StObject.set(x, "levels", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setLevelsUndefined: Self = StObject.set(x, "levels", js.undefined)
    }
  }
  
  object config {
    
    @JSImport("winston", "config")
    @js.native
    val ^ : Config = js.native
    
    /* Syntax to write `config` instead of `config.^` */
    @scala.inline
    implicit def __is(ignored: config.type): Config = typings.winston.mod.config.^
  }
}
