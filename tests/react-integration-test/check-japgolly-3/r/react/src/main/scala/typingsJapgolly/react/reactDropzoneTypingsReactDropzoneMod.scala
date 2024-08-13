package typingsJapgolly.react

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactDragEventFrom
import japgolly.scalajs.react.ReactEventFrom
import japgolly.scalajs.react.facade.React.Element
import japgolly.scalajs.react.facade.React.RefHandle
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.DragEvent
import org.scalajs.dom.Event
import org.scalajs.dom.HTMLElement
import org.scalajs.dom.HTMLInputElement
import typingsJapgolly.react.anon.Accept
import typingsJapgolly.react.mod.HTMLAttributes
import typingsJapgolly.react.mod.HTMLProps
import typingsJapgolly.react.mod.InputHTMLAttributes
import typingsJapgolly.react.mod.RefAttributes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object reactDropzoneTypingsReactDropzoneMod {
  
  @JSImport("react/react-dropzone/typings/react-dropzone", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def default(props: DropzoneProps & RefAttributes[DropzoneRef]): Element = ^.asInstanceOf[js.Dynamic].applyDynamic("default")(props.asInstanceOf[js.Any]).asInstanceOf[Element]
  
  inline def useDropzone(): DropzoneState = ^.asInstanceOf[js.Dynamic].applyDynamic("useDropzone")().asInstanceOf[DropzoneState]
  inline def useDropzone(options: DropzoneOptions): DropzoneState = ^.asInstanceOf[js.Dynamic].applyDynamic("useDropzone")(options.asInstanceOf[js.Any]).asInstanceOf[DropzoneState]
  
  type DropEvent = ReactDragEventFrom[HTMLElement] | ReactEventFrom[HTMLInputElement] | DragEvent | Event
  
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
    
    var children: js.UndefOr[js.Function1[/* state */ DropzoneState, Element]] = js.undefined
  }
  object DropzoneProps {
    
    inline def apply(): DropzoneProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DropzoneProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: DropzoneProps] (val x: Self) extends AnyVal {
      
      inline def setChildren(value: /* state */ DropzoneState => Element): Self = StObject.set(x, "children", js.Any.fromFunction1(value))
      
      inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
    }
  }
  
  trait DropzoneRef extends StObject {
    
    def open(): Unit
  }
  object DropzoneRef {
    
    inline def apply(open: Callback): DropzoneRef = {
      val __obj = js.Dynamic.literal(open = open.toJsFn)
      __obj.asInstanceOf[DropzoneRef]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: DropzoneRef] (val x: Self) extends AnyVal {
      
      inline def setOpen(value: Callback): Self = StObject.set(x, "open", value.toJsFn)
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
    
    var inputRef: RefHandle[HTMLInputElement] = js.native
    
    var isDragAccept: Boolean = js.native
    
    var isDragActive: Boolean = js.native
    
    var isDragReject: Boolean = js.native
    
    var isFileDialogActive: Boolean = js.native
    
    var isFocused: Boolean = js.native
    
    var rejectedFiles: js.Array[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
      ] = js.native
    
    var rootRef: RefHandle[HTMLElement] = js.native
  }
  
  /* Rewritten from type alias, can be one of: 
    - typingsJapgolly.react.reactStrings.multiple
    - typingsJapgolly.react.reactStrings.onDragEnter
    - typingsJapgolly.react.reactStrings.onDragOver
    - typingsJapgolly.react.reactStrings.onDragLeave
  */
  trait PropTypes extends StObject
  object PropTypes {
    
    inline def multiple: typingsJapgolly.react.reactStrings.multiple = "multiple".asInstanceOf[typingsJapgolly.react.reactStrings.multiple]
    
    inline def onDragEnter: typingsJapgolly.react.reactStrings.onDragEnter = "onDragEnter".asInstanceOf[typingsJapgolly.react.reactStrings.onDragEnter]
    
    inline def onDragLeave: typingsJapgolly.react.reactStrings.onDragLeave = "onDragLeave".asInstanceOf[typingsJapgolly.react.reactStrings.onDragLeave]
    
    inline def onDragOver: typingsJapgolly.react.reactStrings.onDragOver = "onDragOver".asInstanceOf[typingsJapgolly.react.reactStrings.onDragOver]
  }
}
