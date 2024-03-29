package typings.winston

import typings.winston.libWinstonConfigMod.AbstractConfigSetLevels
import typings.winston.libWinstonConfigMod.Config
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("winston", "config")
  @js.native
  val config: Config = js.native
  
  trait LoggerOptions extends StObject {
    
    var levels: js.UndefOr[AbstractConfigSetLevels] = js.undefined
  }
  object LoggerOptions {
    
    inline def apply(): LoggerOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[LoggerOptions]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: LoggerOptions] (val x: Self) extends AnyVal {
      
      inline def setLevels(value: AbstractConfigSetLevels): Self = StObject.set(x, "levels", value.asInstanceOf[js.Any])
      
      inline def setLevelsUndefined: Self = StObject.set(x, "levels", js.undefined)
    }
  }
}
