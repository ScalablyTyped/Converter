package ScalablyTyped
package WinstonLib.WinstonModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("winston", "winston")
@js.native
object winstonNamespace extends js.Object {
  
  trait LoggerOptions extends js.Object {
    var levels: js.UndefOr[
        WinstonLib.WinstonLibWinstonConfigModule.winstonNamespace.AbstractConfigSetLevels
      ] = js.undefined
  }
  
  val config: WinstonLib.WinstonLibWinstonConfigModule.winstonNamespace.Config = js.native
  @JSName("config")
  @js.native
  object configNamespace extends js.Object {
    @JSName("winston")
    @js.native
    object winstonNamespace extends js.Object {
      
      trait AbstractConfigSetLevels
        extends /* key */ ScalablyTyped.runtime.StringDictionary[scala.Double]
      
      
      trait Config extends js.Object {
        var foo: WinstonLib.WinstonLibStrings.bar
      }
      
    }
    
  }
  
}

