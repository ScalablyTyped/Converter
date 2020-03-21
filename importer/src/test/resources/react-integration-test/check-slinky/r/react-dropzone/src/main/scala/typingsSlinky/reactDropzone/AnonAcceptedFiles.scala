package typingsSlinky.reactDropzone

import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.HTMLInputElement
import slinky.core.facade.ReactRef
import typingsSlinky.reactDropzone.mod.DropzoneInputProps
import typingsSlinky.reactDropzone.mod.DropzoneRootProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonAcceptedFiles extends js.Object {
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
}

