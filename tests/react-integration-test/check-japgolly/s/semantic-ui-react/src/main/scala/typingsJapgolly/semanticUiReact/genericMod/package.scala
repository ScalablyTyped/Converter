package typingsJapgolly.semanticUiReact

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object genericMod {
  type SemanticShorthandCollection[TProps] = js.Array[typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem[TProps]]
  type SemanticShorthandContent = japgolly.scalajs.react.raw.React.Node
  type SemanticShorthandItem[TProps] = japgolly.scalajs.react.raw.React.Node | TProps | typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItemFunc[TProps]
  type SemanticShorthandItemFunc[TProps] = js.Function3[
    /* component */ typingsJapgolly.react.mod.ReactType[TProps], 
    /* props */ TProps, 
    /* children */ js.UndefOr[japgolly.scalajs.react.raw.React.Node | typingsJapgolly.react.mod.ReactNodeArray], 
    japgolly.scalajs.react.raw.React.Element | scala.Null
  ]
}
