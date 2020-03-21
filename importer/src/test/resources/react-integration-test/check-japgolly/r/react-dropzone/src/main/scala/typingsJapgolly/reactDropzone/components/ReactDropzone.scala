package typingsJapgolly.reactDropzone.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.ReactDragEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import japgolly.scalajs.react.raw.React.Ref
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLElement
import typingsJapgolly.react.mod.RefAttributes
import typingsJapgolly.react.mod._Global_.JSX.Element
import typingsJapgolly.reactDropzone.mod.DropEvent
import typingsJapgolly.reactDropzone.mod.DropzoneProps
import typingsJapgolly.reactDropzone.mod.DropzoneRef
import typingsJapgolly.reactDropzone.mod.DropzoneState
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactDropzone {
  def apply(
    accept: String | js.Array[String] = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    getFilesFromEvent: /* event */ DropEvent => CallbackTo[js.Any] = null,
    maxSize: Int | Double = null,
    minSize: Int | Double = null,
    multiple: js.UndefOr[Boolean] = js.undefined,
    noClick: js.UndefOr[Boolean] = js.undefined,
    noDrag: js.UndefOr[Boolean] = js.undefined,
    noDragEventsBubbling: js.UndefOr[Boolean] = js.undefined,
    noKeyboard: js.UndefOr[Boolean] = js.undefined,
    onDragEnter: ReactDragEventFrom[HTMLElement] => Callback = null,
    onDragLeave: ReactDragEventFrom[HTMLElement] => Callback = null,
    onDragOver: ReactDragEventFrom[HTMLElement] => Callback = null,
    onDrop: (/* acceptedFiles */ js.Array[js.Any], /* rejectedFiles */ js.Array[js.Any], /* event */ DropEvent) => Callback = null,
    onDropAccepted: (/* files */ js.Array[js.Any], /* event */ DropEvent) => Callback = null,
    onDropRejected: (/* files */ js.Array[js.Any], /* event */ DropEvent) => Callback = null,
    onFileDialogCancel: js.UndefOr[Callback] = js.undefined,
    preventDropOnDocument: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[Key] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: /* state */ DropzoneState => CallbackTo[Element] = null
  ): UnmountedWithRoot[
    DropzoneProps with RefAttributes[DropzoneRef], 
    Ref, 
    Unit, 
    DropzoneProps with RefAttributes[DropzoneRef]
  ] = {
    val __obj = js.Dynamic.literal()
  
      if (children != null) __obj.updateDynamic("children")(js.Any.fromFunction1((t0: /* state */ typingsJapgolly.reactDropzone.mod.DropzoneState) => children(t0).runNow()))
    if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled.asInstanceOf[js.Any])
    if (getFilesFromEvent != null) __obj.updateDynamic("getFilesFromEvent")(js.Any.fromFunction1((t0: /* event */ typingsJapgolly.reactDropzone.mod.DropEvent) => getFilesFromEvent(t0).runNow()))
    if (maxSize != null) __obj.updateDynamic("maxSize")(maxSize.asInstanceOf[js.Any])
    if (minSize != null) __obj.updateDynamic("minSize")(minSize.asInstanceOf[js.Any])
    if (!js.isUndefined(multiple)) __obj.updateDynamic("multiple")(multiple.asInstanceOf[js.Any])
    if (!js.isUndefined(noClick)) __obj.updateDynamic("noClick")(noClick.asInstanceOf[js.Any])
    if (!js.isUndefined(noDrag)) __obj.updateDynamic("noDrag")(noDrag.asInstanceOf[js.Any])
    if (!js.isUndefined(noDragEventsBubbling)) __obj.updateDynamic("noDragEventsBubbling")(noDragEventsBubbling.asInstanceOf[js.Any])
    if (!js.isUndefined(noKeyboard)) __obj.updateDynamic("noKeyboard")(noKeyboard.asInstanceOf[js.Any])
    if (onDragEnter != null) __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLElement]) => onDragEnter(t0).runNow()))
    if (onDragLeave != null) __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLElement]) => onDragLeave(t0).runNow()))
    if (onDragOver != null) __obj.updateDynamic("onDragOver")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLElement]) => onDragOver(t0).runNow()))
    if (onDrop != null) __obj.updateDynamic("onDrop")(js.Any.fromFunction3((t0: /* acceptedFiles */ js.Array[js.Any], t1: /* rejectedFiles */ js.Array[js.Any], t2: /* event */ typingsJapgolly.reactDropzone.mod.DropEvent) => onDrop(t0, t1, t2).runNow()))
    if (onDropAccepted != null) __obj.updateDynamic("onDropAccepted")(js.Any.fromFunction2((t0: /* files */ js.Array[js.Any], t1: /* event */ typingsJapgolly.reactDropzone.mod.DropEvent) => onDropAccepted(t0, t1).runNow()))
    if (onDropRejected != null) __obj.updateDynamic("onDropRejected")(js.Any.fromFunction2((t0: /* files */ js.Array[js.Any], t1: /* event */ typingsJapgolly.reactDropzone.mod.DropEvent) => onDropRejected(t0, t1).runNow()))
    onFileDialogCancel.foreach(p => __obj.updateDynamic("onFileDialogCancel")(p.toJsFn))
    if (!js.isUndefined(preventDropOnDocument)) __obj.updateDynamic("preventDropOnDocument")(preventDropOnDocument.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.reactDropzone.mod.DropzoneProps with typingsJapgolly.react.mod.RefAttributes[typingsJapgolly.reactDropzone.mod.DropzoneRef], 
  japgolly.scalajs.react.Children.None, 
  japgolly.scalajs.react.raw.React.Ref](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.reactDropzone.mod.DropzoneProps with typingsJapgolly.react.mod.RefAttributes[typingsJapgolly.reactDropzone.mod.DropzoneRef]])
  }
  @JSImport("react-dropzone", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
}

