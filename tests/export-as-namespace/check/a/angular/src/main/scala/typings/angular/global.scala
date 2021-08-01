package typings.angular

import org.scalablytyped.runtime.Shortcut
import typings.angular.mod.IAngularStatic
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object angular extends Shortcut {
    
    @JSGlobal("angular")
    @js.native
    val ^ : IAngularStatic = js.native
    
    type _To = IAngularStatic
    
    /* This means you don't have to write `^`, but can instead just say `angular.foo` */
    override def _to: IAngularStatic = ^
    
    // Support for painless dependency injection
    object global
  }
  
  object ng extends Shortcut {
    
    @JSGlobal("ng")
    @js.native
    val ^ : IAngularStatic = js.native
    
    type _To = IAngularStatic
    
    /* This means you don't have to write `^`, but can instead just say `ng.foo` */
    override def _to: IAngularStatic = ^
    
    // Support for painless dependency injection
    object global
  }
}
