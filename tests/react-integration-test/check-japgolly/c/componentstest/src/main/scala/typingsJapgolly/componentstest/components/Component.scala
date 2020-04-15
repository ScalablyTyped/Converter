package typingsJapgolly.componentstest.components

import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.Children.Varargs
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.JsForwardRefComponent.force
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Component {
  def A(
    aMember: Double,
    aCallback: CallbackTo[Double],
    key: js.UndefOr[Key] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    typingsJapgolly.componentstest.mod.A, 
    typingsJapgolly.componentstest.mod.Component, 
    Unit, 
    typingsJapgolly.componentstest.mod.A
  ] = {
    val __obj = js.Dynamic.literal(aMember = aMember.asInstanceOf[js.Any])
    __obj.updateDynamic("aCallback")(aCallback.toJsFn)
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    val f = force[typingsJapgolly.componentstest.mod.A, Varargs, typingsJapgolly.componentstest.mod.Component](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.componentstest.mod.A])(children :_*)
  }
  def B(
    bMember: String,
    bCallback: js.UndefOr[CallbackTo[String]] = js.undefined,
    key: js.UndefOr[Key] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    typingsJapgolly.componentstest.mod.B, 
    typingsJapgolly.componentstest.mod.Component, 
    Unit, 
    typingsJapgolly.componentstest.mod.B
  ] = {
    val __obj = js.Dynamic.literal(bMember = bMember.asInstanceOf[js.Any])
    bCallback.foreach(p => __obj.updateDynamic("bCallback")(p.toJsFn))
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    val f = force[typingsJapgolly.componentstest.mod.B, Varargs, typingsJapgolly.componentstest.mod.Component](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.componentstest.mod.B])(children :_*)
  }
  @JSImport("componentstest", "Component")
  @js.native
  object componentImport extends js.Object
  
}

