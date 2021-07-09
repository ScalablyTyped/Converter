package typingsJapgolly.reactDropzone.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactDragEventFrom
import org.scalajs.dom.raw.HTMLElement
import typingsJapgolly.StBuildingComponent
import typingsJapgolly.react.mod.RefAttributes
import typingsJapgolly.react.mod.global.JSX.Element
import typingsJapgolly.reactDropzone.mod.DropEvent
import typingsJapgolly.reactDropzone.mod.DropzoneProps
import typingsJapgolly.reactDropzone.mod.DropzoneRef
import typingsJapgolly.reactDropzone.mod.DropzoneState
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ReactDropzone {
  
  @JSImport("react-dropzone", JSImport.Default)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[DropzoneRef] {
    
    @scala.inline
    def accept(value: String | js.Array[String]): this.type = set("accept", value.asInstanceOf[js.Any])
    
    @scala.inline
    def acceptVarargs(value: String*): this.type = set("accept", js.Array(value :_*))
    
    @scala.inline
    def children(value: /* state */ DropzoneState => Element): this.type = set("children", js.Any.fromFunction1(value))
    
    @scala.inline
    def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
    
    @scala.inline
    def getFilesFromEvent(
      value: /* event */ DropEvent => /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ js.Any
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
    def onDragEnter(value: ReactDragEventFrom[HTMLElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onDragEnter", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onDragLeave(value: ReactDragEventFrom[HTMLElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onDragLeave", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onDragOver(value: ReactDragEventFrom[HTMLElement & org.scalajs.dom.raw.Element] => Callback): this.type = set("onDragOver", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLElement & org.scalajs.dom.raw.Element]) => value(t0).runNow()))
    
    @scala.inline
    def onDrop(
      value: (/* acceptedFiles */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
        ], /* rejectedFiles */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
        ], /* event */ DropEvent) => Callback
    ): this.type = set("onDrop", js.Any.fromFunction3((t0: /* acceptedFiles */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
        ], t1: /* rejectedFiles */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
        ], t2: /* event */ DropEvent) => (value(t0, t1, t2)).runNow()))
    
    @scala.inline
    def onDropAccepted(
      value: (/* files */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
        ], /* event */ DropEvent) => Callback
    ): this.type = set("onDropAccepted", js.Any.fromFunction2((t0: /* files */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
        ], t1: /* event */ DropEvent) => (value(t0, t1)).runNow()))
    
    @scala.inline
    def onDropRejected(
      value: (/* files */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
        ], /* event */ DropEvent) => Callback
    ): this.type = set("onDropRejected", js.Any.fromFunction2((t0: /* files */ js.Array[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
        ], t1: /* event */ DropEvent) => (value(t0, t1)).runNow()))
    
    @scala.inline
    def onFileDialogCancel(value: Callback): this.type = set("onFileDialogCancel", value.toJsFn)
    
    @scala.inline
    def preventDropOnDocument(value: Boolean): this.type = set("preventDropOnDocument", value.asInstanceOf[js.Any])
  }
  
  implicit def make(companion: ReactDropzone.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: DropzoneProps & RefAttributes[DropzoneRef]): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
