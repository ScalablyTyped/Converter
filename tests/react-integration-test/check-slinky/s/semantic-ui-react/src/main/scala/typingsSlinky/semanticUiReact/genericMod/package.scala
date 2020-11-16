package typingsSlinky.semanticUiReact

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object genericMod {
  
  type SemanticShorthandCollection[TProps] = js.Array[typingsSlinky.semanticUiReact.genericMod.SemanticShorthandItem[TProps]]
  
  type SemanticShorthandContent = slinky.core.facade.ReactElement
  
  type SemanticShorthandItem[TProps] = slinky.core.facade.ReactElement | TProps | typingsSlinky.semanticUiReact.genericMod.SemanticShorthandItemFunc[TProps]
  
  type SemanticShorthandItemFunc[TProps] = js.Function3[
    /* component */ typingsSlinky.react.mod.ReactType[TProps], 
    /* props */ TProps, 
    /* children */ js.UndefOr[slinky.core.facade.ReactElement | typingsSlinky.react.mod.ReactNodeArray], 
    slinky.core.facade.ReactElement | scala.Null
  ]
}
