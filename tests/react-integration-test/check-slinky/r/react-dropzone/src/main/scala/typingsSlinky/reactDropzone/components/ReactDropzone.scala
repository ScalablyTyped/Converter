package typingsSlinky.reactDropzone.components

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLElement
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.core.TagMod
import slinky.web.html.`*`.tag
import typingsSlinky.react.mod.DragEvent
import typingsSlinky.react.mod.RefAttributes
import typingsSlinky.reactDropzone.mod.DropEvent
import typingsSlinky.reactDropzone.mod.DropzoneProps
import typingsSlinky.reactDropzone.mod.DropzoneRef
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactDropzone
  extends ExternalComponentWithAttributesWithRefType[tag.type, js.Any with js.Object] {
  @JSImport("react-dropzone", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
  override val component: String | js.Object = this.componentImport
  /* The following DOM/SVG props were specified: disabled, multiple */
  def apply(
    accept: String | js.Array[String] = null,
    getFilesFromEvent: /* event */ DropEvent => /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ _ = null,
    maxSize: js.UndefOr[Double] = js.undefined,
    minSize: js.UndefOr[Double] = js.undefined,
    noClick: js.UndefOr[Boolean] = js.undefined,
    noDrag: js.UndefOr[Boolean] = js.undefined,
    noDragEventsBubbling: js.UndefOr[Boolean] = js.undefined,
    noKeyboard: js.UndefOr[Boolean] = js.undefined,
    onDragEnter: DragEvent[HTMLElement] => Unit = null,
    onDragLeave: DragEvent[HTMLElement] => Unit = null,
    onDragOver: DragEvent[HTMLElement] => Unit = null,
    onDrop: (/* acceptedFiles */ js.Array[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
    ], /* rejectedFiles */ js.Array[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
    ], /* event */ DropEvent) => Unit = null,
    onDropAccepted: (/* files */ js.Array[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
    ], /* event */ DropEvent) => Unit = null,
    onDropRejected: (/* files */ js.Array[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
    ], /* event */ DropEvent) => Unit = null,
    onFileDialogCancel: () => Unit = null,
    preventDropOnDocument: js.UndefOr[Boolean] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, js.Any with js.Object] = {
    val __obj = js.Dynamic.literal()
    if (accept != null) __obj.updateDynamic("accept")(accept.asInstanceOf[js.Any])
    if (getFilesFromEvent != null) __obj.updateDynamic("getFilesFromEvent")(js.Any.fromFunction1(getFilesFromEvent))
    if (!js.isUndefined(maxSize)) __obj.updateDynamic("maxSize")(maxSize.get.asInstanceOf[js.Any])
    if (!js.isUndefined(minSize)) __obj.updateDynamic("minSize")(minSize.get.asInstanceOf[js.Any])
    if (!js.isUndefined(noClick)) __obj.updateDynamic("noClick")(noClick.get.asInstanceOf[js.Any])
    if (!js.isUndefined(noDrag)) __obj.updateDynamic("noDrag")(noDrag.get.asInstanceOf[js.Any])
    if (!js.isUndefined(noDragEventsBubbling)) __obj.updateDynamic("noDragEventsBubbling")(noDragEventsBubbling.get.asInstanceOf[js.Any])
    if (!js.isUndefined(noKeyboard)) __obj.updateDynamic("noKeyboard")(noKeyboard.get.asInstanceOf[js.Any])
    if (onDragEnter != null) __obj.updateDynamic("onDragEnter")(js.Any.fromFunction1(onDragEnter))
    if (onDragLeave != null) __obj.updateDynamic("onDragLeave")(js.Any.fromFunction1(onDragLeave))
    if (onDragOver != null) __obj.updateDynamic("onDragOver")(js.Any.fromFunction1(onDragOver))
    if (onDrop != null) __obj.updateDynamic("onDrop")(js.Any.fromFunction3(onDrop))
    if (onDropAccepted != null) __obj.updateDynamic("onDropAccepted")(js.Any.fromFunction2(onDropAccepted))
    if (onDropRejected != null) __obj.updateDynamic("onDropRejected")(js.Any.fromFunction2(onDropRejected))
    if (onFileDialogCancel != null) __obj.updateDynamic("onFileDialogCancel")(js.Any.fromFunction0(onFileDialogCancel))
    if (!js.isUndefined(preventDropOnDocument)) __obj.updateDynamic("preventDropOnDocument")(preventDropOnDocument.get.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  def apply(mods: TagMod[tag.type]*): BuildingComponent[tag.type, js.Any with js.Object] = new BuildingComponent[tag.type, js.Any with js.Object](js.Array(component.asInstanceOf[js.Any], js.Dictionary.empty)).apply(mods :_*)
  type Props = DropzoneProps with RefAttributes[DropzoneRef]
}

