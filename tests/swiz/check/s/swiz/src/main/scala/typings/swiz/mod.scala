package typings.swiz

import typings.swiz.mod.struct.IField
import typings.swiz.mod.struct.IObj
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @js.native
  trait ISerializable extends js.Object {
    
    def getSerializerType(): String = js.native
  }
  object ISerializable {
    
    @scala.inline
    def apply(getSerializerType: () => String): ISerializable = {
      val __obj = js.Dynamic.literal(getSerializerType = js.Any.fromFunction0(getSerializerType))
      __obj.asInstanceOf[ISerializable]
    }
    
    @scala.inline
    implicit class ISerializableOps[Self <: ISerializable] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setGetSerializerType(value: () => String): Self = this.set("getSerializerType", js.Any.fromFunction0(value))
    }
  }
  
  @js.native
  trait ISwizOptions extends js.Object {
    
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
    implicit class ISwizOptionsOps[Self <: ISwizOptions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setFor(value: String): Self = this.set("for", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteFor: Self = this.set("for", js.undefined)
      
      @scala.inline
      def setStripNulls(value: Boolean): Self = this.set("stripNulls", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteStripNulls: Self = this.set("stripNulls", js.undefined)
      
      @scala.inline
      def setStripSerializerType(value: Boolean): Self = this.set("stripSerializerType", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteStripSerializerType: Self = this.set("stripSerializerType", js.undefined)
    }
  }
  
  @js.native
  sealed trait SERIALIZATION extends js.Object
  @JSImport("swiz", "SERIALIZATION")
  @js.native
  object SERIALIZATION extends js.Object {
    
    @js.native
    sealed trait SERIALIZATION_JSON extends SERIALIZATION
    
    @js.native
    sealed trait SERIALIZATION_XML extends SERIALIZATION
    
    @js.native
    sealed trait _underscore extends SERIALIZATION
    
    @js.native
    sealed trait java extends SERIALIZATION
    
    @js.native
    sealed trait js extends SERIALIZATION
    
    @js.native
    sealed trait notify extends SERIALIZATION
  }
  
  @JSImport("swiz", "Swiz")
  @js.native
  class Swiz protected () extends js.Object {
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
      array: js.Array[_],
      metadata: js.Any,
      callback: js.Function2[/* err */ js.Any, /* result */ String, Unit]
    ): Unit = js.native
  }
  
  object struct {
    
    @js.native
    trait IField extends js.Object
    
    @js.native
    trait IObj extends js.Object
  }
}
