package typingsSlinky.reactDropzone.components

import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.react.mod.RefAttributes
import typingsSlinky.reactDropzone.mod.DropzoneProps
import typingsSlinky.reactDropzone.mod.DropzoneRef
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar. QualifiedName(IArray(Name(<intersection>))) was not a @ScalaJSDefined trait */
object ReactDropzone
  extends ExternalComponentWithAttributesWithRefType[tag.type, js.Object] {
  @JSImport("react-dropzone", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
  override val component: String | js.Object = this.componentImport
  type Props = DropzoneProps with RefAttributes[DropzoneRef]
}

