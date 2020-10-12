package typingsSlinky.reactDropzone

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.Event
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.HTMLInputElement
import slinky.core.facade.ReactElement
import slinky.core.facade.ReactRef
import typingsSlinky.react.mod.ChangeEvent
import typingsSlinky.react.mod.DragEvent
import typingsSlinky.react.mod.DragEventHandler
import typingsSlinky.react.mod.HTMLAttributes
import typingsSlinky.react.mod.InputHTMLAttributes
import typingsSlinky.react.mod.RefAttributes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("react-dropzone", JSImport.Default)
  @js.native
  def default(props: DropzoneProps with RefAttributes[DropzoneRef]): ReactElement = js.native
  
  @JSImport("react-dropzone", "useDropzone")
  @js.native
  def useDropzone(): DropzoneState = js.native
  @JSImport("react-dropzone", "useDropzone")
  @js.native
  def useDropzone(options: DropzoneOptions): DropzoneState = js.native
  
  @js.native
  trait DropzoneInputProps extends InputHTMLAttributes[HTMLInputElement] {
    
    var refKey: js.UndefOr[String] = js.native
  }
  object DropzoneInputProps {
    
    @scala.inline
    def apply(): DropzoneInputProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DropzoneInputProps]
    }
    
    @scala.inline
    implicit class DropzoneInputPropsOps[Self <: DropzoneInputProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setRefKey(value: String): Self = this.set("refKey", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteRefKey: Self = this.set("refKey", js.undefined)
    }
  }
  
  /* Inlined std.Pick<react.react.HTMLProps<std.HTMLElement>, react-dropzone.react-dropzone.PropTypes> & {  accept :string | std.Array<string> | undefined,   minSize :number | undefined,   maxSize :number | undefined,   preventDropOnDocument :boolean | undefined,   noClick :boolean | undefined,   noKeyboard :boolean | undefined,   noDrag :boolean | undefined,   noDragEventsBubbling :boolean | undefined,   disabled :boolean | undefined,   onDrop :<T extends / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>(acceptedFiles : std.Array<T>, rejectedFiles : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void | undefined,   onDropAccepted :<T extends / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>(files : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void | undefined,   onDropRejected :<T extends / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>(files : std.Array<T>, event : react-dropzone.react-dropzone.DropEvent): void | undefined,   getFilesFromEvent :(event : react-dropzone.react-dropzone.DropEvent): / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> * / any | undefined,   onFileDialogCancel :(): void | undefined} */
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
    def apply(): DropzoneOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DropzoneOptions]
    }
    
    @scala.inline
    implicit class DropzoneOptionsOps[Self <: DropzoneOptions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setAcceptVarargs(value: String*): Self = this.set("accept", js.Array(value :_*))
      
      @scala.inline
      def setAccept(value: String | js.Array[String]): Self = this.set("accept", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteAccept: Self = this.set("accept", js.undefined)
      
      @scala.inline
      def setDisabled(value: Boolean): Self = this.set("disabled", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteDisabled: Self = this.set("disabled", js.undefined)
      
      @scala.inline
      def setGetFilesFromEvent(
        value: /* event */ DropEvent => /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Promise<Array<File | DataTransferItem>> */ _
      ): Self = this.set("getFilesFromEvent", js.Any.fromFunction1(value))
      
      @scala.inline
      def deleteGetFilesFromEvent: Self = this.set("getFilesFromEvent", js.undefined)
      
      @scala.inline
      def setMaxSize(value: Double): Self = this.set("maxSize", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteMaxSize: Self = this.set("maxSize", js.undefined)
      
      @scala.inline
      def setMinSize(value: Double): Self = this.set("minSize", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteMinSize: Self = this.set("minSize", js.undefined)
      
      @scala.inline
      def setMultiple(value: Boolean): Self = this.set("multiple", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteMultiple: Self = this.set("multiple", js.undefined)
      
      @scala.inline
      def setNoClick(value: Boolean): Self = this.set("noClick", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteNoClick: Self = this.set("noClick", js.undefined)
      
      @scala.inline
      def setNoDrag(value: Boolean): Self = this.set("noDrag", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteNoDrag: Self = this.set("noDrag", js.undefined)
      
      @scala.inline
      def setNoDragEventsBubbling(value: Boolean): Self = this.set("noDragEventsBubbling", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteNoDragEventsBubbling: Self = this.set("noDragEventsBubbling", js.undefined)
      
      @scala.inline
      def setNoKeyboard(value: Boolean): Self = this.set("noKeyboard", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteNoKeyboard: Self = this.set("noKeyboard", js.undefined)
      
      @scala.inline
      def setOnDragEnter(value: DragEvent[HTMLElement] => Unit): Self = this.set("onDragEnter", js.Any.fromFunction1(value))
      
      @scala.inline
      def deleteOnDragEnter: Self = this.set("onDragEnter", js.undefined)
      
      @scala.inline
      def setOnDragLeave(value: DragEvent[HTMLElement] => Unit): Self = this.set("onDragLeave", js.Any.fromFunction1(value))
      
      @scala.inline
      def deleteOnDragLeave: Self = this.set("onDragLeave", js.undefined)
      
      @scala.inline
      def setOnDragOver(value: DragEvent[HTMLElement] => Unit): Self = this.set("onDragOver", js.Any.fromFunction1(value))
      
      @scala.inline
      def deleteOnDragOver: Self = this.set("onDragOver", js.undefined)
      
      @scala.inline
      def setOnDrop(
        value: (/* acceptedFiles */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
            ], /* rejectedFiles */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
            ], /* event */ DropEvent) => Unit
      ): Self = this.set("onDrop", js.Any.fromFunction3(value))
      
      @scala.inline
      def deleteOnDrop: Self = this.set("onDrop", js.undefined)
      
      @scala.inline
      def setOnDropAccepted(
        value: (/* files */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
            ], /* event */ DropEvent) => Unit
      ): Self = this.set("onDropAccepted", js.Any.fromFunction2(value))
      
      @scala.inline
      def deleteOnDropAccepted: Self = this.set("onDropAccepted", js.undefined)
      
      @scala.inline
      def setOnDropRejected(
        value: (/* files */ js.Array[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
            ], /* event */ DropEvent) => Unit
      ): Self = this.set("onDropRejected", js.Any.fromFunction2(value))
      
      @scala.inline
      def deleteOnDropRejected: Self = this.set("onDropRejected", js.undefined)
      
      @scala.inline
      def setOnFileDialogCancel(value: () => Unit): Self = this.set("onFileDialogCancel", js.Any.fromFunction0(value))
      
      @scala.inline
      def deleteOnFileDialogCancel: Self = this.set("onFileDialogCancel", js.undefined)
      
      @scala.inline
      def setPreventDropOnDocument(value: Boolean): Self = this.set("preventDropOnDocument", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deletePreventDropOnDocument: Self = this.set("preventDropOnDocument", js.undefined)
    }
  }
  
  @js.native
  trait DropzoneProps extends DropzoneOptions {
    
    var children: js.UndefOr[js.Function1[/* state */ DropzoneState, ReactElement]] = js.native
  }
  object DropzoneProps {
    
    @scala.inline
    def apply(): DropzoneProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DropzoneProps]
    }
    
    @scala.inline
    implicit class DropzonePropsOps[Self <: DropzoneProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setChildren(value: /* state */ DropzoneState => ReactElement): Self = this.set("children", js.Any.fromFunction1(value))
      
      @scala.inline
      def deleteChildren: Self = this.set("children", js.undefined)
    }
  }
  
  @js.native
  trait DropzoneRef extends js.Object {
    
    def open(): Unit = js.native
  }
  object DropzoneRef {
    
    @scala.inline
    def apply(open: () => Unit): DropzoneRef = {
      val __obj = js.Dynamic.literal(open = js.Any.fromFunction0(open))
      __obj.asInstanceOf[DropzoneRef]
    }
    
    @scala.inline
    implicit class DropzoneRefOps[Self <: DropzoneRef] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setOpen(value: () => Unit): Self = this.set("open", js.Any.fromFunction0(value))
    }
  }
  
  @js.native
  trait DropzoneRootProps
    extends HTMLAttributes[HTMLElement]
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
    implicit class DropzoneRootPropsOps[Self <: DropzoneRootProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setRefKey(value: String): Self = this.set("refKey", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteRefKey: Self = this.set("refKey", js.undefined)
    }
  }
  
  /* Inlined react-dropzone.react-dropzone.DropzoneRef & {  isFocused :boolean,   isDragActive :boolean,   isDragAccept :boolean,   isDragReject :boolean,   isFileDialogActive :boolean,   draggedFiles :std.Array</ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>,   acceptedFiles :std.Array</ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>,   rejectedFiles :std.Array</ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>,   rootRef :react.react.RefObject<std.HTMLElement>,   inputRef :react.react.RefObject<std.HTMLInputElement>, getRootProps (props : react-dropzone.react-dropzone.DropzoneRootProps | undefined): react-dropzone.react-dropzone.DropzoneRootProps, getInputProps (props : react-dropzone.react-dropzone.DropzoneInputProps | undefined): react-dropzone.react-dropzone.DropzoneInputProps} */
  @js.native
  trait DropzoneState extends js.Object {
    
    var acceptedFiles: js.Array[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
      ] = js.native
    
    var draggedFiles: js.Array[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
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
    
    def open(): Unit = js.native
    
    var rejectedFiles: js.Array[
        /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
      ] = js.native
    
    var rootRef: ReactRef[HTMLElement] = js.native
  }
  
  /* Rewritten from type alias, can be one of: 
    - typingsSlinky.reactDropzone.reactDropzoneStrings.multiple
    - typingsSlinky.reactDropzone.reactDropzoneStrings.onDragEnter
    - typingsSlinky.reactDropzone.reactDropzoneStrings.onDragOver
    - typingsSlinky.reactDropzone.reactDropzoneStrings.onDragLeave
  */
  trait PropTypes extends js.Object
  object PropTypes {
    
    @scala.inline
    def multiple: typingsSlinky.reactDropzone.reactDropzoneStrings.multiple = "multiple".asInstanceOf[typingsSlinky.reactDropzone.reactDropzoneStrings.multiple]
    
    @scala.inline
    def onDragEnter: typingsSlinky.reactDropzone.reactDropzoneStrings.onDragEnter = "onDragEnter".asInstanceOf[typingsSlinky.reactDropzone.reactDropzoneStrings.onDragEnter]
    
    @scala.inline
    def onDragLeave: typingsSlinky.reactDropzone.reactDropzoneStrings.onDragLeave = "onDragLeave".asInstanceOf[typingsSlinky.reactDropzone.reactDropzoneStrings.onDragLeave]
    
    @scala.inline
    def onDragOver: typingsSlinky.reactDropzone.reactDropzoneStrings.onDragOver = "onDragOver".asInstanceOf[typingsSlinky.reactDropzone.reactDropzoneStrings.onDragOver]
  }
  
  type DropEvent = DragEvent[HTMLElement] | ChangeEvent[HTMLInputElement] | org.scalajs.dom.raw.DragEvent | Event
}
