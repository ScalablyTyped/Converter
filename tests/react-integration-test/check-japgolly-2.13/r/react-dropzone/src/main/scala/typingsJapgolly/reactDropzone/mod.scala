package typingsJapgolly.reactDropzone

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactDragEventFrom
import japgolly.scalajs.react.ReactEventFrom
import japgolly.scalajs.react.raw.React.RefHandle
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.DragEvent
import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.HTMLInputElement
import typingsJapgolly.react.mod.DragEventHandler
import typingsJapgolly.react.mod.HTMLAttributes
import typingsJapgolly.react.mod.InputHTMLAttributes
import typingsJapgolly.react.mod.RefAttributes
import typingsJapgolly.react.mod.global.JSX.Element
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("react-dropzone", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  @scala.inline
  def default(props: DropzoneProps with RefAttributes[DropzoneRef]): Element = ^.asInstanceOf[js.Dynamic].applyDynamic("default")(props.asInstanceOf[js.Any]).asInstanceOf[Element]
  
  @scala.inline
  def useDropzone(): DropzoneState = ^.asInstanceOf[js.Dynamic].applyDynamic("useDropzone")().asInstanceOf[DropzoneState]
  @scala.inline
  def useDropzone(options: DropzoneOptions): DropzoneState = ^.asInstanceOf[js.Dynamic].applyDynamic("useDropzone")(options.asInstanceOf[js.Any]).asInstanceOf[DropzoneState]
  
  type DropEvent = ReactDragEventFrom[HTMLElement] | ReactEventFrom[HTMLInputElement] | DragEvent | Event
  
  @js.native
  trait DropzoneInputProps
    extends StObject
       with InputHTMLAttributes[HTMLInputElement] {
    
    var refKey: js.UndefOr[String] = js.native
  }
  object DropzoneInputProps {
    
    @scala.inline
    def apply(): DropzoneInputProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DropzoneInputProps]
    }
    
    @scala.inline
    implicit class DropzoneInputPropsMutableBuilder[Self <: DropzoneInputProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setRefKey(value: String): Self = StObject.set(x, "refKey", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setRefKeyUndefined: Self = StObject.set(x, "refKey", js.undefined)
    }
  }
  
  /* Inlined std.Pick<react.react.HTMLProps<std.HTMLElement>, react-dropzone.react-dropzone.PropTypes> & {  accept :string | std.Array<string> | undefined,   minSize :number | undefined,   maxSize :number | undefined,   preventDropOnDocument :boolean | undefined,   noClick :boolean | undefined,   noKeyboard :boolean | undefined,   noDrag :boolean | undefined,   noDragEventsBubbling :boolean | undefined,   disabled :boolean | undefined,   onDrop :<T extends / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>(acceptedFiles : std.Array<T>, rejectedFiles : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void | undefined,   onDropAccepted :<T extends / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>(files : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void | undefined,   onDropRejected :<T extends / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>(files : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void | undefined,   getFilesFromEvent :(event : react-dropzone.react-dropzone.DropEvent): / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> * / any | undefined,   onFileDialogCancel :(): void | undefined} */
  @js.native
  trait DropzoneOptions extends StObject {
    
    var accept: js.UndefOr[String | js.Array[String]] = js.native
    
    var disabled: js.UndefOr[Boolean] = js.native
    
    var getFilesFromEvent: js.UndefOr[
        js.Function1[
          /* event */ DropEvent, 
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ js.Any
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
            /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
          ], 
          /* rejectedFiles */ js.Array[
            /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
          ], 
          /* event */ DropEvent, 
          Unit
        ]
      ] = js.native
    
    var onDropAccepted: js.UndefOr[
        js.Function2[
          /* files */ js.Array[
            /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
          ], 
          /* event */ DropEvent, 
          Unit
        ]
      ] = js.native
    
    var onDropRejected: js.UndefOr[
        js.Function2[
          /* files */ js.Array[
            /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
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
    def apply(): DropzoneOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DropzoneOptions]
    }
    
    @scala.inline
    implicit class DropzoneOptionsMutableBuilder[Self <: DropzoneOptions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setAccept(value: String | js.Array[String]): Self = StObject.set(x, "accept", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setAcceptUndefined: Self = StObject.set(x, "accept", js.undefined)
      
      @scala.inline
      def setAcceptVarargs(value: String*): Self = StObject.set(x, "accept", js.Array(value :_*))
      
      @scala.inline
      def setDisabled(value: Boolean): Self = StObject.set(x, "disabled", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setDisabledUndefined: Self = StObject.set(x, "disabled", js.undefined)
      
      @scala.inline
      def setGetFilesFromEvent(
        value: /* event */ DropEvent => /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ js.Any
      ): Self = StObject.set(x, "getFilesFromEvent", js.Any.fromFunction1(value))
      
      @scala.inline
      def setGetFilesFromEventUndefined: Self = StObject.set(x, "getFilesFromEvent", js.undefined)
      
      @scala.inline
      def setMaxSize(value: Double): Self = StObject.set(x, "maxSize", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setMaxSizeUndefined: Self = StObject.set(x, "maxSize", js.undefined)
      
      @scala.inline
      def setMinSize(value: Double): Self = StObject.set(x, "minSize", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setMinSizeUndefined: Self = StObject.set(x, "minSize", js.undefined)
      
      @scala.inline
      def setMultiple(value: Boolean): Self = StObject.set(x, "multiple", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setMultipleUndefined: Self = StObject.set(x, "multiple", js.undefined)
      
      @scala.inline
      def setNoClick(value: Boolean): Self = StObject.set(x, "noClick", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setNoClickUndefined: Self = StObject.set(x, "noClick", js.undefined)
      
      @scala.inline
      def setNoDrag(value: Boolean): Self = StObject.set(x, "noDrag", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setNoDragEventsBubbling(value: Boolean): Self = StObject.set(x, "noDragEventsBubbling", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setNoDragEventsBubblingUndefined: Self = StObject.set(x, "noDragEventsBubbling", js.undefined)
      
      @scala.inline
      def setNoDragUndefined: Self = StObject.set(x, "noDrag", js.undefined)
      
      @scala.inline
      def setNoKeyboard(value: Boolean): Self = StObject.set(x, "noKeyboard", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setNoKeyboardUndefined: Self = StObject.set(x, "noKeyboard", js.undefined)
      
      @scala.inline
      def setOnDragEnter(value: ReactDragEventFrom[HTMLElement with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onDragEnter", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLElement with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
      
      @scala.inline
      def setOnDragEnterUndefined: Self = StObject.set(x, "onDragEnter", js.undefined)
      
      @scala.inline
      def setOnDragLeave(value: ReactDragEventFrom[HTMLElement with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onDragLeave", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLElement with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
      
      @scala.inline
      def setOnDragLeaveUndefined: Self = StObject.set(x, "onDragLeave", js.undefined)
      
      @scala.inline
      def setOnDragOver(value: ReactDragEventFrom[HTMLElement with org.scalajs.dom.raw.Element] => Callback): Self = StObject.set(x, "onDragOver", js.Any.fromFunction1((t0: ReactDragEventFrom[HTMLElement with org.scalajs.dom.raw.Element]) => value(t0).runNow()))
      
      @scala.inline
      def setOnDragOverUndefined: Self = StObject.set(x, "onDragOver", js.undefined)
      
      @scala.inline
      def setOnDrop(
        value: (/* acceptedFiles */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
            ], /* rejectedFiles */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
            ], /* event */ DropEvent) => Callback
      ): Self = StObject.set(x, "onDrop", js.Any.fromFunction3((t0: /* acceptedFiles */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
            ], t1: /* rejectedFiles */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
            ], t2: /* event */ DropEvent) => (value(t0, t1, t2)).runNow()))
      
      @scala.inline
      def setOnDropAccepted(
        value: (/* files */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
            ], /* event */ DropEvent) => Callback
      ): Self = StObject.set(x, "onDropAccepted", js.Any.fromFunction2((t0: /* files */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
            ], t1: /* event */ DropEvent) => (value(t0, t1)).runNow()))
      
      @scala.inline
      def setOnDropAcceptedUndefined: Self = StObject.set(x, "onDropAccepted", js.undefined)
      
      @scala.inline
      def setOnDropRejected(
        value: (/* files */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
            ], /* event */ DropEvent) => Callback
      ): Self = StObject.set(x, "onDropRejected", js.Any.fromFunction2((t0: /* files */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
            ], t1: /* event */ DropEvent) => (value(t0, t1)).runNow()))
      
      @scala.inline
      def setOnDropRejectedUndefined: Self = StObject.set(x, "onDropRejected", js.undefined)
      
      @scala.inline
      def setOnDropUndefined: Self = StObject.set(x, "onDrop", js.undefined)
      
      @scala.inline
      def setOnFileDialogCancel(value: Callback): Self = StObject.set(x, "onFileDialogCancel", value.toJsFn)
      
      @scala.inline
      def setOnFileDialogCancelUndefined: Self = StObject.set(x, "onFileDialogCancel", js.undefined)
      
      @scala.inline
      def setPreventDropOnDocument(value: Boolean): Self = StObject.set(x, "preventDropOnDocument", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPreventDropOnDocumentUndefined: Self = StObject.set(x, "preventDropOnDocument", js.undefined)
    }
  }
  
  @js.native
  trait DropzoneProps
    extends StObject
       with DropzoneOptions {
    
    var children: js.UndefOr[js.Function1[/* state */ DropzoneState, Element]] = js.native
  }
  object DropzoneProps {
    
    @scala.inline
    def apply(): DropzoneProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DropzoneProps]
    }
    
    @scala.inline
    implicit class DropzonePropsMutableBuilder[Self <: DropzoneProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setChildren(value: /* state */ DropzoneState => Element): Self = StObject.set(x, "children", js.Any.fromFunction1(value))
      
      @scala.inline
      def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
    }
  }
  
  @js.native
  trait DropzoneRef extends StObject {
    
    def open(): Unit = js.native
  }
  object DropzoneRef {
    
    @scala.inline
    def apply(open: Callback): DropzoneRef = {
      val __obj = js.Dynamic.literal(open = open.toJsFn)
      __obj.asInstanceOf[DropzoneRef]
    }
    
    @scala.inline
    implicit class DropzoneRefMutableBuilder[Self <: DropzoneRef] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setOpen(value: Callback): Self = StObject.set(x, "open", value.toJsFn)
    }
  }
  
  @js.native
  trait DropzoneRootProps
    extends StObject
       with HTMLAttributes[HTMLElement]
       with /* key */ StringDictionary[js.Any] {
    
    var refKey: js.UndefOr[String] = js.native
  }
  object DropzoneRootProps {
    
    @scala.inline
    def apply(): DropzoneRootProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DropzoneRootProps]
    }
    
    @scala.inline
    implicit class DropzoneRootPropsMutableBuilder[Self <: DropzoneRootProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setRefKey(value: String): Self = StObject.set(x, "refKey", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setRefKeyUndefined: Self = StObject.set(x, "refKey", js.undefined)
    }
  }
  
  @js.native
  trait DropzoneState
    extends StObject
       with DropzoneRef {
    
    var acceptedFiles: js.Array[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
      ] = js.native
    
    var draggedFiles: js.Array[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
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
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ js.Any
      ] = js.native
    
    var rootRef: RefHandle[HTMLElement] = js.native
  }
  
  /* Rewritten from type alias, can be one of: 
    - typingsJapgolly.reactDropzone.reactDropzoneStrings.multiple
    - typingsJapgolly.reactDropzone.reactDropzoneStrings.onDragEnter
    - typingsJapgolly.reactDropzone.reactDropzoneStrings.onDragOver
    - typingsJapgolly.reactDropzone.reactDropzoneStrings.onDragLeave
  */
  trait PropTypes extends StObject
  object PropTypes {
    
    @scala.inline
    def multiple: typingsJapgolly.reactDropzone.reactDropzoneStrings.multiple = "multiple".asInstanceOf[typingsJapgolly.reactDropzone.reactDropzoneStrings.multiple]
    
    @scala.inline
    def onDragEnter: typingsJapgolly.reactDropzone.reactDropzoneStrings.onDragEnter = "onDragEnter".asInstanceOf[typingsJapgolly.reactDropzone.reactDropzoneStrings.onDragEnter]
    
    @scala.inline
    def onDragLeave: typingsJapgolly.reactDropzone.reactDropzoneStrings.onDragLeave = "onDragLeave".asInstanceOf[typingsJapgolly.reactDropzone.reactDropzoneStrings.onDragLeave]
    
    @scala.inline
    def onDragOver: typingsJapgolly.reactDropzone.reactDropzoneStrings.onDragOver = "onDragOver".asInstanceOf[typingsJapgolly.reactDropzone.reactDropzoneStrings.onDragOver]
  }
}
