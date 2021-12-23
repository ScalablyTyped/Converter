package typingsJapgolly.semanticUiReact.genericMod

import japgolly.scalajs.react.facade.React.Element
import japgolly.scalajs.react.facade.React.Node
import typingsJapgolly.react.mod.ReactNodeArray
import typingsJapgolly.react.mod.ReactType
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}


type SemanticShorthandCollection[TProps] = js.Array[SemanticShorthandItem[TProps]]

type SemanticShorthandContent = Node

type SemanticShorthandItem[TProps] = Node | TProps | SemanticShorthandItemFunc[TProps]

type SemanticShorthandItemFunc[TProps] = js.Function3[
/* component */ ReactType[TProps], 
/* props */ TProps, 
/* children */ js.UndefOr[Node | ReactNodeArray], 
Element | Null]
