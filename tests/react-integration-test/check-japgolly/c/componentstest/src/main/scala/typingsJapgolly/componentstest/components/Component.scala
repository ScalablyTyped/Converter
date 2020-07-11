package typingsJapgolly.componentstest.components

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.Children.Varargs
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.JsComponent
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Component {
  def A(
    aCallback: CallbackTo[Double],
    aMember: Double,
    key: Key = null,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    typingsJapgolly.componentstest.mod.A, 
    MountedWithRawType[
      typingsJapgolly.componentstest.mod.A, 
      js.Object, 
      RawMounted[typingsJapgolly.componentstest.mod.A, js.Object]
    ]
  ] = {
    val __obj = js.Dynamic.literal(aCallback = aCallback.toJsFn, aMember = aMember.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    val f = JsComponent[typingsJapgolly.componentstest.mod.A, Varargs, js.Object](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.componentstest.mod.A])(children :_*)
  }
  def B(
    bMember: String,
    bCallback: js.UndefOr[CallbackTo[String]] = js.undefined,
    key: Key = null,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    typingsJapgolly.componentstest.mod.B, 
    MountedWithRawType[
      typingsJapgolly.componentstest.mod.B, 
      js.Object, 
      RawMounted[typingsJapgolly.componentstest.mod.B, js.Object]
    ]
  ] = {
    val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
    if (!js.isUndefined(bCallback)) __obj.updateDynamic("bCallback")(bCallback.get.toJsFn)
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    val f = JsComponent[typingsJapgolly.componentstest.mod.B, Varargs, js.Object](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.componentstest.mod.B])(children :_*)
  }
  @JSImport("componentstest", "Component")
  @js.native
  object componentImport extends js.Object
  
}

