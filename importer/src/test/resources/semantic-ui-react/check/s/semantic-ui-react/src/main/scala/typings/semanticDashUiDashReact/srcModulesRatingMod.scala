package typings.semanticDashUiDashReact

import typings.react.reactMod.Component
import typings.react.reactMod.ComponentState
import typings.semanticDashUiDashReact.srcModulesRatingRatingMod.RatingComponent
import typings.semanticDashUiDashReact.srcModulesRatingRatingMod.RatingProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("semantic-ui-react/src/modules/Rating", JSImport.Namespace)
@js.native
object srcModulesRatingMod extends js.Object {
  @js.native
  class default protected ()
    extends Component[RatingProps, ComponentState, js.Any] {
    def this(props: RatingProps) = this()
    def this(props: RatingProps, context: js.Any) = this()
  }
  
  val default: RatingComponent = js.native
}

