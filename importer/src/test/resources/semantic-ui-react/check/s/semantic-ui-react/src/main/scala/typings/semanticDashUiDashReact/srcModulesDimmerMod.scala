package typings.semanticDashUiDashReact

import org.scalablytyped.runtime.TopLevel
import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticDashUiDashReact.srcModulesDimmerDimmerMod.DimmerComponent
import typings.semanticDashUiDashReact.srcModulesDimmerDimmerMod.DimmerProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Dimmer", JSImport.Namespace)
@js.native
object srcModulesDimmerMod extends js.Object {
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
      extends typings.semanticDashUiDashReact.srcModulesDimmerDimmerInnerMod.default
    
  }
  
}

