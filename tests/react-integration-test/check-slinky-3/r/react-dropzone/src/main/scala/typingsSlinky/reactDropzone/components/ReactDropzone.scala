package typingsSlinky.reactDropzone.components

import _root_.typingsSlinky.StBuildingComponent
import _root_.typingsSlinky.react.mod.DragEvent
import _root_.typingsSlinky.react.mod.RefAttributes
import _root_.typingsSlinky.react.mod.global.JSX.Element
import _root_.typingsSlinky.reactDropzone.mod.DropEvent
import _root_.typingsSlinky.reactDropzone.mod.DropzoneProps
import _root_.typingsSlinky.reactDropzone.mod.DropzoneRef
import _root_.typingsSlinky.reactDropzone.mod.DropzoneState
import org.scalajs.dom.HTMLElement
import slinky.web.html.`*`.tag
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ReactDropzone {
  
  @JSImport("react-dropzone", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  open class Builder (val args: js.Array[Any])
    extends AnyVal
       with StBuildingComponent[tag.type, DropzoneRef] {
    
    inline def accept(value: String | js.Array[String]): this.type = set("accept", value.asInstanceOf[js.Any])
    
    inline def acceptVarargs(value: String*): this.type = set("accept", js.Array(value*))
    
    inline def children(value: /* state */ DropzoneState => Element): this.type = set("children", js.Any.fromFunction1(value))
    
    inline def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    inline def getFilesFromEvent(
      value: /* event */ DropEvent => /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ Any
    ): this.type = set("getFilesFromEvent", js.Any.fromFunction1(value))
    
    inline def maxSize(value: Double): this.type = set("maxSize", value.asInstanceOf[js.Any])
    
    inline def minSize(value: Double): this.type = set("minSize", value.asInstanceOf[js.Any])
    
    inline def multiple(value: Boolean): this.type = set("multiple", value.asInstanceOf[js.Any])
    
    inline def noClick(value: Boolean): this.type = set("noClick", value.asInstanceOf[js.Any])
    
    inline def noDrag(value: Boolean): this.type = set("noDrag", value.asInstanceOf[js.Any])
    
    inline def noDragEventsBubbling(value: Boolean): this.type = set("noDragEventsBubbling", value.asInstanceOf[js.Any])
    
    inline def noKeyboard(value: Boolean): this.type = set("noKeyboard", value.asInstanceOf[js.Any])
    
    inline def onDragEnter(value: DragEvent[HTMLElement] => Unit): this.type = set("onDragEnter", js.Any.fromFunction1(value))
    
    inline def onDragLeave(value: DragEvent[HTMLElement] => Unit): this.type = set("onDragLeave", js.Any.fromFunction1(value))
    
    inline def onDragOver(value: DragEvent[HTMLElement] => Unit): this.type = set("onDragOver", js.Any.fromFunction1(value))
    
    inline def onDrop(
      value: (/* acceptedFiles */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
        ], /* rejectedFiles */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
        ], /* event */ DropEvent) => Unit
    ): this.type = set("onDrop", js.Any.fromFunction3(value))
    
    inline def onDropAccepted(
      value: (/* files */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
        ], /* event */ DropEvent) => Unit
    ): this.type = set("onDropAccepted", js.Any.fromFunction2(value))
    
    inline def onDropRejected(
      value: (/* files */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
        ], /* event */ DropEvent) => Unit
    ): this.type = set("onDropRejected", js.Any.fromFunction2(value))
    
    inline def onFileDialogCancel(value: () => Unit): this.type = set("onFileDialogCancel", js.Any.fromFunction0(value))
    
    inline def preventDropOnDocument(value: Boolean): this.type = set("preventDropOnDocument", value.asInstanceOf[js.Any])
  }
  
  type Props = DropzoneProps & RefAttributes[DropzoneRef]
  
  implicit def make(companion: ReactDropzone.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: DropzoneProps & RefAttributes[DropzoneRef]): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
