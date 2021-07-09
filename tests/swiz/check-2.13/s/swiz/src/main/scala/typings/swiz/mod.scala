package typings.swiz

import typings.swiz.mod.struct.IField
import typings.swiz.mod.struct.IObj
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
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
  class Swiz protected () extends StObject {
    def this(defs: js.Array[IObj]) = this()
    def this(defs: js.Array[IObj], options: ISwizOptions) = this()
    
    def deserialize(
      mode: SERIALIZATION,
      version: Double,
      raw: String,
      callback: js.Function2[/* err */ js.Any, /* result */ js.Any, Unit]
    ): Unit = js.native
    
    def getFieldDefinition(stype: String, name: String): IField = js.native
    
    def serialize(
      mode: SERIALIZATION,
      version: Double,
      obj: ISerializable,
      callback: js.Function2[/* err */ js.Any, /* result */ String, Unit]
    ): Unit = js.native
    
    def serializeForPagination(
      mode: SERIALIZATION,
      array: js.Array[js.Any],
      metadata: js.Any,
      callback: js.Function2[/* err */ js.Any, /* result */ String, Unit]
    ): Unit = js.native
  }
  
  @js.native
  trait ISerializable extends StObject {
    
    def getSerializerType(): String = js.native
  }
  object ISerializable {
    
    @scala.inline
    def apply(getSerializerType: () => String): ISerializable = {
      val __obj = js.Dynamic.literal(getSerializerType = js.Any.fromFunction0(getSerializerType))
      __obj.asInstanceOf[ISerializable]
    }
    
    @scala.inline
    implicit class ISerializableMutableBuilder[Self <: ISerializable] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setGetSerializerType(value: () => String): Self = StObject.set(x, "getSerializerType", js.Any.fromFunction0(value))
    }
  }
  
  @js.native
  trait ISwizOptions extends StObject {
    
    var `for`: js.UndefOr[String] = js.native
    
    var stripNulls: js.UndefOr[Boolean] = js.native
    
    var stripSerializerType: js.UndefOr[Boolean] = js.native
  }
  object ISwizOptions {
    
    @scala.inline
    def apply(): ISwizOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ISwizOptions]
    }
    
    @scala.inline
    implicit class ISwizOptionsMutableBuilder[Self <: ISwizOptions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setFor(value: String): Self = StObject.set(x, "for", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setForUndefined: Self = StObject.set(x, "for", js.undefined)
      
      @scala.inline
      def setStripNulls(value: Boolean): Self = StObject.set(x, "stripNulls", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setStripNullsUndefined: Self = StObject.set(x, "stripNulls", js.undefined)
      
      @scala.inline
      def setStripSerializerType(value: Boolean): Self = StObject.set(x, "stripSerializerType", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setStripSerializerTypeUndefined: Self = StObject.set(x, "stripSerializerType", js.undefined)
    }
  }
  
  object struct {
    
    @js.native
    trait IField extends StObject
    
    @js.native
    trait IObj extends StObject
  }
}
