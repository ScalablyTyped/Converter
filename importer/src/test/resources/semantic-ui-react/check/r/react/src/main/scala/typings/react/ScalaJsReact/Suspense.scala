package typings.react.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.react.reactMod.SuspenseProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Suspense {
  def apply(
    fallback: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any = null
  )(
    
  ): UnmountedWithRoot[SuspenseProps, js.Object, Unit, SuspenseProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type SuspenseType = scala.scalajs.js.Object
  
      if (fallback != null) __obj.updateDynamic("fallback")(fallback)
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, SuspenseType](js.constructorOf[SuspenseType])
  
    f(props)
  }
  type Props = SuspenseProps
}

