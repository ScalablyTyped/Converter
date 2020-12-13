package typings.ndarray

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("ndarray", JSImport.Namespace)
  @js.native
  def apply[T](data: Data[T]): typings.ndarray.mod.ndarray[T] = js.native
  @JSImport("ndarray", JSImport.Namespace)
  @js.native
  def apply[T](data: Data[T], shape: js.UndefOr[scala.Nothing], stride: js.UndefOr[scala.Nothing], offset: Double): typings.ndarray.mod.ndarray[T] = js.native
  @JSImport("ndarray", JSImport.Namespace)
  @js.native
  def apply[T](data: Data[T], shape: js.UndefOr[scala.Nothing], stride: js.Array[Double]): typings.ndarray.mod.ndarray[T] = js.native
  @JSImport("ndarray", JSImport.Namespace)
  @js.native
  def apply[T](data: Data[T], shape: js.UndefOr[scala.Nothing], stride: js.Array[Double], offset: Double): typings.ndarray.mod.ndarray[T] = js.native
  @JSImport("ndarray", JSImport.Namespace)
  @js.native
  def apply[T](data: Data[T], shape: js.Array[Double]): typings.ndarray.mod.ndarray[T] = js.native
  @JSImport("ndarray", JSImport.Namespace)
  @js.native
  def apply[T](data: Data[T], shape: js.Array[Double], stride: js.UndefOr[scala.Nothing], offset: Double): typings.ndarray.mod.ndarray[T] = js.native
  @JSImport("ndarray", JSImport.Namespace)
  @js.native
  def apply[T](data: Data[T], shape: js.Array[Double], stride: js.Array[Double]): typings.ndarray.mod.ndarray[T] = js.native
  @JSImport("ndarray", JSImport.Namespace)
  @js.native
  def apply[T](data: Data[T], shape: js.Array[Double], stride: js.Array[Double], offset: Double): typings.ndarray.mod.ndarray[T] = js.native
  
  @js.native
  trait ndarray[T] extends StObject {
    
    var T: typings.ndarray.mod.ndarray[T] = js.native
    
    var data: Data[T] = js.native
  }
  object ndarray {
    
    @scala.inline
    def apply[T](T: typings.ndarray.mod.ndarray[T], data: Data[T]): ndarray[T] = {
      val __obj = js.Dynamic.literal(T = T.asInstanceOf[js.Any], data = data.asInstanceOf[js.Any])
      __obj.asInstanceOf[ndarray[T]]
    }
    
    @scala.inline
    implicit class ndarrayMutableBuilder[Self <: typings.ndarray.mod.ndarray[_], T] (val x: Self with typings.ndarray.mod.ndarray[T]) extends AnyVal {
      
      @scala.inline
      def setData(value: Data[T]): Self = StObject.set(x, "data", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setDataVarargs(value: T*): Self = StObject.set(x, "data", js.Array(value :_*))
      
      @scala.inline
      def setT(value: typings.ndarray.mod.ndarray[T]): Self = StObject.set(x, "T", value.asInstanceOf[js.Any])
    }
  }
  
  type Data[T] = js.Array[T]
  
  type DataType = String
}
