package typingsSlinky.reactDropzone.components

import org.scalajs.dom.raw.HTMLElement
import slinky.core.facade.ReactElement
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.react.mod.DragEvent
import typingsSlinky.react.mod.Ref
import typingsSlinky.react.mod.RefAttributes
import typingsSlinky.reactDropzone.mod.DropEvent
import typingsSlinky.reactDropzone.mod.DropzoneProps
import typingsSlinky.reactDropzone.mod.DropzoneRef
import typingsSlinky.reactDropzone.mod.DropzoneState
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactDropzone {
  @JSImport("react-dropzone", JSImport.Default)
  @js.native
  object component extends js.Object
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[tag.type, Ref[js.Any] with js.Object] {
    @scala.inline
    def acceptVarargs(value: String*): this.type = set("accept", js.Array(value :_*))
    @scala.inline
    def accept(value: String | js.Array[String]): this.type = set("accept", value.asInstanceOf[js.Any])
    @scala.inline
    def children(value: /* state */ DropzoneState => ReactElement): this.type = set("children", js.Any.fromFunction1(value))
    @scala.inline
    def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    @scala.inline
    def getFilesFromEvent(
      value: /* event */ DropEvent => /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ _
    ): this.type = set("getFilesFromEvent", js.Any.fromFunction1(value))
    @scala.inline
    def maxSize(value: Double): this.type = set("maxSize", value.asInstanceOf[js.Any])
    @scala.inline
    def minSize(value: Double): this.type = set("minSize", value.asInstanceOf[js.Any])
    @scala.inline
    def multiple(value: Boolean): this.type = set("multiple", value.asInstanceOf[js.Any])
    @scala.inline
    def noClick(value: Boolean): this.type = set("noClick", value.asInstanceOf[js.Any])
    @scala.inline
    def noDrag(value: Boolean): this.type = set("noDrag", value.asInstanceOf[js.Any])
    @scala.inline
    def noDragEventsBubbling(value: Boolean): this.type = set("noDragEventsBubbling", value.asInstanceOf[js.Any])
    @scala.inline
    def noKeyboard(value: Boolean): this.type = set("noKeyboard", value.asInstanceOf[js.Any])
    @scala.inline
    def onDragEnter(value: DragEvent[HTMLElement] => Unit): this.type = set("onDragEnter", js.Any.fromFunction1(value))
    @scala.inline
    def onDragLeave(value: DragEvent[HTMLElement] => Unit): this.type = set("onDragLeave", js.Any.fromFunction1(value))
    @scala.inline
    def onDragOver(value: DragEvent[HTMLElement] => Unit): this.type = set("onDragOver", js.Any.fromFunction1(value))
    @scala.inline
    def onDrop(
      value: (/* acceptedFiles */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
        ], /* rejectedFiles */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
        ], /* event */ DropEvent) => Unit
    ): this.type = set("onDrop", js.Any.fromFunction3(value))
    @scala.inline
    def onDropAccepted(
      value: (/* files */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
        ], /* event */ DropEvent) => Unit
    ): this.type = set("onDropAccepted", js.Any.fromFunction2(value))
    @scala.inline
    def onDropRejected(
      value: (/* files */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
        ], /* event */ DropEvent) => Unit
    ): this.type = set("onDropRejected", js.Any.fromFunction2(value))
    @scala.inline
    def onFileDialogCancel(value: () => Unit): this.type = set("onFileDialogCancel", js.Any.fromFunction0(value))
    @scala.inline
    def preventDropOnDocument(value: Boolean): this.type = set("preventDropOnDocument", value.asInstanceOf[js.Any])
  }
  
  def withProps(p: DropzoneProps with RefAttributes[DropzoneRef]): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: ReactDropzone.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
}

