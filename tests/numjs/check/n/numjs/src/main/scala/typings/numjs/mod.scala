package typings.numjs

import typings.ndarray.mod.Data
import typings.ndarray.mod.DataType
import typings.ndarray.mod.ndarray
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @js.native
  trait NdArray[T]
    extends StObject
       with ndarray[T] {
    
    @JSName("T")
    var T_NdArray: NdArray[T] = js.native
    
    var ndim: Double = js.native
    
    def slice(args: Double*): NdArray[T] = js.native
  }
  object NdArray {
    
    @scala.inline
    def apply[T](T: NdArray[T], data: Data[T], ndim: Double, slice: /* repeated */ Double => NdArray[T]): NdArray[T] = {
      val __obj = js.Dynamic.literal(T = T.asInstanceOf[js.Any], data = data.asInstanceOf[js.Any], ndim = ndim.asInstanceOf[js.Any], slice = js.Any.fromFunction1(slice))
      __obj.asInstanceOf[NdArray[T]]
    }
    
    @scala.inline
    implicit class NdArrayMutableBuilder[Self <: NdArray[?], T] (val x: Self & NdArray[T]) extends AnyVal {
      
      @scala.inline
      def setNdim(value: Double): Self = StObject.set(x, "ndim", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setSlice(value: /* repeated */ Double => NdArray[T]): Self = StObject.set(x, "slice", js.Any.fromFunction1(value))
      
      @scala.inline
      def setT(value: NdArray[T]): Self = StObject.set(x, "T", value.asInstanceOf[js.Any])
    }
  }
  
  type NdType[T] = DataType | Data[T]
}
