package typings.sax

import org.scalablytyped.runtime.StringDictionary
import typings.node.streamMod.Duplex
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("sax", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  @JSImport("sax", "EVENTS")
  @js.native
  def EVENTS: js.Array[String] = js.native
  inline def EVENTS_=(x: js.Array[String]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("EVENTS")(x.asInstanceOf[js.Any])
  
  @JSImport("sax", "SAXParser")
  @js.native
  class SAXParser protected () extends StObject {
    def this(strict: Boolean, opt: SAXOptions) = this()
    
    def write(s: String): SAXParser = js.native
  }
  
  @JSImport("sax", "SAXStream")
  @js.native
  class SAXStream protected () extends Duplex {
    def this(strict: Boolean, opt: SAXOptions) = this()
    
    /* private */ var _parser: SAXParser = js.native
  }
  
  inline def createStream(strict: Boolean, opt: SAXOptions): SAXStream = (^.asInstanceOf[js.Dynamic].applyDynamic("createStream")(strict.asInstanceOf[js.Any], opt.asInstanceOf[js.Any])).asInstanceOf[SAXStream]
  
  inline def parser(strict: Boolean, opt: SAXOptions): SAXParser = (^.asInstanceOf[js.Dynamic].applyDynamic("parser")(strict.asInstanceOf[js.Any], opt.asInstanceOf[js.Any])).asInstanceOf[SAXParser]
  
  trait BaseTag extends StObject {
    
    var isSelfClosing: Boolean
    
    var name: String
  }
  object BaseTag {
    
    inline def apply(isSelfClosing: Boolean, name: String): BaseTag = {
      val __obj = js.Dynamic.literal(isSelfClosing = isSelfClosing.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
      __obj.asInstanceOf[BaseTag]
    }
    
    extension [Self <: BaseTag](x: Self) {
      
      inline def setIsSelfClosing(value: Boolean): Self = StObject.set(x, "isSelfClosing", value.asInstanceOf[js.Any])
      
      inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
    }
  }
  
  trait QualifiedAttribute
    extends StObject
       with QualifiedName {
    
    var value: String
  }
  object QualifiedAttribute {
    
    inline def apply(local: String, name: String, prefix: String, uri: String, value: String): QualifiedAttribute = {
      val __obj = js.Dynamic.literal(local = local.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any], prefix = prefix.asInstanceOf[js.Any], uri = uri.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
      __obj.asInstanceOf[QualifiedAttribute]
    }
    
    extension [Self <: QualifiedAttribute](x: Self) {
      
      inline def setValue(value: String): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
    }
  }
  
  trait QualifiedName extends StObject {
    
    var local: String
    
    var name: String
    
    var prefix: String
    
    var uri: String
  }
  object QualifiedName {
    
    inline def apply(local: String, name: String, prefix: String, uri: String): QualifiedName = {
      val __obj = js.Dynamic.literal(local = local.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any], prefix = prefix.asInstanceOf[js.Any], uri = uri.asInstanceOf[js.Any])
      __obj.asInstanceOf[QualifiedName]
    }
    
    extension [Self <: QualifiedName](x: Self) {
      
      inline def setLocal(value: String): Self = StObject.set(x, "local", value.asInstanceOf[js.Any])
      
      inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
      
      inline def setPrefix(value: String): Self = StObject.set(x, "prefix", value.asInstanceOf[js.Any])
      
      inline def setUri(value: String): Self = StObject.set(x, "uri", value.asInstanceOf[js.Any])
    }
  }
  
  /* import warning: transforms.RemoveMultipleInheritance#findNewParents newComments Dropped parents 
  - typings.sax.mod.BaseTag because var conflicts: name. Inlined isSelfClosing */ trait QualifiedTag
    extends StObject
       with QualifiedName {
    
    var attributes: StringDictionary[QualifiedAttribute]
    
    var isSelfClosing: Boolean
    
    var ns: StringDictionary[String]
  }
  object QualifiedTag {
    
    inline def apply(
      attributes: StringDictionary[QualifiedAttribute],
      isSelfClosing: Boolean,
      local: String,
      name: String,
      ns: StringDictionary[String],
      prefix: String,
      uri: String
    ): QualifiedTag = {
      val __obj = js.Dynamic.literal(attributes = attributes.asInstanceOf[js.Any], isSelfClosing = isSelfClosing.asInstanceOf[js.Any], local = local.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any], ns = ns.asInstanceOf[js.Any], prefix = prefix.asInstanceOf[js.Any], uri = uri.asInstanceOf[js.Any])
      __obj.asInstanceOf[QualifiedTag]
    }
    
    extension [Self <: QualifiedTag](x: Self) {
      
      inline def setAttributes(value: StringDictionary[QualifiedAttribute]): Self = StObject.set(x, "attributes", value.asInstanceOf[js.Any])
      
      inline def setIsSelfClosing(value: Boolean): Self = StObject.set(x, "isSelfClosing", value.asInstanceOf[js.Any])
      
      inline def setNs(value: StringDictionary[String]): Self = StObject.set(x, "ns", value.asInstanceOf[js.Any])
    }
  }
  
  trait SAXOptions extends StObject {
    
    var lowercase: js.UndefOr[Boolean] = js.undefined
    
    var normalize: js.UndefOr[Boolean] = js.undefined
    
    var noscript: js.UndefOr[Boolean] = js.undefined
    
    var position: js.UndefOr[Boolean] = js.undefined
    
    var trim: js.UndefOr[Boolean] = js.undefined
    
    var xmlns: js.UndefOr[Boolean] = js.undefined
  }
  object SAXOptions {
    
    inline def apply(): SAXOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[SAXOptions]
    }
    
    extension [Self <: SAXOptions](x: Self) {
      
      inline def setLowercase(value: Boolean): Self = StObject.set(x, "lowercase", value.asInstanceOf[js.Any])
      
      inline def setLowercaseUndefined: Self = StObject.set(x, "lowercase", js.undefined)
      
      inline def setNormalize(value: Boolean): Self = StObject.set(x, "normalize", value.asInstanceOf[js.Any])
      
      inline def setNormalizeUndefined: Self = StObject.set(x, "normalize", js.undefined)
      
      inline def setNoscript(value: Boolean): Self = StObject.set(x, "noscript", value.asInstanceOf[js.Any])
      
      inline def setNoscriptUndefined: Self = StObject.set(x, "noscript", js.undefined)
      
      inline def setPosition(value: Boolean): Self = StObject.set(x, "position", value.asInstanceOf[js.Any])
      
      inline def setPositionUndefined: Self = StObject.set(x, "position", js.undefined)
      
      inline def setTrim(value: Boolean): Self = StObject.set(x, "trim", value.asInstanceOf[js.Any])
      
      inline def setTrimUndefined: Self = StObject.set(x, "trim", js.undefined)
      
      inline def setXmlns(value: Boolean): Self = StObject.set(x, "xmlns", value.asInstanceOf[js.Any])
      
      inline def setXmlnsUndefined: Self = StObject.set(x, "xmlns", js.undefined)
    }
  }
  
  trait Tag
    extends StObject
       with BaseTag {
    
    var attributes: StringDictionary[String]
  }
  object Tag {
    
    inline def apply(attributes: StringDictionary[String], isSelfClosing: Boolean, name: String): Tag = {
      val __obj = js.Dynamic.literal(attributes = attributes.asInstanceOf[js.Any], isSelfClosing = isSelfClosing.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
      __obj.asInstanceOf[Tag]
    }
    
    extension [Self <: Tag](x: Self) {
      
      inline def setAttributes(value: StringDictionary[String]): Self = StObject.set(x, "attributes", value.asInstanceOf[js.Any])
    }
  }
}
