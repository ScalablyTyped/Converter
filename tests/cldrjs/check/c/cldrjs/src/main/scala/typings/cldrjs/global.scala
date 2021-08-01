package typings.cldrjs

import org.scalablytyped.runtime.Shortcut
import typings.cldrjs.mod.CldrFactory
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object Cldr extends Shortcut {
    
    @JSGlobal("Cldr")
    @js.native
    val ^ : CldrFactory = js.native
    
    type _To = CldrFactory
    
    /* This means you don't have to write `^`, but can instead just say `Cldr.foo` */
    override def _to: CldrFactory = ^
  }
}
