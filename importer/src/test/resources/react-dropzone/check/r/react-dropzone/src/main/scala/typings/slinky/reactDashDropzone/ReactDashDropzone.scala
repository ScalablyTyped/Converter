package typings.slinky.reactDashDropzone

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.react.reactMod.Ref
import typings.reactDashDropzone.DropzonePropsRefAttributesDropzoneRef
import typings.reactDashDropzone.reactDashDropzoneMod.DropEvent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: disabled, multiple, onDragEnter, onDragLeave, onDragOver */
object ReactDashDropzone
  extends ExternalComponentWithAttributesWithRefType[tag.type, Ref[js.Any] with js.Object] {
  override val component: String | js.Object = typings.reactDashDropzone.reactDashDropzoneMod.default.asInstanceOf[String | js.Object]
  def apply(
    accept: String | js.Array[String] = null,
    getFilesFromEvent: /* event */ DropEvent => /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ js.Any = null,
    maxSize: Int | Double = null,
    minSize: Int | Double = null,
    noClick: js.UndefOr[Boolean] = js.undefined,
    noDrag: js.UndefOr[Boolean] = js.undefined,
    noDragEventsBubbling: js.UndefOr[Boolean] = js.undefined,
    noKeyboard: js.UndefOr[Boolean] = js.undefined,
    onDrop: (/* acceptedFiles */ js.Array[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ js.Any
    ], /* rejectedFiles */ js.Array[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ js.Any
    ], /* event */ DropEvent) => Unit = null,
    onDropAccepted: (/* files */ js.Array[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ js.Any
    ], /* event */ DropEvent) => Unit = null,
    onDropRejected: (/* files */ js.Array[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify File */ js.Any
    ], /* event */ DropEvent) => Unit = null,
    onFileDialogCancel: () => Unit = null,
    preventDropOnDocument: js.UndefOr[Boolean] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, Ref[js.Any] with js.Object] = {
    val __obj = js.Dynamic.literal()
    if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
    if (getFilesFromEvent != null) __obj.updateDynamic("getFilesFromEvent")(js.Any.fromFunction1(getFilesFromEvent))
    if (maxSize != null) __obj.updateDynamic("maxSize")(maxSize.asInstanceOf[js.Any])
    if (minSize != null) __obj.updateDynamic("minSize")(minSize.asInstanceOf[js.Any])
    if (!js.isUndefined(noClick)) __obj.updateDynamic("noClick")(noClick)
    if (!js.isUndefined(noDrag)) __obj.updateDynamic("noDrag")(noDrag)
    if (!js.isUndefined(noDragEventsBubbling)) __obj.updateDynamic("noDragEventsBubbling")(noDragEventsBubbling)
    if (!js.isUndefined(noKeyboard)) __obj.updateDynamic("noKeyboard")(noKeyboard)
    if (onDrop != null) __obj.updateDynamic("onDrop")(js.Any.fromFunction3(onDrop))
    if (onDropAccepted != null) __obj.updateDynamic("onDropAccepted")(js.Any.fromFunction2(onDropAccepted))
    if (onDropRejected != null) __obj.updateDynamic("onDropRejected")(js.Any.fromFunction2(onDropRejected))
    if (onFileDialogCancel != null) __obj.updateDynamic("onFileDialogCancel")(js.Any.fromFunction0(onFileDialogCancel))
    if (!js.isUndefined(preventDropOnDocument)) __obj.updateDynamic("preventDropOnDocument")(preventDropOnDocument)
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = DropzonePropsRefAttributesDropzoneRef
}

