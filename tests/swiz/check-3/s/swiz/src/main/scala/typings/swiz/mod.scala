package typings.swiz

import _root_.typings.swiz.mod.struct.IField
import _root_.typings.swiz.mod.struct.IObj
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @js.native
  sealed trait SERIALIZATION extends StObject
  @JSImport("swiz", "SERIALIZATION")
  @js.native
  object SERIALIZATION extends StObject {
    
    @js.native
    sealed trait SERIALIZATION_JSON
      extends StObject
         with SERIALIZATION
    
    @js.native
    sealed trait SERIALIZATION_XML
      extends StObject
         with SERIALIZATION
    
    @js.native
    sealed trait _underscore
      extends StObject
         with SERIALIZATION
    
    @js.native
    sealed trait java
      extends StObject
         with SERIALIZATION
    
    @js.native
    sealed trait js
      extends StObject
         with SERIALIZATION
    
    @js.native
    sealed trait notify
      extends StObject
         with SERIALIZATION
  }
  
  @JSImport("swiz", "Swiz")
  @js.native
  open class Swiz protected () extends StObject {
    def this(defs: js.Array[IObj]) = this()
    def this(defs: js.Array[IObj], options: ISwizOptions) = this()
    
    def deserialize(
      mode: SERIALIZATION,
      version: Double,
      raw: String,
      callback: js.Function2[/* err */ Any, /* result */ Any, Unit]
    ): Unit = js.native
    
    def getFieldDefinition(stype: String, name: String): IField = js.native
    
    def serialize(
      mode: SERIALIZATION,
      version: Double,
      obj: ISerializable,
      callback: js.Function2[/* err */ Any, /* result */ String, Unit]
    ): Unit = js.native
    
    def serializeForPagination(
      mode: SERIALIZATION,
      array: js.Array[Any],
      metadata: Any,
      callback: js.Function2[/* err */ Any, /* result */ String, Unit]
    ): Unit = js.native
  }
  
  trait ISerializable extends StObject {
    
    def getSerializerType(): String
  }
  object ISerializable {
    
    inline def apply(getSerializerType: () => String): ISerializable = {
      val __obj = js.Dynamic.literal(getSerializerType = js.Any.fromFunction0(getSerializerType))
      __obj.asInstanceOf[ISerializable]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: ISerializable] (val x: Self) extends AnyVal {
      
      inline def setGetSerializerType(value: () => String): Self = StObject.set(x, "getSerializerType", js.Any.fromFunction0(value))
    }
  }
  
  trait ISwizOptions extends StObject {
    
    var `for`: js.UndefOr[String] = js.undefined
    
    var stripNulls: js.UndefOr[Boolean] = js.undefined
    
    var stripSerializerType: js.UndefOr[Boolean] = js.undefined
  }
  object ISwizOptions {
    
    inline def apply(): ISwizOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ISwizOptions]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: ISwizOptions] (val x: Self) extends AnyVal {
      
      inline def setFor(value: String): Self = StObject.set(x, "for", value.asInstanceOf[js.Any])
      
      inline def setForUndefined: Self = StObject.set(x, "for", js.undefined)
      
      inline def setStripNulls(value: Boolean): Self = StObject.set(x, "stripNulls", value.asInstanceOf[js.Any])
      
      inline def setStripNullsUndefined: Self = StObject.set(x, "stripNulls", js.undefined)
      
      inline def setStripSerializerType(value: Boolean): Self = StObject.set(x, "stripSerializerType", value.asInstanceOf[js.Any])
      
      inline def setStripSerializerTypeUndefined: Self = StObject.set(x, "stripSerializerType", js.undefined)
    }
  }
  
  object struct {
    
    trait IField extends StObject
    
    trait IObj extends StObject
  }
}
