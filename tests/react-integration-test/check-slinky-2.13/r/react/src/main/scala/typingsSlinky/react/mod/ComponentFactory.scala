package typingsSlinky.react.mod

import slinky.core.ReactComponentClass
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ComponentFactory[P, T /* <: ReactComponentClass[P] */] extends StObject {
  
  def apply(props: ClassAttributes[T] with P, children: slinky.core.facade.ReactElement*): CElement[P, T] = js.native
  def apply(props: Unit, children: slinky.core.facade.ReactElement*): CElement[P, T] = js.native
}
