package typings.reactDashDropzone.reactDashDropzoneMod

import typings.react.reactMod.DragEvent
import typings.react.reactMod.DragEventHandler
import typings.std.HTMLElement
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
    getFilesFromEvent: /* event */ DropEvent => /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ _ = null,
    maxSize: Int | Double = null,
    minSize: Int | Double = null,
    multiple: js.UndefOr[Boolean] = js.undefined,
    noClick: js.UndefOr[Boolean] = js.undefined,
    noDrag: js.UndefOr[Boolean] = js.undefined,
    noDragEventsBubbling: js.UndefOr[Boolean] = js.undefined,
    noKeyboard: js.UndefOr[Boolean] = js.undefined,
    onDragEnter: DragEvent[HTMLElement] => Unit = null,
    onDragLeave: DragEvent[HTMLElement] => Unit = null,
    onDragOver: DragEvent[HTMLElement] => Unit = null,
    onDrop: (/* acceptedFiles */ js.Array[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
    ], /* rejectedFiles */ js.Array[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
    ], /* event */ DropEvent) => Unit = null,
    onDropAccepted: (/* files */ js.Array[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
    ], /* event */ DropEvent) => Unit = null,
    onDropRejected: (/* files */ js.Array[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ _
    ], /* event */ DropEvent) => Unit = null,
    onFileDialogCancel: () => Unit = null,
    preventDropOnDocument: js.UndefOr[Boolean] = js.undefined
  ): DropzoneOptions = {
    val __obj = js.Dynamic.literal()
    if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (getFilesFromEvent != null) __obj.updateDynamic("getFilesFromEvent")(js.Any.fromFunction1(getFilesFromEvent))
    if (maxSize != null) __obj.updateDynamic("maxSize")(maxSize.asInstanceOf[js.Any])
    if (minSize != null) __obj.updateDynamic("minSize")(minSize.asInstanceOf[js.Any])
    if (!js.isUndefined(multiple)) __obj.updateDynamic("multiple")(multiple)
    if (!js.isUndefined(noClick)) __obj.updateDynamic("noClick")(noClick)
    if (!js.isUndefined(noDrag)) __obj.updateDynamic("noDrag")(noDrag)
    if (!js.isUndefined(noDragEventsBubbling)) __obj.updateDynamic("noDragEventsBubbling")(noDragEventsBubbling)
    if (!js.isUndefined(noKeyboard)) __obj.updateDynamic("noKeyboard")(noKeyboard)
    if (onDragEnter != null) __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1(onDragEnter))
    if (onDragLeave != null) __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1(onDragLeave))
    if (onDragOver != null) __obj.updateDynamic("onDragOver")(js.Any.fromFunction1(onDragOver))
    if (onDrop != null) __obj.updateDynamic("onDrop")(js.Any.fromFunction3(onDrop))
    if (onDropAccepted != null) __obj.updateDynamic("onDropAccepted")(js.Any.fromFunction2(onDropAccepted))
    if (onDropRejected != null) __obj.updateDynamic("onDropRejected")(js.Any.fromFunction2(onDropRejected))
    if (onFileDialogCancel != null) __obj.updateDynamic("onFileDialogCancel")(js.Any.fromFunction0(onFileDialogCancel))
    if (!js.isUndefined(preventDropOnDocument)) __obj.updateDynamic("preventDropOnDocument")(preventDropOnDocument)
    __obj.asInstanceOf[DropzoneOptions]
  }
}

