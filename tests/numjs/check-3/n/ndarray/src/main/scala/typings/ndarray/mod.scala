package typings.ndarray

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  inline def apply[T](data: Data[T]): _root_.typings.ndarray.mod.ndarray[T] = ^.asInstanceOf[js.Dynamic].apply(data.asInstanceOf[js.Any]).asInstanceOf[_root_.typings.ndarray.mod.ndarray[T]]
  inline def apply[T](data: Data[T], shape: js.Array[Double]): _root_.typings.ndarray.mod.ndarray[T] = (^.asInstanceOf[js.Dynamic].apply(data.asInstanceOf[js.Any], shape.asInstanceOf[js.Any])).asInstanceOf[_root_.typings.ndarray.mod.ndarray[T]]
  inline def apply[T](data: Data[T], shape: js.Array[Double], stride: js.Array[Double]): _root_.typings.ndarray.mod.ndarray[T] = (^.asInstanceOf[js.Dynamic].apply(data.asInstanceOf[js.Any], shape.asInstanceOf[js.Any], stride.asInstanceOf[js.Any])).asInstanceOf[_root_.typings.ndarray.mod.ndarray[T]]
  inline def apply[T](data: Data[T], shape: js.Array[Double], stride: js.Array[Double], offset: Double): _root_.typings.ndarray.mod.ndarray[T] = (^.asInstanceOf[js.Dynamic].apply(data.asInstanceOf[js.Any], shape.asInstanceOf[js.Any], stride.asInstanceOf[js.Any], offset.asInstanceOf[js.Any])).asInstanceOf[_root_.typings.ndarray.mod.ndarray[T]]
  inline def apply[T](data: Data[T], shape: js.Array[Double], stride: Unit, offset: Double): _root_.typings.ndarray.mod.ndarray[T] = (^.asInstanceOf[js.Dynamic].apply(data.asInstanceOf[js.Any], shape.asInstanceOf[js.Any], stride.asInstanceOf[js.Any], offset.asInstanceOf[js.Any])).asInstanceOf[_root_.typings.ndarray.mod.ndarray[T]]
  inline def apply[T](data: Data[T], shape: Unit, stride: js.Array[Double]): _root_.typings.ndarray.mod.ndarray[T] = (^.asInstanceOf[js.Dynamic].apply(data.asInstanceOf[js.Any], shape.asInstanceOf[js.Any], stride.asInstanceOf[js.Any])).asInstanceOf[_root_.typings.ndarray.mod.ndarray[T]]
  inline def apply[T](data: Data[T], shape: Unit, stride: js.Array[Double], offset: Double): _root_.typings.ndarray.mod.ndarray[T] = (^.asInstanceOf[js.Dynamic].apply(data.asInstanceOf[js.Any], shape.asInstanceOf[js.Any], stride.asInstanceOf[js.Any], offset.asInstanceOf[js.Any])).asInstanceOf[_root_.typings.ndarray.mod.ndarray[T]]
  inline def apply[T](data: Data[T], shape: Unit, stride: Unit, offset: Double): _root_.typings.ndarray.mod.ndarray[T] = (^.asInstanceOf[js.Dynamic].apply(data.asInstanceOf[js.Any], shape.asInstanceOf[js.Any], stride.asInstanceOf[js.Any], offset.asInstanceOf[js.Any])).asInstanceOf[_root_.typings.ndarray.mod.ndarray[T]]
  
  @JSImport("ndarray", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  type Data[T] = js.Array[T]
  
  type DataType = String
  
  trait ndarray[T] extends StObject {
    
    var T: _root_.typings.ndarray.mod.ndarray[T]
    
    var data: Data[T]
  }
  object ndarray {
    
    inline def apply[T](T: _root_.typings.ndarray.mod.ndarray[T], data: Data[T]): _root_.typings.ndarray.mod.ndarray[T] = {
      val __obj = js.Dynamic.literal(T = T.asInstanceOf[js.Any], data = data.asInstanceOf[js.Any])
      __obj.asInstanceOf[_root_.typings.ndarray.mod.ndarray[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: _root_.typings.ndarray.mod.ndarray[?], T] (val x: Self & _root_.typings.ndarray.mod.ndarray[T]) extends AnyVal {
      
      inline def setData(value: Data[T]): Self = StObject.set(x, "data", value.asInstanceOf[js.Any])
      
      inline def setDataVarargs(value: T*): Self = StObject.set(x, "data", js.Array(value*))
      
      inline def setT(value: _root_.typings.ndarray.mod.ndarray[T]): Self = StObject.set(x, "T", value.asInstanceOf[js.Any])
    }
  }
}
