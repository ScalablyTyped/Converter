package typings.cldrjs

import typings.cldrjs.mod.CldrFactory
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object eventMod {
  
  @JSImport("cldr/event", JSImport.Namespace)
  @js.native
  val ^ : CldrFactory = js.native
  
  /* Syntax to write `eventMod` instead of `eventMod.^` */
  @scala.inline
  implicit def __is(ignored: eventMod.type): CldrFactory = typings.cldrjs.eventMod.^
}
