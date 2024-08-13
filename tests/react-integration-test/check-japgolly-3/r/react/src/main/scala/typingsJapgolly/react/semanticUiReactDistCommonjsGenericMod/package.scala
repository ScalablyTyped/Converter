package typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}


type SemanticShorthandCollection[TProps] = js.Array[SemanticShorthandItem[TProps]]

/** 
NOTE: Rewritten from type alias:
{{{
type SemanticShorthandContent = react.react.ReactNode
}}}
to avoid circular code involving: 
- react.react.ReactFragment
- react.react.ReactNode
- react.react.ReactNodeArray
- react.react/semantic-ui-react/dist/commonjs/generic.SemanticShorthandContent
*/
type SemanticShorthandContent = Any

/** 
NOTE: Rewritten from type alias:
{{{
type SemanticShorthandItem = react.react.ReactNode | TProps | react.react/semantic-ui-react/dist/commonjs/generic.SemanticShorthandItemFunc<TProps>
}}}
to avoid circular code involving: 
- react.react.ReactFragment
- react.react.ReactNode
- react.react.ReactNodeArray
- react.react/semantic-ui-react/dist/commonjs/generic.SemanticShorthandCollection
- react.react/semantic-ui-react/dist/commonjs/generic.SemanticShorthandItem
*/
type SemanticShorthandItem[TProps] = Any | TProps | SemanticShorthandItemFunc[TProps]
