package typings.semanticUiReact

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object genericMod {
  import typings.react.mod.ReactElement
  import typings.react.mod.ReactNode
  import typings.react.mod.ReactNodeArray
  import typings.react.mod.ReactType

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
