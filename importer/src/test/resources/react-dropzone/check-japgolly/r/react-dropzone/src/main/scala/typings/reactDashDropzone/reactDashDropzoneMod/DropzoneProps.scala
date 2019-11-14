package typings.reactDashDropzone.reactDashDropzoneMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.ReactDragEventFrom
import japgolly.scalajs.react.raw.React.Element
import org.scalajs.dom.raw.HTMLElement
import typings.react.reactMod.DragEventHandler
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined parent react-dropzone.react-dropzone.DropzoneOptions */
trait DropzoneProps extends js.Object {
  var accept: js.UndefOr[String | js.Array[String]] = js.undefined
  var children: js.UndefOr[js.Function1[/* state */ DropzoneState, Element]] = js.undefined
  var disabled: js.UndefOr[Boolean] = js.undefined
  var getFilesFromEvent: js.UndefOr[
    js.Function1[
      /* event */ DropEvent, 
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ _
    ]
  ] = js.undefined
  var maxSize: js.UndefOr[Double] = js.undefined
  var minSize: js.UndefOr[Double] = js.undefined
  var multiple: js.UndefOr[Boolean] = js.undefined
  var noClick: js.UndefOr[Boolean] = js.undefined
  var noDrag: js.UndefOr[Boolean] = js.undefined
  var noDragEventsBubbling: js.UndefOr[Boolean] = js.undefined
  var noKeyboard: js.UndefOr[Boolean] = js.undefined
  var onDragEnter: js.UndefOr[DragEventHandler[HTMLElement]] = js.undefined
  var onDragLeave: js.UndefOr[DragEventHandler[HTMLElement]] = js.undefined
  var onDragOver: js.UndefOr[DragEventHandler[HTMLElement]] = js.undefined
  var onDrop: js.UndefOr[
    js.Function3[
      /* acceptedFiles */ js.Array[
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
      ], 
      /* rejectedFiles */ js.Array[
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
      ], 
      /* event */ DropEvent, 
      Unit
    ]
  ] = js.undefined
  var onDropAccepted: js.UndefOr[
    js.Function2[
      /* files */ js.Array[
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
      ], 
      /* event */ DropEvent, 
      Unit
    ]
  ] = js.undefined
  var onDropRejected: js.UndefOr[
    js.Function2[
      /* files */ js.Array[
        /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
      ], 
      /* event */ DropEvent, 
      Unit
    ]
  ] = js.undefined
  var onFileDialogCancel: js.UndefOr[js.Function0[Unit]] = js.undefined
  var preventDropOnDocument: js.UndefOr[Boolean] = js.undefined
}

object DropzoneProps {
  @scala.inline
  def apply(
    accept: String | js.Array[String] = null,
    children: /* state */ DropzoneState => CallbackTo[Element] = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    getFilesFromEvent: /* event */ DropEvent => CallbackTo[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ _
    ] = null,
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
    onDrop: (/* acceptedFiles */ js.Array[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
    ], /* rejectedFiles */ js.Array[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
    ], /* event */ DropEvent) => Callback = null,
    onDropAccepted: (/* files */ js.Array[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
    ], /* event */ DropEvent) => Callback = null,
    onDropRejected: (/* files */ js.Array[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
    ], /* event */ DropEvent) => Callback = null,
    onFileDialogCancel: js.UndefOr[Callback] = js.undefined,
    preventDropOnDocument: js.UndefOr[Boolean] = js.undefined
  ): DropzoneProps = {
    val __obj = js.Dynamic.literal()
    if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(js.Any.fromFunction1((t0: /* state */ typings.reactDashDropzone.reactDashDropzoneMod.DropzoneState) => children(t0).runNow()))
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (getFilesFromEvent != null) __obj.updateDynamic("getFilesFromEvent")(js.Any.fromFunction1((t0: /* event */ typings.reactDashDropzone.reactDashDropzoneMod.DropEvent) => getFilesFromEvent(t0).runNow()))
    if (maxSize != null) __obj.updateDynamic("maxSize")(maxSize.asInstanceOf[js.Any])
    if (minSize != null) __obj.updateDynamic("minSize")(minSize.asInstanceOf[js.Any])
    if (!js.isUndefined(multiple)) __obj.updateDynamic("multiple")(multiple)
    if (!js.isUndefined(noClick)) __obj.updateDynamic("noClick")(noClick)
    if (!js.isUndefined(noDrag)) __obj.updateDynamic("noDrag")(noDrag)
    if (!js.isUndefined(noDragEventsBubbling)) __obj.updateDynamic("noDragEventsBubbling")(noDragEventsBubbling)
    if (!js.isUndefined(noKeyboard)) __obj.updateDynamic("noKeyboard")(noKeyboard)
    if (onDragEnter != null) __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLElement]) => onDragEnter(t0).runNow()))
    if (onDragLeave != null) __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLElement]) => onDragLeave(t0).runNow()))
    if (onDragOver != null) __obj.updateDynamic("onDragOver")(js.Any.fromFunction1((t0: japgolly.scalajs.react.ReactDragEventFrom[org.scalajs.dom.raw.HTMLElement]) => onDragOver(t0).runNow()))
    if (onDrop != null) __obj.updateDynamic("onDrop")(js.Any.fromFunction3((t0: /* acceptedFiles */ js.Array[
  /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _], t1: /* rejectedFiles */ js.Array[
  /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _], t2: /* event */ typings.reactDashDropzone.reactDashDropzoneMod.DropEvent) => onDrop(t0, t1, t2).runNow()))
    if (onDropAccepted != null) __obj.updateDynamic("onDropAccepted")(js.Any.fromFunction2((t0: /* files */ js.Array[
  /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _], t1: /* event */ typings.reactDashDropzone.reactDashDropzoneMod.DropEvent) => onDropAccepted(t0, t1).runNow()))
    if (onDropRejected != null) __obj.updateDynamic("onDropRejected")(js.Any.fromFunction2((t0: /* files */ js.Array[
  /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _], t1: /* event */ typings.reactDashDropzone.reactDashDropzoneMod.DropEvent) => onDropRejected(t0, t1).runNow()))
    onFileDialogCancel.foreach(p => __obj.updateDynamic("onFileDialogCancel")(p.toJsFn))
    if (!js.isUndefined(preventDropOnDocument)) __obj.updateDynamic("preventDropOnDocument")(preventDropOnDocument)
    __obj.asInstanceOf[DropzoneProps]
  }
}

