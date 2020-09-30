package typingsSlinky.reactDropzone.mod

import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.HTMLInputElement
import slinky.core.facade.ReactRef
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inlined react-dropzone.react-dropzone.DropzoneRef & {  isFocused :boolean,   isDragActive :boolean,   isDragAccept :boolean,   isDragReject :boolean,   isFileDialogActive :boolean,   draggedFiles :std.Array</ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>,   acceptedFiles :std.Array</ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>,   rejectedFiles :std.Array</ * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File * / any>,   rootRef :react.react.RefObject<std.HTMLElement>,   inputRef :react.react.RefObject<std.HTMLInputElement>, getRootProps (props : react-dropzone.react-dropzone.DropzoneRootProps | undefined): react-dropzone.react-dropzone.DropzoneRootProps, getInputProps (props : react-dropzone.react-dropzone.DropzoneInputProps | undefined): react-dropzone.react-dropzone.DropzoneInputProps} */
@js.native
trait DropzoneState extends js.Object {
  var acceptedFiles: js.Array[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
  ] = js.native
  var draggedFiles: js.Array[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
  ] = js.native
  var inputRef: ReactRef[HTMLInputElement] = js.native
  var isDragAccept: Boolean = js.native
  var isDragActive: Boolean = js.native
  var isDragReject: Boolean = js.native
  var isFileDialogActive: Boolean = js.native
  var isFocused: Boolean = js.native
  var rejectedFiles: js.Array[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify File */ _
  ] = js.native
  var rootRef: ReactRef[HTMLElement] = js.native
  def getInputProps(): DropzoneInputProps = js.native
  def getInputProps(props: DropzoneInputProps): DropzoneInputProps = js.native
  def getRootProps(): DropzoneRootProps = js.native
  def getRootProps(props: DropzoneRootProps): DropzoneRootProps = js.native
  def open(): Unit = js.native
}

