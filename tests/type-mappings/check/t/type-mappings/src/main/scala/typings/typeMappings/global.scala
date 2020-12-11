package typings.typeMappings

import org.scalablytyped.runtime.Instantiable0
import org.scalablytyped.runtime.TopLevel
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSGlobalScope
@js.native
object global extends js.Object {
  
  def foo(): Person = js.native
  
  val proxy: ProxiedPerson = js.native
  
  /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
  @js.native
  class newPerson () extends Person
  @js.native
  object newPerson extends TopLevel[Instantiable0[Person]]
}
