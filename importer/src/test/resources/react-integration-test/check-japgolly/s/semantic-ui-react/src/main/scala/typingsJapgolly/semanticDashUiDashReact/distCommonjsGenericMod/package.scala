package typingsJapgolly.semanticDashUiDashReact

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object distCommonjsGenericMod {
  import japgolly.scalajs.react.raw.React.Element
  import japgolly.scalajs.react.raw.React.Node
  import typingsJapgolly.react.reactMod.ReactNodeArray
  import typingsJapgolly.react.reactMod.ReactType

  type SemanticShorthandCollection[TProps] = js.Array[SemanticShorthandItem[TProps]]
  type SemanticShorthandContent = Node
  type SemanticShorthandItem[TProps] = Node | TProps | SemanticShorthandItemFunc[TProps]
  type SemanticShorthandItemFunc[TProps] = js.Function3[
    /* component */ ReactType[TProps], 
    /* props */ TProps, 
    /* children */ js.UndefOr[Node | ReactNodeArray], 
    Element | Null
  ]
}
