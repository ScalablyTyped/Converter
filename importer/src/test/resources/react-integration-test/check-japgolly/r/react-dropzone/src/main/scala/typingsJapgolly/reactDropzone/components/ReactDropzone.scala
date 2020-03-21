package typingsJapgolly.reactDropzone.components

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.Js.MountedWithRawType
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.component.Js.UnmountedSimple
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.react.mod.RefAttributes
import typingsJapgolly.reactDropzone.mod.DropzoneProps
import typingsJapgolly.reactDropzone.mod.DropzoneRef
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar. */
object ReactDropzone {
  def apply(
    props: DropzoneProps with RefAttributes[DropzoneRef] with js.Object,
    key: js.UndefOr[Key] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedSimple[
    DropzoneProps with RefAttributes[DropzoneRef] with js.Object, 
    MountedWithRawType[
      DropzoneProps with RefAttributes[DropzoneRef] with js.Object, 
      js.Object, 
      RawMounted[DropzoneProps with RefAttributes[DropzoneRef] with js.Object, js.Object]
    ]
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, props)
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
  
    val f = japgolly.scalajs.react.JsComponent[
  typingsJapgolly.reactDropzone.mod.DropzoneProps with typingsJapgolly.react.mod.RefAttributes[typingsJapgolly.reactDropzone.mod.DropzoneRef] with js.Object, 
  japgolly.scalajs.react.Children.Varargs, 
  js.Object](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.reactDropzone.mod.DropzoneProps with typingsJapgolly.react.mod.RefAttributes[typingsJapgolly.reactDropzone.mod.DropzoneRef] with js.Object])(children: _*)
  }
  @JSImport("react-dropzone", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
}

