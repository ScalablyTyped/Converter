package typingsSlinky.semanticUiReact

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object genericMod {
  type SemanticShorthandCollection[TProps] = js.Array[typingsSlinky.semanticUiReact.genericMod.SemanticShorthandItem[TProps]]
  type SemanticShorthandContent = slinky.core.TagMod[scala.Any]
  type SemanticShorthandItem[TProps] = slinky.core.TagMod[scala.Any] | TProps | typingsSlinky.semanticUiReact.genericMod.SemanticShorthandItemFunc[TProps]
  type SemanticShorthandItemFunc[TProps] = js.Function3[
    /* component */ typingsSlinky.react.mod.ReactType[TProps], 
    /* props */ TProps, 
    /* children */ js.UndefOr[slinky.core.TagMod[scala.Any] | typingsSlinky.react.mod.ReactNodeArray], 
    slinky.core.facade.ReactElement | scala.Null
  ]
}
