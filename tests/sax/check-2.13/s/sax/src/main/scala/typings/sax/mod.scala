package typings.sax

import org.scalablytyped.runtime.StringDictionary
import typings.node.streamMod.Duplex
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("sax", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  @JSImport("sax", "EVENTS")
  @js.native
  def EVENTS: js.Array[String] = js.native
  @scala.inline
  def EVENTS_=(x: js.Array[String]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("EVENTS")(x.asInstanceOf[js.Any])
  
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
    
    var _parser: SAXParser = js.native
  }
  
  @scala.inline
  def createStream(strict: Boolean, opt: SAXOptions): SAXStream = (^.asInstanceOf[js.Dynamic].applyDynamic("createStream")(strict.asInstanceOf[js.Any], opt.asInstanceOf[js.Any])).asInstanceOf[SAXStream]
  
  @scala.inline
  def parser(strict: Boolean, opt: SAXOptions): SAXParser = (^.asInstanceOf[js.Dynamic].applyDynamic("parser")(strict.asInstanceOf[js.Any], opt.asInstanceOf[js.Any])).asInstanceOf[SAXParser]
  
  @js.native
  trait BaseTag extends StObject {
    
    var isSelfClosing: Boolean = js.native
    
    var name: String = js.native
  }
  object BaseTag {
    
    @scala.inline
    def apply(isSelfClosing: Boolean, name: String): BaseTag = {
      val __obj = js.Dynamic.literal(isSelfClosing = isSelfClosing.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
      __obj.asInstanceOf[BaseTag]
    }
    
    @scala.inline
    implicit class BaseTagMutableBuilder[Self <: BaseTag] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setIsSelfClosing(value: Boolean): Self = StObject.set(x, "isSelfClosing", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait QualifiedAttribute
    extends StObject
       with QualifiedName {
    
    var value: String = js.native
  }
  object QualifiedAttribute {
    
    @scala.inline
    def apply(local: String, name: String, prefix: String, uri: String, value: String): QualifiedAttribute = {
      val __obj = js.Dynamic.literal(local = local.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any], prefix = prefix.asInstanceOf[js.Any], uri = uri.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
      __obj.asInstanceOf[QualifiedAttribute]
    }
    
    @scala.inline
    implicit class QualifiedAttributeMutableBuilder[Self <: QualifiedAttribute] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setValue(value: String): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait QualifiedName extends StObject {
    
    var local: String = js.native
    
    var name: String = js.native
    
    var prefix: String = js.native
    
    var uri: String = js.native
  }
  object QualifiedName {
    
    @scala.inline
    def apply(local: String, name: String, prefix: String, uri: String): QualifiedName = {
      val __obj = js.Dynamic.literal(local = local.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any], prefix = prefix.asInstanceOf[js.Any], uri = uri.asInstanceOf[js.Any])
      __obj.asInstanceOf[QualifiedName]
    }
    
    @scala.inline
    implicit class QualifiedNameMutableBuilder[Self <: QualifiedName] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setLocal(value: String): Self = StObject.set(x, "local", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPrefix(value: String): Self = StObject.set(x, "prefix", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setUri(value: String): Self = StObject.set(x, "uri", value.asInstanceOf[js.Any])
    }
  }
  
  /* import warning: transforms.RemoveMultipleInheritance#findNewParents newComments Dropped parents 
  - typings.sax.mod.BaseTag because var conflicts: name. Inlined isSelfClosing */ @js.native
  trait QualifiedTag
    extends StObject
       with QualifiedName {
    
    var attributes: StringDictionary[QualifiedAttribute] = js.native
    
    var isSelfClosing: Boolean = js.native
    
    var ns: StringDictionary[String] = js.native
  }
  object QualifiedTag {
    
    @scala.inline
    def apply(
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
    
    @scala.inline
    implicit class QualifiedTagMutableBuilder[Self <: QualifiedTag] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setAttributes(value: StringDictionary[QualifiedAttribute]): Self = StObject.set(x, "attributes", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setIsSelfClosing(value: Boolean): Self = StObject.set(x, "isSelfClosing", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setNs(value: StringDictionary[String]): Self = StObject.set(x, "ns", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait SAXOptions extends StObject {
    
    var lowercase: js.UndefOr[Boolean] = js.native
    
    var normalize: js.UndefOr[Boolean] = js.native
    
    var noscript: js.UndefOr[Boolean] = js.native
    
    var position: js.UndefOr[Boolean] = js.native
    
    var trim: js.UndefOr[Boolean] = js.native
    
    var xmlns: js.UndefOr[Boolean] = js.native
  }
  object SAXOptions {
    
    @scala.inline
    def apply(): SAXOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[SAXOptions]
    }
    
    @scala.inline
    implicit class SAXOptionsMutableBuilder[Self <: SAXOptions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setLowercase(value: Boolean): Self = StObject.set(x, "lowercase", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setLowercaseUndefined: Self = StObject.set(x, "lowercase", js.undefined)
      
      @scala.inline
      def setNormalize(value: Boolean): Self = StObject.set(x, "normalize", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setNormalizeUndefined: Self = StObject.set(x, "normalize", js.undefined)
      
      @scala.inline
      def setNoscript(value: Boolean): Self = StObject.set(x, "noscript", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setNoscriptUndefined: Self = StObject.set(x, "noscript", js.undefined)
      
      @scala.inline
      def setPosition(value: Boolean): Self = StObject.set(x, "position", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPositionUndefined: Self = StObject.set(x, "position", js.undefined)
      
      @scala.inline
      def setTrim(value: Boolean): Self = StObject.set(x, "trim", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setTrimUndefined: Self = StObject.set(x, "trim", js.undefined)
      
      @scala.inline
      def setXmlns(value: Boolean): Self = StObject.set(x, "xmlns", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setXmlnsUndefined: Self = StObject.set(x, "xmlns", js.undefined)
    }
  }
  
  @js.native
  trait Tag
    extends StObject
       with BaseTag {
    
    var attributes: StringDictionary[String] = js.native
  }
  object Tag {
    
    @scala.inline
    def apply(attributes: StringDictionary[String], isSelfClosing: Boolean, name: String): Tag = {
      val __obj = js.Dynamic.literal(attributes = attributes.asInstanceOf[js.Any], isSelfClosing = isSelfClosing.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
      __obj.asInstanceOf[Tag]
    }
    
    @scala.inline
    implicit class TagMutableBuilder[Self <: Tag] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setAttributes(value: StringDictionary[String]): Self = StObject.set(x, "attributes", value.asInstanceOf[js.Any])
    }
  }
}
