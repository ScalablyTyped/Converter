package typings.reactDashDropzone.reactDashDropzoneMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.ReactDragEventFrom
import org.scalajs.dom.raw.HTMLElement
import typings.react.reactMod.DragEventHandler
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Pick<react.react.HTMLProps<std.HTMLElement>, react-dropzone.react-dropzone.PropTypes> & {  accept ? :string | std.Array<string>,   minSize ? :number,   maxSize ? :number,   preventDropOnDocument ? :boolean,   noClick ? :boolean,   noKeyboard ? :boolean,   noDrag ? :boolean,   noDragEventsBubbling ? :boolean,   disabled ? :boolean,   onDrop ? :<T extends / * import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File * / any>(acceptedFiles : std.Array<T>, rejectedFiles : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void,   onDropAccepted ? :<T extends / * import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File * / any>(files : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void,   onDropRejected ? :<T extends / * import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File * / any>(files : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void,   getFilesFromEvent ? :(event : react-dropzone.react-dropzone.DropEvent): / * import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> * / any,   onFileDialogCancel ? :(): void} */
trait DropzoneOptions extends js.Object {
  var accept: js.UndefOr[String | js.Array[String]] = js.undefined
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

object DropzoneOptions {
  @scala.inline
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
    preventDropOnDocument: js.UndefOr[Boolean] = js.undefined
  ): DropzoneOptions = {
    val __obj = js.Dynamic.literal()
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
    __obj.asInstanceOf[DropzoneOptions]
  }
}

