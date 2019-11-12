package typings.reactDashDropzone.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.ReactDragEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Ref
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLElement
import typings.reactDashDropzone.DropzonePropsRefAttributesDropzoneRef
import typings.reactDashDropzone.reactDashDropzoneMod.DropEvent
import typings.reactDashDropzone.reactDashDropzoneMod.DropzoneState
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactDashDropzone {
  def apply(
    accept: String | js.Array[String] = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    getFilesFromEvent: js.UndefOr[
      /* event */ DropEvent => CallbackTo[
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ _
      ]
    ] = js.undefined,
    maxSize: Int | Double = null,
    minSize: Int | Double = null,
    multiple: js.UndefOr[Boolean] = js.undefined,
    noClick: js.UndefOr[Boolean] = js.undefined,
    noDrag: js.UndefOr[Boolean] = js.undefined,
    noDragEventsBubbling: js.UndefOr[Boolean] = js.undefined,
    noKeyboard: js.UndefOr[Boolean] = js.undefined,
    onDragEnter: js.UndefOr[ReactDragEventFrom[HTMLElement] => Callback] = js.undefined,
    onDragLeave: js.UndefOr[ReactDragEventFrom[HTMLElement] => Callback] = js.undefined,
    onDragOver: js.UndefOr[ReactDragEventFrom[HTMLElement] => Callback] = js.undefined,
    onDrop: js.UndefOr[
      (/* acceptedFiles */ js.Array[
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
      ], /* rejectedFiles */ js.Array[
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
      ], /* event */ DropEvent) => Callback
    ] = js.undefined,
    onDropAccepted: js.UndefOr[
      (/* files */ js.Array[
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
      ], /* event */ DropEvent) => Callback
    ] = js.undefined,
    onDropRejected: js.UndefOr[
      (/* files */ js.Array[
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
      ], /* event */ DropEvent) => Callback
    ] = js.undefined,
    onFileDialogCancel: js.UndefOr[Callback] = js.undefined,
    preventDropOnDocument: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: js.UndefOr[/* state */ DropzoneState => CallbackTo[Element]] = js.undefined
  ): UnmountedWithRoot[
    DropzonePropsRefAttributesDropzoneRef, 
    Ref, 
    Unit, 
    DropzonePropsRefAttributesDropzoneRef
  ] = {
    val __obj = js.Dynamic.literal()
  
      children.foreach(p => __obj.updateDynamic("children")(js.Any.fromFunction1(((t0: /* state */ typings.reactDashDropzone.reactDashDropzoneMod.DropzoneState) => p(t0).runNow()))))
    if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    getFilesFromEvent.foreach(p => __obj.updateDynamic("getFilesFromEvent")(js.Any.fromFunction1(((t0: /* event */ typings.reactDashDropzone.reactDashDropzoneMod.DropEvent) => p(t0).runNow()))))
    if (maxSize != null) __obj.updateDynamic("maxSize")(maxSize.asInstanceOf[js.Any])
    if (minSize != null) __obj.updateDynamic("minSize")(minSize.asInstanceOf[js.Any])
    if (!js.isUndefined(multiple)) __obj.updateDynamic("multiple")(multiple)
    if (!js.isUndefined(noClick)) __obj.updateDynamic("noClick")(noClick)
    if (!js.isUndefined(noDrag)) __obj.updateDynamic("noDrag")(noDrag)
    if (!js.isUndefined(noDragEventsBubbling)) __obj.updateDynamic("noDragEventsBubbling")(noDragEventsBubbling)
    if (!js.isUndefined(noKeyboard)) __obj.updateDynamic("noKeyboard")(noKeyboard)
    onDragEnter.foreach(p => __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLElement]) => p(t0).runNow()))))
    onDragLeave.foreach(p => __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLElement]) => p(t0).runNow()))))
    onDragOver.foreach(p => __obj.updateDynamic("onDragOver")(js.Any.fromFunction1(((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLElement]) => p(t0).runNow()))))
    onDrop.foreach(p => __obj.updateDynamic("onDrop")(js.Any.fromFunction3(((t0: /* acceptedFiles */ js.Array[
  /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _], t1: /* rejectedFiles */ js.Array[
  /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _], t2: /* event */ typings.reactDashDropzone.reactDashDropzoneMod.DropEvent) => p(t0, t1, t2).runNow()))))
    onDropAccepted.foreach(p => __obj.updateDynamic("onDropAccepted")(js.Any.fromFunction2(((t0: /* files */ js.Array[
  /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _], t1: /* event */ typings.reactDashDropzone.reactDashDropzoneMod.DropEvent) => p(t0, t1).runNow()))))
    onDropRejected.foreach(p => __obj.updateDynamic("onDropRejected")(js.Any.fromFunction2(((t0: /* files */ js.Array[
  /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _], t1: /* event */ typings.reactDashDropzone.reactDashDropzoneMod.DropEvent) => p(t0, t1).runNow()))))
    onFileDialogCancel.foreach(p => __obj.updateDynamic("onFileDialogCancel")(js.Any.fromFunction0((() => p.runNow()))))
    if (!js.isUndefined(preventDropOnDocument)) __obj.updateDynamic("preventDropOnDocument")(preventDropOnDocument)
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactDashDropzone.DropzonePropsRefAttributesDropzoneRef, 
  japgolly.scalajs.react.Children.None, 
  japgolly.scalajs.react.raw.React.Ref](typings.reactDashDropzone.reactDashDropzoneMod.default)
    f(__obj.asInstanceOf[typings.reactDashDropzone.DropzonePropsRefAttributesDropzoneRef])
  }
}

