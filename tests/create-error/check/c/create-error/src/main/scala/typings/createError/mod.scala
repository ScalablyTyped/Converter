package typings.createError

import org.scalablytyped.runtime.Instantiable0
import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @scala.inline
  def apply(): Error[Error[Err]] = ^.asInstanceOf[js.Dynamic].apply().asInstanceOf[Error[Error[Err]]]
  @scala.inline
  def apply[T /* <: Error[Error[Err]] */](Target: Error[Error[Err]]): T = ^.asInstanceOf[js.Dynamic].apply(Target.asInstanceOf[js.Any]).asInstanceOf[T]
  @scala.inline
  def apply[T /* <: Error[Error[Err]] */](Target: Error[Error[Err]], name: js.UndefOr[scala.Nothing], properties: js.Any): T = (^.asInstanceOf[js.Dynamic].apply(Target.asInstanceOf[js.Any], name.asInstanceOf[js.Any], properties.asInstanceOf[js.Any])).asInstanceOf[T]
  @scala.inline
  def apply[T /* <: Error[Error[Err]] */](Target: Error[Error[Err]], name: String): T = (^.asInstanceOf[js.Dynamic].apply(Target.asInstanceOf[js.Any], name.asInstanceOf[js.Any])).asInstanceOf[T]
  @scala.inline
  def apply[T /* <: Error[Error[Err]] */](Target: Error[Error[Err]], name: String, properties: js.Any): T = (^.asInstanceOf[js.Dynamic].apply(Target.asInstanceOf[js.Any], name.asInstanceOf[js.Any], properties.asInstanceOf[js.Any])).asInstanceOf[T]
  @scala.inline
  def apply[T /* <: Error[Error[Err]] */](name: String): T = ^.asInstanceOf[js.Dynamic].apply(name.asInstanceOf[js.Any]).asInstanceOf[T]
  @scala.inline
  def apply[T /* <: Error[Error[Err]] */](name: String, properties: js.Any): T = (^.asInstanceOf[js.Dynamic].apply(name.asInstanceOf[js.Any], properties.asInstanceOf[js.Any])).asInstanceOf[T]
  
  @JSImport("create-error", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  type Err = typings.std.Error
  
  @js.native
  trait Error[T /* <: Err */]
    extends Instantiable0[T]
       with typings.std.Error
       with Instantiable1[/* message */ String, T]
       with Instantiable2[js.UndefOr[/* message */ String], /* obj */ js.Any, T]
}
