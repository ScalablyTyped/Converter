package typings.react.japgolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import typings.react.reactMod.SuspenseProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Suspense {
  def apply(
    fallback: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any = null,
    key: js.UndefOr[Key] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedSimple[
    SuspenseProps, 
    MountedWithRawType[SuspenseProps, js.Object, RawMounted[SuspenseProps, js.Object]]
  ] = {
    val __obj = js.Dynamic.literal()
  
      if (fallback != null) __obj.updateDynamic("fallback")(fallback)
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
  
    val f = japgolly.scalajs.react.JsComponent[
  typings.react.reactMod.SuspenseProps, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](typings.react.reactMod.Suspense)
    f(__obj.asInstanceOf[typings.react.reactMod.SuspenseProps])(children: _*)
  }
}

