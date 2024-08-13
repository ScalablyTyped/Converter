package typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod

import japgolly.scalajs.react.facade.React.Element
import japgolly.scalajs.react.facade.React.Node
import typingsJapgolly.react.mod.ReactNodeArray
import typingsJapgolly.react.mod.ReactType
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/** 
NOTE: Rewritten from type alias:
{{{
type SemanticShorthandItemFunc = (component : react.react.ReactType<TProps>, props : TProps, children : react.react.ReactNode | react.react.ReactNodeArray | undefined): react.react.ReactElement | null
}}}
to avoid circular code involving: 
- react.react.ReactFragment
- react.react.ReactNode
- react.react.ReactNodeArray
- react.react/semantic-ui-react/dist/commonjs/generic.SemanticShorthandCollection
- react.react/semantic-ui-react/dist/commonjs/generic.SemanticShorthandItem
- react.react/semantic-ui-react/dist/commonjs/generic.SemanticShorthandItemFunc
*/
@js.native
trait SemanticShorthandItemFunc[TProps] extends StObject {
  
  def apply(component: ReactType[TProps], props: TProps): Element | Null = js.native
  def apply(component: ReactType[TProps], props: TProps, children: Node): Element | Null = js.native
  def apply(component: ReactType[TProps], props: TProps, children: ReactNodeArray): Element | Null = js.native
}
