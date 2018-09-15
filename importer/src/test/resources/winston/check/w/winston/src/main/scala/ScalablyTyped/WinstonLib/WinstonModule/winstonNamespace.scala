package ScalablyTyped
package WinstonLib.WinstonModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("winston", "winston")
@js.native
object winstonNamespace extends js.Object {
  
  trait LoggerOptions extends js.Object {
    val levels: js.UndefOr[WinstonLib.WinstonLibWinstonConfigModule.winstonNamespace.AbstractConfigSetLevels] = js.undefined
  }
  
  @JSName("config")
  @js.native
  object configNamespace extends js.Object {
    var foo: WinstonLib.WinstonLibStrings.bar = js.native
    @JSName("winston")
    @js.native
    object winstonNamespace extends js.Object {
      
      trait AbstractConfigSetLevels extends /* key */ ScalablyTyped.runtime.StringDictionary[scala.Double]
      
      
      trait Config extends js.Object {
        val foo: WinstonLib.WinstonLibStrings.bar
      }
      
    }
    
    type AbstractConfigSetLevels = WinstonLib.WinstonLibWinstonConfigModule.winstonNamespace.AbstractConfigSetLevels
    type Config = WinstonLib.WinstonLibWinstonConfigModule.winstonNamespace.Config
  }
  
}

