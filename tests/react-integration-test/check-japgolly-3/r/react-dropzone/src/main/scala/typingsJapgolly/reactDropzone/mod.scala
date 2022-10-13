package typingsJapgolly.reactDropzone

import typingsJapgolly.react.mod.RefAttributes
import typingsJapgolly.react.mod.global.JSX.Element
import typingsJapgolly.reactDropzone.typingsReactDropzoneMod.DropzoneOptions
import typingsJapgolly.reactDropzone.typingsReactDropzoneMod.DropzoneProps
import typingsJapgolly.reactDropzone.typingsReactDropzoneMod.DropzoneRef
import typingsJapgolly.reactDropzone.typingsReactDropzoneMod.DropzoneState
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Inferred short module name */
object mod {
  
  @JSImport("react-dropzone", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def default(props: DropzoneProps & RefAttributes[DropzoneRef]): Element = ^.asInstanceOf[js.Dynamic].applyDynamic("default")(props.asInstanceOf[js.Any]).asInstanceOf[Element]
  
  inline def useDropzone(): DropzoneState = ^.asInstanceOf[js.Dynamic].applyDynamic("useDropzone")().asInstanceOf[DropzoneState]
  inline def useDropzone(options: DropzoneOptions): DropzoneState = ^.asInstanceOf[js.Dynamic].applyDynamic("useDropzone")(options.asInstanceOf[js.Any]).asInstanceOf[DropzoneState]
}
