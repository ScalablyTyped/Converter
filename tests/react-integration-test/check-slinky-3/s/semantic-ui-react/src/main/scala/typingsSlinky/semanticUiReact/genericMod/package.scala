package typingsSlinky.semanticUiReact.genericMod

import slinky.core.facade.ReactElement
import typingsSlinky.react.mod.ReactNodeArray
import typingsSlinky.react.mod.ReactType
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}


type SemanticShorthandCollection[TProps] = js.Array[SemanticShorthandItem[TProps]]

type SemanticShorthandContent = ReactElement

type SemanticShorthandItem[TProps] = ReactElement | TProps | SemanticShorthandItemFunc[TProps]

type SemanticShorthandItemFunc[TProps] = js.Function3[
/* component */ ReactType[TProps], 
/* props */ TProps, 
/* children */ js.UndefOr[ReactElement | ReactNodeArray], 
ReactElement | Null]
