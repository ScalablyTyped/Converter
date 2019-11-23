package typingsSlinky.semanticDashUiDashReact

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object srcGenericMod {
  import slinky.core.ReactComponentClass
  import slinky.core.TagMod
  import slinky.core.facade.ReactElement
  import typingsSlinky.react.reactMod.ReactNodeArray

  type SemanticShorthandCollection[TProps] = js.Array[SemanticShorthandItem[TProps]]
  type SemanticShorthandContent = TagMod[Any]
  type SemanticShorthandItem[TProps] = TagMod[Any] | TProps | SemanticShorthandItemFunc[TProps]
  type SemanticShorthandItemFunc[TProps] = js.Function3[
    /* component */ ReactComponentClass[TProps], 
    /* props */ TProps, 
    /* children */ js.UndefOr[TagMod[Any] | ReactNodeArray], 
    ReactElement | Null
  ]
}
