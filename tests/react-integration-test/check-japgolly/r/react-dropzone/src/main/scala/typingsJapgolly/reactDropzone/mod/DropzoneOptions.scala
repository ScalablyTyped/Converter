package typingsJapgolly.reactDropzone.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.ReactDragEventFrom
import org.scalajs.dom.raw.HTMLElement
import typingsJapgolly.react.mod.DragEventHandler
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Pick<react.react.HTMLProps<std.HTMLElement>, react-dropzone.react-dropzone.PropTypes> & {  accept ? :string | std.Array<string>,   minSize ? :number,   maxSize ? :number,   preventDropOnDocument ? :boolean,   noClick ? :boolean,   noKeyboard ? :boolean,   noDrag ? :boolean,   noDragEventsBubbling ? :boolean,   disabled ? :boolean,   onDrop ? :<T extends / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>(acceptedFiles : std.Array<T>, rejectedFiles : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void,   onDropAccepted ? :<T extends / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>(files : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void,   onDropRejected ? :<T extends / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>(files : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void,   getFilesFromEvent ? :(event : react-dropzone.react-dropzone.DropEvent): / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> * / any,   onFileDialogCancel ? :(): void} */
@js.native
trait DropzoneOptions extends js.Object {
  var accept: js.UndefOr[String | js.Array[String]] = js.native
  var disabled: js.UndefOr[Boolean] = js.native
  var getFilesFromEvent: js.UndefOr[
    js.Function1[
      /* event */ DropEvent, 
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ _
    ]
  ] = js.native
  var maxSize: js.UndefOr[Double] = js.native
  var minSize: js.UndefOr[Double] = js.native
  var multiple: js.UndefOr[Boolean] = js.native
  var noClick: js.UndefOr[Boolean] = js.native
  var noDrag: js.UndefOr[Boolean] = js.native
  var noDragEventsBubbling: js.UndefOr[Boolean] = js.native
  var noKeyboard: js.UndefOr[Boolean] = js.native
  var onDragEnter: js.UndefOr[DragEventHandler[HTMLElement]] = js.native
  var onDragLeave: js.UndefOr[DragEventHandler[HTMLElement]] = js.native
  var onDragOver: js.UndefOr[DragEventHandler[HTMLElement]] = js.native
  var onDrop: js.UndefOr[
    js.Function3[
      /* acceptedFiles */ js.Array[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
      ], 
      /* rejectedFiles */ js.Array[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
      ], 
      /* event */ DropEvent, 
      Unit
    ]
  ] = js.native
  var onDropAccepted: js.UndefOr[
    js.Function2[
      /* files */ js.Array[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
      ], 
      /* event */ DropEvent, 
      Unit
    ]
  ] = js.native
  var onDropRejected: js.UndefOr[
    js.Function2[
      /* files */ js.Array[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
      ], 
      /* event */ DropEvent, 
      Unit
    ]
  ] = js.native
  var onFileDialogCancel: js.UndefOr[js.Function0[Unit]] = js.native
  var preventDropOnDocument: js.UndefOr[Boolean] = js.native
}

object DropzoneOptions {
  @scala.inline
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
    preventDropOnDocument: js.UndefOr[Boolean] = js.undefined
  ): DropzoneOptions = {
    val __obj = js.Dynamic.literal()
    if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled.asInstanceOf[js.Any])
    if (getFilesFromEvent != null) __obj.updateDynamic("getFilesFromEvent")(js.Any.fromFunction1((t0: /* event */ DropEvent) => getFilesFromEvent(t0).runNow()))
    if (maxSize != null) __obj.updateDynamic("maxSize")(maxSize.asInstanceOf[js.Any])
    if (minSize != null) __obj.updateDynamic("minSize")(minSize.asInstanceOf[js.Any])
    if (!js.isUndefined(multiple)) __obj.updateDynamic("multiple")(multiple.asInstanceOf[js.Any])
    if (!js.isUndefined(noClick)) __obj.updateDynamic("noClick")(noClick.asInstanceOf[js.Any])
    if (!js.isUndefined(noDrag)) __obj.updateDynamic("noDrag")(noDrag.asInstanceOf[js.Any])
    if (!js.isUndefined(noDragEventsBubbling)) __obj.updateDynamic("noDragEventsBubbling")(noDragEventsBubbling.asInstanceOf[js.Any])
    if (!js.isUndefined(noKeyboard)) __obj.updateDynamic("noKeyboard")(noKeyboard.asInstanceOf[js.Any])
    if (onDragEnter != null) __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLElement]) => onDragEnter(t0).runNow()))
    if (onDragLeave != null) __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLElement]) => onDragLeave(t0).runNow()))
    if (onDragOver != null) __obj.updateDynamic("onDragOver")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLElement]) => onDragOver(t0).runNow()))
    if (onDrop != null) __obj.updateDynamic("onDrop")(js.Any.fromFunction3((t0: /* acceptedFiles */ js.Array[js.Any], t1: /* rejectedFiles */ js.Array[js.Any], t2: /* event */ DropEvent) => onDrop(t0, t1, t2).runNow()))
    if (onDropAccepted != null) __obj.updateDynamic("onDropAccepted")(js.Any.fromFunction2((t0: /* files */ js.Array[js.Any], t1: /* event */ DropEvent) => onDropAccepted(t0, t1).runNow()))
    if (onDropRejected != null) __obj.updateDynamic("onDropRejected")(js.Any.fromFunction2((t0: /* files */ js.Array[js.Any], t1: /* event */ DropEvent) => onDropRejected(t0, t1).runNow()))
    onFileDialogCancel.foreach(p => __obj.updateDynamic("onFileDialogCancel")(p.toJsFn))
    if (!js.isUndefined(preventDropOnDocument)) __obj.updateDynamic("preventDropOnDocument")(preventDropOnDocument.asInstanceOf[js.Any])
    __obj.asInstanceOf[DropzoneOptions]
  }
  @scala.inline
  implicit class DropzoneOptionsOps[Self <: DropzoneOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAccept(accept: String | js.Array[String]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (accept != null) ret.updateDynamic("accept")(accept.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutAccept: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "accept")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withDisabled(disabled: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(disabled)) ret.updateDynamic("disabled")(disabled.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutDisabled: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "disabled")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withGetFilesFromEvent(getFilesFromEvent: /* event */ DropEvent => CallbackTo[js.Any]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (getFilesFromEvent != null) ret.updateDynamic("getFilesFromEvent")(js.Any.fromFunction1((t0: /* event */ DropEvent) => getFilesFromEvent(t0).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutGetFilesFromEvent: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "getFilesFromEvent")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withMaxSize(maxSize: Int | Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (maxSize != null) ret.updateDynamic("maxSize")(maxSize.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutMaxSize: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "maxSize")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withMinSize(minSize: Int | Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (minSize != null) ret.updateDynamic("minSize")(minSize.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutMinSize: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "minSize")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withMultiple(multiple: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(multiple)) ret.updateDynamic("multiple")(multiple.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutMultiple: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "multiple")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withNoClick(noClick: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(noClick)) ret.updateDynamic("noClick")(noClick.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutNoClick: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "noClick")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withNoDrag(noDrag: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(noDrag)) ret.updateDynamic("noDrag")(noDrag.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutNoDrag: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "noDrag")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withNoDragEventsBubbling(noDragEventsBubbling: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(noDragEventsBubbling)) ret.updateDynamic("noDragEventsBubbling")(noDragEventsBubbling.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutNoDragEventsBubbling: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "noDragEventsBubbling")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withNoKeyboard(noKeyboard: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(noKeyboard)) ret.updateDynamic("noKeyboard")(noKeyboard.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutNoKeyboard: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "noKeyboard")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnDragEnter(onDragEnter: ReactDragEventFrom[HTMLElement] => Callback): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDragEnter != null) ret.updateDynamic("onDragEnter")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLElement]) => onDragEnter(t0).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnDragEnter: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onDragEnter")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnDragLeave(onDragLeave: ReactDragEventFrom[HTMLElement] => Callback): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDragLeave != null) ret.updateDynamic("onDragLeave")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLElement]) => onDragLeave(t0).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnDragLeave: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onDragLeave")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnDragOver(onDragOver: ReactDragEventFrom[HTMLElement] => Callback): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDragOver != null) ret.updateDynamic("onDragOver")(js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLElement]) => onDragOver(t0).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnDragOver: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onDragOver")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnDrop(
      onDrop: (/* acceptedFiles */ js.Array[js.Any], /* rejectedFiles */ js.Array[js.Any], /* event */ DropEvent) => Callback
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDrop != null) ret.updateDynamic("onDrop")(js.Any.fromFunction3((t0: /* acceptedFiles */ js.Array[js.Any], t1: /* rejectedFiles */ js.Array[js.Any], t2: /* event */ DropEvent) => onDrop(t0, t1, t2).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnDrop: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onDrop")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnDropAccepted(onDropAccepted: (/* files */ js.Array[js.Any], /* event */ DropEvent) => Callback): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDropAccepted != null) ret.updateDynamic("onDropAccepted")(js.Any.fromFunction2((t0: /* files */ js.Array[js.Any], t1: /* event */ DropEvent) => onDropAccepted(t0, t1).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnDropAccepted: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onDropAccepted")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnDropRejected(onDropRejected: (/* files */ js.Array[js.Any], /* event */ DropEvent) => Callback): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDropRejected != null) ret.updateDynamic("onDropRejected")(js.Any.fromFunction2((t0: /* files */ js.Array[js.Any], t1: /* event */ DropEvent) => onDropRejected(t0, t1).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnDropRejected: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onDropRejected")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnFileDialogCancel(onFileDialogCancel: js.UndefOr[Callback]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        onFileDialogCancel.foreach(p => ret.updateDynamic("onFileDialogCancel")(p.toJsFn))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnFileDialogCancel: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onFileDialogCancel")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPreventDropOnDocument(preventDropOnDocument: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(preventDropOnDocument)) ret.updateDynamic("preventDropOnDocument")(preventDropOnDocument.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutPreventDropOnDocument: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "preventDropOnDocument")
        ret.asInstanceOf[Self]
    }
  }
  
}

