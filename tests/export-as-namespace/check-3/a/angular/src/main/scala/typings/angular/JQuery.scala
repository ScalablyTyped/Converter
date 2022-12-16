package typings.angular

import typings.angular.mod.auto.IInjectorService
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait JQuery extends StObject {
  
  /**
    * Adds the specified class(es) to each of the set of matched elements.
    *
    * @param className One or more space-separated classes to be added to the class attribute of each matched element.
    * @see {@link https://api.jquery.com/addClass/#addClass-className}
    */
  def addClass(className: String): this.type
  
  def injector(): IInjectorService
}
object JQuery {
  
  inline def apply(addClass: String => JQuery, injector: () => IInjectorService): JQuery = {
    val __obj = js.Dynamic.literal(addClass = js.Any.fromFunction1(addClass), injector = js.Any.fromFunction0(injector))
    __obj.asInstanceOf[JQuery]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: JQuery] (val x: Self) extends AnyVal {
    
    inline def setAddClass(value: String => JQuery): Self = StObject.set(x, "addClass", js.Any.fromFunction1(value))
    
    inline def setInjector(value: () => IInjectorService): Self = StObject.set(x, "injector", js.Any.fromFunction0(value))
  }
}
