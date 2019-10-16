package typings.semanticUiReact

import org.scalablytyped.runtime.TopLevel
import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticUiReact.modulesDimmerDimmerMod.DimmerComponent
import typings.semanticUiReact.modulesDimmerDimmerMod.DimmerProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Dimmer", JSImport.Namespace)
@js.native
object modulesDimmerMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[DimmerProps, ComponentState, js.Any] {
    def this(props: DimmerProps) = this()
    def this(props: DimmerProps, context: js.Any) = this()
  }
  
  @js.native
  object default extends TopLevel[DimmerComponent] {
    @js.native
    class Inner ()
      extends typings.semanticUiReact.modulesDimmerDimmerInnerMod.default
    
  }
  
}

