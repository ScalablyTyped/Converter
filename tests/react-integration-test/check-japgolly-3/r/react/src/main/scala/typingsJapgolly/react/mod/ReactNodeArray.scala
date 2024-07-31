package typingsJapgolly.react.mod

import _root_.typingsJapgolly.std.Array
import japgolly.scalajs.react.facade.React.Node
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/** 
NOTE: Rewritten from type alias:
{{{
type ReactNodeArray = std.Array<react.react.ReactNode>
}}}
to avoid circular code involving: 
- react.react.ReactFragment
- react.react.ReactNode
- react.react.ReactNodeArray
*/
trait ReactNodeArray
  extends StObject
     with Array[Node]
