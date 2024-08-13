package typingsSlinky.react

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.Event
import org.scalajs.dom.HTMLElement
import org.scalajs.dom.HTMLInputElement
import slinky.core.facade.ReactElement
import slinky.core.facade.ReactRef
import typingsSlinky.react.anon.Accept
import typingsSlinky.react.mod.ChangeEvent
import typingsSlinky.react.mod.DragEvent
import typingsSlinky.react.mod.HTMLAttributes
import typingsSlinky.react.mod.HTMLProps
import typingsSlinky.react.mod.InputHTMLAttributes
import typingsSlinky.react.mod.RefAttributes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object reactDropzoneTypingsReactDropzoneMod {
  
  @JSImport("react/react-dropzone/typings/react-dropzone", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def default(props: DropzoneProps & RefAttributes[DropzoneRef]): ReactElement = ^.asInstanceOf[js.Dynamic].applyDynamic("default")(props.asInstanceOf[js.Any]).asInstanceOf[ReactElement]
  
  inline def useDropzone(): DropzoneState = ^.asInstanceOf[js.Dynamic].applyDynamic("useDropzone")().asInstanceOf[DropzoneState]
  inline def useDropzone(options: DropzoneOptions): DropzoneState = ^.asInstanceOf[js.Dynamic].applyDynamic("useDropzone")(options.asInstanceOf[js.Any]).asInstanceOf[DropzoneState]
  
  type DropEvent = DragEvent[HTMLElement] | ChangeEvent[HTMLInputElement] | org.scalajs.dom.DragEvent | Event
  
  trait DropzoneInputProps
    extends StObject
       with InputHTMLAttributes[HTMLInputElement] {
    
    var refKey: js.UndefOr[String] = js.undefined
  }
  object DropzoneInputProps {
    
    inline def apply(): DropzoneInputProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DropzoneInputProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: DropzoneInputProps] (val x: Self) extends AnyVal {
      
      inline def setRefKey(value: String): Self = StObject.set(x, "refKey", value.asInstanceOf[js.Any])
      
      inline def setRefKeyUndefined: Self = StObject.set(x, "refKey", js.undefined)
    }
  }
  
  type DropzoneOptions = (Pick[HTMLProps[HTMLElement], PropTypes]) & Accept
  
  /* import warning: RemoveDifficultInheritance.summarizeChanges 
  - Dropped {[ P in react.react/react-dropzone/typings/react-dropzone.PropTypes ]: react.react.HTMLProps<std.HTMLElement>[P]} */ trait DropzoneProps
    extends StObject
       with Accept {
    
    var children: js.UndefOr[js.Function1[/* state */ DropzoneState, ReactElement]] = js.undefined
  }
  object DropzoneProps {
    
    inline def apply(): DropzoneProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DropzoneProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: DropzoneProps] (val x: Self) extends AnyVal {
      
      inline def setChildren(value: /* state */ DropzoneState => ReactElement): Self = StObject.set(x, "children", js.Any.fromFunction1(value))
      
      inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
    }
  }
  
  trait DropzoneRef extends StObject {
    
    def open(): Unit
  }
  object DropzoneRef {
    
    inline def apply(open: () => Unit): DropzoneRef = {
      val __obj = js.Dynamic.literal(open = js.Any.fromFunction0(open))
      __obj.asInstanceOf[DropzoneRef]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: DropzoneRef] (val x: Self) extends AnyVal {
      
      inline def setOpen(value: () => Unit): Self = StObject.set(x, "open", js.Any.fromFunction0(value))
    }
  }
  
  trait DropzoneRootProps
    extends StObject
       with HTMLAttributes[HTMLElement]
       with /* key */ StringDictionary[Any] {
    
    var refKey: js.UndefOr[String] = js.undefined
  }
  object DropzoneRootProps {
    
    inline def apply(): DropzoneRootProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DropzoneRootProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: DropzoneRootProps] (val x: Self) extends AnyVal {
      
      inline def setRefKey(value: String): Self = StObject.set(x, "refKey", value.asInstanceOf[js.Any])
      
      inline def setRefKeyUndefined: Self = StObject.set(x, "refKey", js.undefined)
    }
  }
  
  @js.native
  trait DropzoneState
    extends StObject
       with DropzoneRef {
    
    var acceptedFiles: js.Array[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
      ] = js.native
    
    var draggedFiles: js.Array[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
      ] = js.native
    
    def getInputProps(): DropzoneInputProps = js.native
    def getInputProps(props: DropzoneInputProps): DropzoneInputProps = js.native
    
    def getRootProps(): DropzoneRootProps = js.native
    def getRootProps(props: DropzoneRootProps): DropzoneRootProps = js.native
    
    var inputRef: ReactRef[HTMLInputElement] = js.native
    
    var isDragAccept: Boolean = js.native
    
    var isDragActive: Boolean = js.native
    
    var isDragReject: Boolean = js.native
    
    var isFileDialogActive: Boolean = js.native
    
    var isFocused: Boolean = js.native
    
    var rejectedFiles: js.Array[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
      ] = js.native
    
    var rootRef: ReactRef[HTMLElement] = js.native
  }
  
  /* Rewritten from type alias, can be one of: 
    - typingsSlinky.react.reactStrings.multiple
    - typingsSlinky.react.reactStrings.onDragEnter
    - typingsSlinky.react.reactStrings.onDragOver
    - typingsSlinky.react.reactStrings.onDragLeave
  */
  trait PropTypes extends StObject
  object PropTypes {
    
    inline def multiple: typingsSlinky.react.reactStrings.multiple = "multiple".asInstanceOf[typingsSlinky.react.reactStrings.multiple]
    
    inline def onDragEnter: typingsSlinky.react.reactStrings.onDragEnter = "onDragEnter".asInstanceOf[typingsSlinky.react.reactStrings.onDragEnter]
    
    inline def onDragLeave: typingsSlinky.react.reactStrings.onDragLeave = "onDragLeave".asInstanceOf[typingsSlinky.react.reactStrings.onDragLeave]
    
    inline def onDragOver: typingsSlinky.react.reactStrings.onDragOver = "onDragOver".asInstanceOf[typingsSlinky.react.reactStrings.onDragOver]
  }
}
