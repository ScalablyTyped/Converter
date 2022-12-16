package typingsSlinky.reactDropzone

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.Event
import org.scalajs.dom.HTMLElement
import org.scalajs.dom.HTMLInputElement
import slinky.core.facade.ReactRef
import typingsSlinky.react.mod.ChangeEvent
import typingsSlinky.react.mod.DragEvent
import typingsSlinky.react.mod.DragEventHandler
import typingsSlinky.react.mod.HTMLAttributes
import typingsSlinky.react.mod.InputHTMLAttributes
import typingsSlinky.react.mod.RefAttributes
import typingsSlinky.react.mod.global.JSX.Element
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("react-dropzone", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def default(props: DropzoneProps & RefAttributes[DropzoneRef]): Element = ^.asInstanceOf[js.Dynamic].applyDynamic("default")(props.asInstanceOf[js.Any]).asInstanceOf[Element]
  
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
  
  /* Inlined std.Pick<react.react.HTMLProps<std.HTMLElement>, react-dropzone.react-dropzone.PropTypes> & {  accept :string | std.Array<string> | undefined,   minSize :number | undefined,   maxSize :number | undefined,   preventDropOnDocument :boolean | undefined,   noClick :boolean | undefined,   noKeyboard :boolean | undefined,   noDrag :boolean | undefined,   noDragEventsBubbling :boolean | undefined,   disabled :boolean | undefined,   onDrop :<T extends / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>(acceptedFiles : std.Array<T>, rejectedFiles : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void | undefined,   onDropAccepted :<T extends / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>(files : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void | undefined,   onDropRejected :<T extends / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>(files : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void | undefined,   getFilesFromEvent :(event : react-dropzone.react-dropzone.DropEvent): / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> * / any | undefined,   onFileDialogCancel :(): void | undefined} */
  trait DropzoneOptions extends StObject {
    
    var accept: js.UndefOr[String | js.Array[String]] = js.undefined
    
    var disabled: js.UndefOr[Boolean] = js.undefined
    
    var getFilesFromEvent: js.UndefOr[
        js.Function1[
          /* event */ DropEvent, 
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ Any
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
            /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
          ], 
          /* rejectedFiles */ js.Array[
            /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
          ], 
          /* event */ DropEvent, 
          Unit
        ]
      ] = js.undefined
    
    var onDropAccepted: js.UndefOr[
        js.Function2[
          /* files */ js.Array[
            /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
          ], 
          /* event */ DropEvent, 
          Unit
        ]
      ] = js.undefined
    
    var onDropRejected: js.UndefOr[
        js.Function2[
          /* files */ js.Array[
            /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
          ], 
          /* event */ DropEvent, 
          Unit
        ]
      ] = js.undefined
    
    var onFileDialogCancel: js.UndefOr[js.Function0[Unit]] = js.undefined
    
    var preventDropOnDocument: js.UndefOr[Boolean] = js.undefined
  }
  object DropzoneOptions {
    
    inline def apply(): DropzoneOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DropzoneOptions]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: DropzoneOptions] (val x: Self) extends AnyVal {
      
      inline def setAccept(value: String | js.Array[String]): Self = StObject.set(x, "accept", value.asInstanceOf[js.Any])
      
      inline def setAcceptUndefined: Self = StObject.set(x, "accept", js.undefined)
      
      inline def setAcceptVarargs(value: String*): Self = StObject.set(x, "accept", js.Array(value*))
      
      inline def setDisabled(value: Boolean): Self = StObject.set(x, "disabled", value.asInstanceOf[js.Any])
      
      inline def setDisabledUndefined: Self = StObject.set(x, "disabled", js.undefined)
      
      inline def setGetFilesFromEvent(
        value: /* event */ DropEvent => /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ Any
      ): Self = StObject.set(x, "getFilesFromEvent", js.Any.fromFunction1(value))
      
      inline def setGetFilesFromEventUndefined: Self = StObject.set(x, "getFilesFromEvent", js.undefined)
      
      inline def setMaxSize(value: Double): Self = StObject.set(x, "maxSize", value.asInstanceOf[js.Any])
      
      inline def setMaxSizeUndefined: Self = StObject.set(x, "maxSize", js.undefined)
      
      inline def setMinSize(value: Double): Self = StObject.set(x, "minSize", value.asInstanceOf[js.Any])
      
      inline def setMinSizeUndefined: Self = StObject.set(x, "minSize", js.undefined)
      
      inline def setMultiple(value: Boolean): Self = StObject.set(x, "multiple", value.asInstanceOf[js.Any])
      
      inline def setMultipleUndefined: Self = StObject.set(x, "multiple", js.undefined)
      
      inline def setNoClick(value: Boolean): Self = StObject.set(x, "noClick", value.asInstanceOf[js.Any])
      
      inline def setNoClickUndefined: Self = StObject.set(x, "noClick", js.undefined)
      
      inline def setNoDrag(value: Boolean): Self = StObject.set(x, "noDrag", value.asInstanceOf[js.Any])
      
      inline def setNoDragEventsBubbling(value: Boolean): Self = StObject.set(x, "noDragEventsBubbling", value.asInstanceOf[js.Any])
      
      inline def setNoDragEventsBubblingUndefined: Self = StObject.set(x, "noDragEventsBubbling", js.undefined)
      
      inline def setNoDragUndefined: Self = StObject.set(x, "noDrag", js.undefined)
      
      inline def setNoKeyboard(value: Boolean): Self = StObject.set(x, "noKeyboard", value.asInstanceOf[js.Any])
      
      inline def setNoKeyboardUndefined: Self = StObject.set(x, "noKeyboard", js.undefined)
      
      inline def setOnDragEnter(value: DragEvent[HTMLElement] => Unit): Self = StObject.set(x, "onDragEnter", js.Any.fromFunction1(value))
      
      inline def setOnDragEnterUndefined: Self = StObject.set(x, "onDragEnter", js.undefined)
      
      inline def setOnDragLeave(value: DragEvent[HTMLElement] => Unit): Self = StObject.set(x, "onDragLeave", js.Any.fromFunction1(value))
      
      inline def setOnDragLeaveUndefined: Self = StObject.set(x, "onDragLeave", js.undefined)
      
      inline def setOnDragOver(value: DragEvent[HTMLElement] => Unit): Self = StObject.set(x, "onDragOver", js.Any.fromFunction1(value))
      
      inline def setOnDragOverUndefined: Self = StObject.set(x, "onDragOver", js.undefined)
      
      inline def setOnDrop(
        value: (/* acceptedFiles */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
            ], /* rejectedFiles */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
            ], /* event */ DropEvent) => Unit
      ): Self = StObject.set(x, "onDrop", js.Any.fromFunction3(value))
      
      inline def setOnDropAccepted(
        value: (/* files */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
            ], /* event */ DropEvent) => Unit
      ): Self = StObject.set(x, "onDropAccepted", js.Any.fromFunction2(value))
      
      inline def setOnDropAcceptedUndefined: Self = StObject.set(x, "onDropAccepted", js.undefined)
      
      inline def setOnDropRejected(
        value: (/* files */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ Any
            ], /* event */ DropEvent) => Unit
      ): Self = StObject.set(x, "onDropRejected", js.Any.fromFunction2(value))
      
      inline def setOnDropRejectedUndefined: Self = StObject.set(x, "onDropRejected", js.undefined)
      
      inline def setOnDropUndefined: Self = StObject.set(x, "onDrop", js.undefined)
      
      inline def setOnFileDialogCancel(value: () => Unit): Self = StObject.set(x, "onFileDialogCancel", js.Any.fromFunction0(value))
      
      inline def setOnFileDialogCancelUndefined: Self = StObject.set(x, "onFileDialogCancel", js.undefined)
      
      inline def setPreventDropOnDocument(value: Boolean): Self = StObject.set(x, "preventDropOnDocument", value.asInstanceOf[js.Any])
      
      inline def setPreventDropOnDocumentUndefined: Self = StObject.set(x, "preventDropOnDocument", js.undefined)
    }
  }
  
  trait DropzoneProps
    extends StObject
       with DropzoneOptions {
    
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
    - typingsSlinky.reactDropzone.reactDropzoneStrings.multiple
    - typingsSlinky.reactDropzone.reactDropzoneStrings.onDragEnter
    - typingsSlinky.reactDropzone.reactDropzoneStrings.onDragOver
    - typingsSlinky.reactDropzone.reactDropzoneStrings.onDragLeave
  */
  trait PropTypes extends StObject
  object PropTypes {
    
    inline def multiple: typingsSlinky.reactDropzone.reactDropzoneStrings.multiple = "multiple".asInstanceOf[typingsSlinky.reactDropzone.reactDropzoneStrings.multiple]
    
    inline def onDragEnter: typingsSlinky.reactDropzone.reactDropzoneStrings.onDragEnter = "onDragEnter".asInstanceOf[typingsSlinky.reactDropzone.reactDropzoneStrings.onDragEnter]
    
    inline def onDragLeave: typingsSlinky.reactDropzone.reactDropzoneStrings.onDragLeave = "onDragLeave".asInstanceOf[typingsSlinky.reactDropzone.reactDropzoneStrings.onDragLeave]
    
    inline def onDragOver: typingsSlinky.reactDropzone.reactDropzoneStrings.onDragOver = "onDragOver".asInstanceOf[typingsSlinky.reactDropzone.reactDropzoneStrings.onDragOver]
  }
}
