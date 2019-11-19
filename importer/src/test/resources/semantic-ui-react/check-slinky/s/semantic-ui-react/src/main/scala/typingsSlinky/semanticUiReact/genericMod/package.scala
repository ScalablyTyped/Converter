package typingsSlinky.semanticUiReact

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object genericMod {
  import typingsSlinky.react.reactMod.ReactElement
  import typingsSlinky.react.reactMod.ReactNode
  import typingsSlinky.react.reactMod.ReactNodeArray
  import typingsSlinky.react.reactMod.ReactType

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
