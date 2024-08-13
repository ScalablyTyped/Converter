package typingsJapgolly.react.mod

import typingsJapgolly.react.Readonly
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("react", "PureComponent")
@js.native
open class PureComponent[P, S, SS] protected () extends Component[P, S, SS] {
  /**
    * @deprecated
    * @see https://reactjs.org/docs/legacy-context.html
    */
  def this(props: P | Readonly[P]) = this()
  def this(props: P, context: Any) = this()
}
