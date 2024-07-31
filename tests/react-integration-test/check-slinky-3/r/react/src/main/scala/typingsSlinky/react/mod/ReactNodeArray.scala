package typingsSlinky.react.mod

import _root_.typingsSlinky.std.Array
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
     with Array[slinky.core.facade.ReactElement]
