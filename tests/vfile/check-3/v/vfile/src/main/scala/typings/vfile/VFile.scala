package typings.vfile

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/** 
NOTE: Rewritten from type alias:
{{{
type VFile = <F extends vfile.VFile>(input : vfile.VFileContents | F | vfile.VFileOptions | undefined): F
}}}
to avoid circular code involving: 
- vfile.VFile
*/
@js.native
trait VFile extends StObject {
  
  def apply[F /* <: VFile */](): F = js.native
  def apply[F /* <: VFile */](input: VFileOptions): F = js.native
  def apply[F /* <: VFile */](input: F | VFileContents): F = js.native
}
