package typings
package winstonLib.winstonMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("winston", "winston")
@js.native
object winstonNs extends js.Object {
  
  trait LoggerOptions extends js.Object {
    var levels: js.UndefOr[winstonLib.libWinstonConfigMod.winstonNs.AbstractConfigSetLevels] = js.undefined
  }
  
  val config: winstonLib.libWinstonConfigMod.winstonNs.Config = js.native
  @JSName("config")
  @js.native
  object configNs extends js.Object {
    @JSName("winston")
    @js.native
    object winstonNs extends js.Object {
      
      trait AbstractConfigSetLevels
        extends /* key */ org.scalablytyped.runtime.StringDictionary[scala.Double]
      
      
      trait Config extends js.Object {
        var foo: winstonLib.winstonLibStrings.bar
      }
      
    }
    
  }
  
}

