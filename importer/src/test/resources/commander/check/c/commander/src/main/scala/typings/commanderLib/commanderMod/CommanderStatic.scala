package typings
package commanderLib.commanderMod

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait CommanderStatic
  extends commanderLib.commanderMod.localNs.Command {
  var Command: Instantiable1[js.UndefOr[/* name */ String], commanderLib.commanderMod.localNs.Command] = js.native
  var CommandOptions: commanderLib.commanderMod.CommandOptions = js.native
  var Option: Instantiable2[
    /* flags */ String, 
    js.UndefOr[/* description */ String], 
    commanderLib.commanderMod.localNs.Option
  ] = js.native
  var ParseOptionsResult: commanderLib.commanderMod.ParseOptionsResult = js.native
}

