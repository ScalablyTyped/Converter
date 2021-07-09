package typings.typeMappings

import org.scalablytyped.runtime.Instantiable0
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  @scala.inline
  def foo(): Person = js.Dynamic.global.applyDynamic("foo")().asInstanceOf[Person]
  
  /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
  @JSGlobal("newPerson")
  @js.native
  class newPerson ()
    extends StObject
       with Person
  @JSGlobal("newPerson")
  @js.native
  val newPerson: Instantiable0[Person] = js.native
  
  @JSGlobal("proxy")
  @js.native
  val proxy: ProxiedPerson = js.native
}
