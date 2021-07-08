package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

//
// Factories
// ----------------------------------------------------------------------
@js.native
trait Factory[P] extends StObject {
  
  def apply(props: Attributes & P, children: Node*): Element = js.native
  def apply(props: Unit, children: Node*): Element = js.native
}
