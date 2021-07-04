package typings.angular

import org.scalablytyped.runtime.NumberDictionary
import typings.angular.mod.auto.IInjectorService
import typings.std.HTMLElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait JQLite
  extends StObject
     with JQuery
     with /* index */ NumberDictionary[HTMLElement]
object JQLite {
  
  @scala.inline
  def apply(addClass: String => JQLite, injector: () => IInjectorService): JQLite = {
    val __obj = js.Dynamic.literal(addClass = js.Any.fromFunction1(addClass), injector = js.Any.fromFunction0(injector))
    __obj.asInstanceOf[JQLite]
  }
}
