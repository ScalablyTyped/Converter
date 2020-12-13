package typings.typeMappings

import org.scalablytyped.runtime.Instantiable0
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  @JSGlobal("foo")
  @js.native
  def foo(): Person = js.native
  
  @JSGlobal("newPerson")
  @js.native
  val newPerson: Instantiable0[Person] = js.native
  
  @JSGlobal("proxy")
  @js.native
  val proxy: ProxiedPerson = js.native
  
  /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
  @JSGlobal("newPerson")
  @js.native
  class newPerson () extends Person
}
