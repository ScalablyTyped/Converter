package typingsJapgolly.semanticUiReact.genericMod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}


type SemanticShorthandCollection[TProps] = js.Array[typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem[TProps]]

type SemanticShorthandContent = japgolly.scalajs.react.facade.React.Node

type SemanticShorthandItem[TProps] = japgolly.scalajs.react.facade.React.Node | TProps | typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItemFunc[TProps]

type SemanticShorthandItemFunc[TProps] = js.Function3[
/* component */ typingsJapgolly.react.mod.ReactType[TProps], 
/* props */ TProps, 
/* children */ js.UndefOr[
  japgolly.scalajs.react.facade.React.Node | typingsJapgolly.react.mod.ReactNodeArray
], 
japgolly.scalajs.react.facade.React.Element | scala.Null]
