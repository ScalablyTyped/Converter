package typings.commander.mod

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait CommanderStatic
  extends typings.commander.mod.local.Command {
  var Command: Instantiable1[/* name */ js.UndefOr[String], typings.commander.mod.local.Command] = js.native
  var CommandOptions: typings.commander.mod.CommandOptions = js.native
  var Option: Instantiable2[
    /* flags */ String, 
    /* description */ js.UndefOr[String], 
    typings.commander.mod.local.Option
  ] = js.native
  var ParseOptionsResult: typings.commander.mod.ParseOptionsResult = js.native
}

