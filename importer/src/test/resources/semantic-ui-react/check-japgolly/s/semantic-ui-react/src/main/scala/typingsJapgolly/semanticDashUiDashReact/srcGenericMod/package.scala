package typingsJapgolly.semanticDashUiDashReact

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object srcGenericMod {
  import typingsJapgolly.react.reactMod.ReactElement
  import typingsJapgolly.react.reactMod.ReactNode
  import typingsJapgolly.react.reactMod.ReactNodeArray
  import typingsJapgolly.react.reactMod.ReactType

  type SemanticShorthandCollection[TProps] = js.Array[SemanticShorthandItem[TProps]]
  type SemanticShorthandContent = ReactNode
  type SemanticShorthandItem[TProps] = ReactNode | TProps | SemanticShorthandItemFunc[TProps]
  type SemanticShorthandItemFunc[TProps] = js.Function3[
    /* component */ ReactType[TProps], 
    /* props */ TProps, 
    /* children */ js.UndefOr[ReactNode | ReactNodeArray], 
    ReactElement | Null
  ]
}
