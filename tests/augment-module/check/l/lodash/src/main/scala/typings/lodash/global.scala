package typings.lodash

import org.scalablytyped.runtime.Shortcut
import typings.lodash.mod.LoDashStatic
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object _underscore extends Shortcut {
    
    @JSGlobal("_")
    @js.native
    val ^ : LoDashStatic = js.native
    
    type _To = LoDashStatic
    
    /* This means you don't have to write `^`, but can instead just say `_underscore.foo` */
    override def _to: LoDashStatic = ^
    
    // Backward compatibility with --target es5
    object global
  }
}
