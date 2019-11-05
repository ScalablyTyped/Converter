package typings.reactDropzone.japgolly

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.ReactDragEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Ref
import org.scalajs.dom.raw.HTMLElement
import typings.reactDropzone.DropzonePropsRefAttributesDropzoneRef
import typings.reactDropzone.reactDropzoneMod.DropEvent
import typings.reactDropzone.reactDropzoneMod.DropzoneState
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactDropzone {
  def apply(
    accept: String | js.Array[String] = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    getFilesFromEvent: js.UndefOr[
      /* event */ DropEvent => CallbackTo[
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ js.Any
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
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ js.Any
      ], /* rejectedFiles */ js.Array[
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ js.Any
      ], /* event */ DropEvent) => Callback
    ] = js.undefined,
    onDropAccepted: js.UndefOr[
      (/* files */ js.Array[
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ js.Any
      ], /* event */ DropEvent) => Callback
    ] = js.undefined,
    onDropRejected: js.UndefOr[
      (/* files */ js.Array[
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ js.Any
      ], /* event */ DropEvent) => Callback
    ] = js.undefined,
    onFileDialogCancel: js.UndefOr[Callback] = js.undefined,
    preventDropOnDocument: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[Key] = js.undefined
  )(
    children: js.UndefOr[/* state */ DropzoneState => CallbackTo[Element]] = js.undefined
  ): UnmountedWithRoot[
    DropzonePropsRefAttributesDropzoneRef, 
    Ref, 
    Unit, 
    DropzonePropsRefAttributesDropzoneRef
  ] = {
    val __obj = js.Dynamic.literal()
  
      children.foreach(p => __obj.updateDynamic("children")(js.Any.fromFunction1(((t0: /* state */ typings.reactDropzone.reactDropzoneMod.DropzoneState) => p(t0).runNow()))))
    if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    getFilesFromEvent.foreach(p => __obj.updateDynamic("getFilesFromEvent")(js.Any.fromFunction1(((t0: /* event */ typings.reactDropzone.reactDropzoneMod.DropEvent) => p(t0).runNow()))))
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
  /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ js.Any], t1: /* rejectedFiles */ js.Array[
  /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ js.Any], t2: /* event */ typings.reactDropzone.reactDropzoneMod.DropEvent) => p(t0, t1, t2).runNow()))))
    onDropAccepted.foreach(p => __obj.updateDynamic("onDropAccepted")(js.Any.fromFunction2(((t0: /* files */ js.Array[
  /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ js.Any], t1: /* event */ typings.reactDropzone.reactDropzoneMod.DropEvent) => p(t0, t1).runNow()))))
    onDropRejected.foreach(p => __obj.updateDynamic("onDropRejected")(js.Any.fromFunction2(((t0: /* files */ js.Array[
  /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ js.Any], t1: /* event */ typings.reactDropzone.reactDropzoneMod.DropEvent) => p(t0, t1).runNow()))))
    onFileDialogCancel.foreach(p => __obj.updateDynamic("onFileDialogCancel")(js.Any.fromFunction0((() => p.runNow()))))
    if (!js.isUndefined(preventDropOnDocument)) __obj.updateDynamic("preventDropOnDocument")(preventDropOnDocument)
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactDropzone.DropzonePropsRefAttributesDropzoneRef, 
  japgolly.scalajs.react.Children.None, 
  japgolly.scalajs.react.raw.React.Ref](typings.reactDropzone.reactDropzoneMod.default)
    f(__obj.asInstanceOf[typings.reactDropzone.DropzonePropsRefAttributesDropzoneRef])
  }
}

