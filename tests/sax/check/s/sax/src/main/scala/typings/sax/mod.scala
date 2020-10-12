package typings.sax

import org.scalablytyped.runtime.StringDictionary
import typings.node.streamMod.Duplex
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
  
  @JSImport("sax", "createStream")
  @js.native
  def createStream(strict: Boolean, opt: SAXOptions): SAXStream = js.native
  
  @JSImport("sax", "parser")
  @js.native
  def parser(strict: Boolean, opt: SAXOptions): SAXParser = js.native
  
  @js.native
  trait BaseTag extends js.Object {
    
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
    implicit class BaseTagOps[Self <: BaseTag] (val x: Self) extends AnyVal {
      
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
      def setIsSelfClosing(value: Boolean): Self = this.set("isSelfClosing", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setName(value: String): Self = this.set("name", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait QualifiedAttribute extends QualifiedName {
    
    var value: String = js.native
  }
  object QualifiedAttribute {
    
    @scala.inline
    def apply(local: String, name: String, prefix: String, uri: String, value: String): QualifiedAttribute = {
      val __obj = js.Dynamic.literal(local = local.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any], prefix = prefix.asInstanceOf[js.Any], uri = uri.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
      __obj.asInstanceOf[QualifiedAttribute]
    }
    
    @scala.inline
    implicit class QualifiedAttributeOps[Self <: QualifiedAttribute] (val x: Self) extends AnyVal {
      
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
      def setValue(value: String): Self = this.set("value", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait QualifiedName extends js.Object {
    
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
    implicit class QualifiedNameOps[Self <: QualifiedName] (val x: Self) extends AnyVal {
      
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
      def setLocal(value: String): Self = this.set("local", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setName(value: String): Self = this.set("name", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPrefix(value: String): Self = this.set("prefix", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setUri(value: String): Self = this.set("uri", value.asInstanceOf[js.Any])
    }
  }
  
  /* import warning: transforms.RemoveMultipleInheritance#findNewParents newComments Dropped parents 
  - typings.sax.mod.BaseTag because var conflicts: name. Inlined isSelfClosing */ @js.native
  trait QualifiedTag extends QualifiedName {
    
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
    implicit class QualifiedTagOps[Self <: QualifiedTag] (val x: Self) extends AnyVal {
      
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
      def setAttributes(value: StringDictionary[QualifiedAttribute]): Self = this.set("attributes", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setIsSelfClosing(value: Boolean): Self = this.set("isSelfClosing", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setNs(value: StringDictionary[String]): Self = this.set("ns", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait SAXOptions extends js.Object {
    
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
    implicit class SAXOptionsOps[Self <: SAXOptions] (val x: Self) extends AnyVal {
      
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
      def setLowercase(value: Boolean): Self = this.set("lowercase", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteLowercase: Self = this.set("lowercase", js.undefined)
      
      @scala.inline
      def setNormalize(value: Boolean): Self = this.set("normalize", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteNormalize: Self = this.set("normalize", js.undefined)
      
      @scala.inline
      def setNoscript(value: Boolean): Self = this.set("noscript", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteNoscript: Self = this.set("noscript", js.undefined)
      
      @scala.inline
      def setPosition(value: Boolean): Self = this.set("position", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deletePosition: Self = this.set("position", js.undefined)
      
      @scala.inline
      def setTrim(value: Boolean): Self = this.set("trim", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteTrim: Self = this.set("trim", js.undefined)
      
      @scala.inline
      def setXmlns(value: Boolean): Self = this.set("xmlns", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteXmlns: Self = this.set("xmlns", js.undefined)
    }
  }
  
  @JSImport("sax", "SAXParser")
  @js.native
  class SAXParser protected () extends js.Object {
    def this(strict: Boolean, opt: SAXOptions) = this()
    
    def write(s: String): SAXParser = js.native
  }
  
  @JSImport("sax", "SAXStream")
  @js.native
  class SAXStream protected () extends Duplex {
    def this(strict: Boolean, opt: SAXOptions) = this()
    
    var _parser: SAXParser = js.native
  }
  
  @js.native
  trait Tag extends BaseTag {
    
    var attributes: StringDictionary[String] = js.native
  }
  object Tag {
    
    @scala.inline
    def apply(attributes: StringDictionary[String], isSelfClosing: Boolean, name: String): Tag = {
      val __obj = js.Dynamic.literal(attributes = attributes.asInstanceOf[js.Any], isSelfClosing = isSelfClosing.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any])
      __obj.asInstanceOf[Tag]
    }
    
    @scala.inline
    implicit class TagOps[Self <: Tag] (val x: Self) extends AnyVal {
      
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
      def setAttributes(value: StringDictionary[String]): Self = this.set("attributes", value.asInstanceOf[js.Any])
    }
  }
}
