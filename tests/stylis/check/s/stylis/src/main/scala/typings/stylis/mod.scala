package typings.stylis

import org.scalablytyped.runtime.Instantiable0
import org.scalablytyped.runtime.Instantiable1
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("stylis/stylis", JSImport.Namespace)
  @js.native
  val ^ : Stylis = js.native
  
  /* Syntax to write `mod` instead of `mod.^` */
  @scala.inline
  implicit def __is(ignored: mod.type): Stylis = typings.stylis.mod.^
  
  /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
  @JSImport("stylis/stylis", JSImport.Namespace)
  @js.native
  class ^ () extends Stylis {
    def this(options: Options) = this()
  }
  
  @js.native
  sealed trait Context extends js.Object
  @JSImport("stylis/stylis", "Context")
  @js.native
  object Context extends js.Object {
    
    @js.native
    sealed trait ATRUL extends Context
    
    @js.native
    sealed trait BLCKS extends Context
    
    @js.native
    sealed trait POSTS extends Context
    
    @js.native
    sealed trait PREPS extends Context
    
    @js.native
    sealed trait PROPS extends Context
    
    @js.native
    sealed trait UNKWN extends Context
  }
  
  @js.native
  trait Options extends js.Object {
    
    var cascade: js.UndefOr[Boolean] = js.native
    
    var compress: js.UndefOr[Boolean] = js.native
    
    var global: js.UndefOr[Boolean] = js.native
    
    var keyframe: js.UndefOr[Boolean] = js.native
    
    var prefix: js.UndefOr[
        Boolean | (js.Function3[/* key */ String, /* value */ String, /* context */ Double, Boolean])
      ] = js.native
    
    var preserve: js.UndefOr[Boolean] = js.native
    
    var semicolon: js.UndefOr[Boolean] = js.native
  }
  object Options {
    
    @scala.inline
    def apply(): Options = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Options]
    }
    
    @scala.inline
    implicit class OptionsOps[Self <: Options] (val x: Self) extends AnyVal {
      
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
      def setCascade(value: Boolean): Self = this.set("cascade", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteCascade: Self = this.set("cascade", js.undefined)
      
      @scala.inline
      def setCompress(value: Boolean): Self = this.set("compress", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteCompress: Self = this.set("compress", js.undefined)
      
      @scala.inline
      def setGlobal(value: Boolean): Self = this.set("global", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteGlobal: Self = this.set("global", js.undefined)
      
      @scala.inline
      def setKeyframe(value: Boolean): Self = this.set("keyframe", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteKeyframe: Self = this.set("keyframe", js.undefined)
      
      @scala.inline
      def setPrefixFunction3(value: (/* key */ String, /* value */ String, /* context */ Double) => Boolean): Self = this.set("prefix", js.Any.fromFunction3(value))
      
      @scala.inline
      def setPrefix(
        value: Boolean | (js.Function3[/* key */ String, /* value */ String, /* context */ Double, Boolean])
      ): Self = this.set("prefix", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deletePrefix: Self = this.set("prefix", js.undefined)
      
      @scala.inline
      def setPreserve(value: Boolean): Self = this.set("preserve", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deletePreserve: Self = this.set("preserve", js.undefined)
      
      @scala.inline
      def setSemicolon(value: Boolean): Self = this.set("semicolon", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteSemicolon: Self = this.set("semicolon", js.undefined)
    }
  }
  
  @js.native
  trait Set extends js.Object {
    
    def apply(): Set = js.native
    def apply(options: Options): Set = js.native
  }
  
  @js.native
  trait Stylis
    extends Instantiable0[Stylis]
       with Instantiable1[/* options */ Options, Stylis] {
    
    def apply(namescope: String, input: String): String | js.Any = js.native
    
    def set(): Set = js.native
    def set(options: Options): Set = js.native
    @JSName("set")
    var set_Original: Set = js.native
    
    def use(): Use = js.native
    def use(plugin: js.Array[Plugin]): Use = js.native
    def use(plugin: Plugin): Use = js.native
    @JSName("use")
    var use_Original: Use = js.native
  }
  
  @js.native
  trait Use extends js.Object {
    
    def apply(): Use = js.native
    def apply(plugin: js.Array[Plugin]): Use = js.native
    def apply(plugin: Plugin): Use = js.native
  }
  
  object global {
    
    @JSGlobal("stylis")
    @js.native
    val stylis: Stylis = js.native
    /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
    @JSGlobal("stylis")
    @js.native
    class stylis () extends Stylis {
      def this(options: Options) = this()
    }
  }
  
  type Plugin = js.ThisFunction9[
    /* this */ Stylis, 
    /* context */ Context, 
    /* content */ String, 
    /* selector */ Selectors, 
    /* parent */ Selectors, 
    /* line */ Double, 
    /* column */ Double, 
    /* length */ Double, 
    /* at */ Double, 
    /* depth */ Double, 
    Null | Unit | String
  ]
  
  type Selectors = js.Array[String]
}
