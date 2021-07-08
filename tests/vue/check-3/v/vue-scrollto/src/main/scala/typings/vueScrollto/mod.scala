package typings.vueScrollto

import typings.std.Element
import typings.vue.pluginMod.PluginFunction
import typings.vueScrollto.vueScrolltoBooleans.`false`
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("vue-scrollto", JSImport.Namespace)
  @js.native
  class ^ ()
    extends StObject
       with VueScrollTo {
    
    /* CompleteClass */
    override def scrollTo(element: String): Unit = js.native
    /* CompleteClass */
    override def scrollTo(element: String, duration: Double): Unit = js.native
    /* CompleteClass */
    override def scrollTo(element: String, duration: Double, options: Options): Unit = js.native
    /* CompleteClass */
    override def scrollTo(element: String, options: Options): Unit = js.native
    /* CompleteClass */
    override def scrollTo(element: Element): Unit = js.native
    /* CompleteClass */
    override def scrollTo(element: Element, duration: Double): Unit = js.native
    /* CompleteClass */
    override def scrollTo(element: Element, duration: Double, options: Options): Unit = js.native
    /* CompleteClass */
    override def scrollTo(element: Element, options: Options): Unit = js.native
    /* CompleteClass */
    override def scrollTo(options: Options): Unit = js.native
    /* CompleteClass */
    @JSName("scrollTo")
    var scrollTo_Original: VueStatic = js.native
  }
  @JSImport("vue-scrollto", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  /* static member */
  @JSImport("vue-scrollto", "install")
  @js.native
  def install: PluginFunction[scala.Nothing] = js.native
  inline def install_=(x: PluginFunction[scala.Nothing]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("install")(x.asInstanceOf[js.Any])
  
  trait Options extends StObject {
    
    // Indicates if user can cancel the scroll or not. Default: true
    var cancelable: js.UndefOr[Boolean] = js.undefined
    
    // The container that has to be scrolled. Default: body
    var container: js.UndefOr[String | Element] = js.undefined
    
    // The duration (in milliseconds) of the scrolling animation. Default: 500
    var duration: js.UndefOr[Double] = js.undefined
    
    // The easing to be used when animating. Default: ease
    var easing: js.UndefOr[String] = js.undefined
    
    // The element you want to scroll to.
    var el: js.UndefOr[String | Element] = js.undefined
    
    var element: js.UndefOr[String | Element] = js.undefined
    
    // The offset that should be applied when scrolling. Default: 0
    var offset: js.UndefOr[Double] = js.undefined
    
    // A callback function that should be called when scrolling has been aborted by the user (user scrolled, clicked
    // etc.). Default: noop
    var onCancel: js.UndefOr[js.Function0[Unit] | `false`] = js.undefined
    
    // A callback function that should be called when scrolling has ended. Default: noop
    var onDone: js.UndefOr[js.Function0[Unit] | `false`] = js.undefined
    
    // Whether or not we want scrolling on the x axis. Default: true
    var x: js.UndefOr[Boolean] = js.undefined
    
    // Whether or not we want scrolling on the y axis. Default: true
    var y: js.UndefOr[Boolean] = js.undefined
  }
  object Options {
    
    inline def apply(): Options = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Options]
    }
    
    extension [Self <: Options](x: Self) {
      
      inline def setCancelable(value: Boolean): Self = StObject.set(x, "cancelable", value.asInstanceOf[js.Any])
      
      inline def setCancelableUndefined: Self = StObject.set(x, "cancelable", js.undefined)
      
      inline def setContainer(value: String | Element): Self = StObject.set(x, "container", value.asInstanceOf[js.Any])
      
      inline def setContainerUndefined: Self = StObject.set(x, "container", js.undefined)
      
      inline def setDuration(value: Double): Self = StObject.set(x, "duration", value.asInstanceOf[js.Any])
      
      inline def setDurationUndefined: Self = StObject.set(x, "duration", js.undefined)
      
      inline def setEasing(value: String): Self = StObject.set(x, "easing", value.asInstanceOf[js.Any])
      
      inline def setEasingUndefined: Self = StObject.set(x, "easing", js.undefined)
      
      inline def setEl(value: String | Element): Self = StObject.set(x, "el", value.asInstanceOf[js.Any])
      
      inline def setElUndefined: Self = StObject.set(x, "el", js.undefined)
      
      inline def setElement(value: String | Element): Self = StObject.set(x, "element", value.asInstanceOf[js.Any])
      
      inline def setElementUndefined: Self = StObject.set(x, "element", js.undefined)
      
      inline def setOffset(value: Double): Self = StObject.set(x, "offset", value.asInstanceOf[js.Any])
      
      inline def setOffsetUndefined: Self = StObject.set(x, "offset", js.undefined)
      
      inline def setOnCancel(value: js.Function0[Unit] | `false`): Self = StObject.set(x, "onCancel", value.asInstanceOf[js.Any])
      
      inline def setOnCancelFunction0(value: () => Unit): Self = StObject.set(x, "onCancel", js.Any.fromFunction0(value))
      
      inline def setOnCancelUndefined: Self = StObject.set(x, "onCancel", js.undefined)
      
      inline def setOnDone(value: js.Function0[Unit] | `false`): Self = StObject.set(x, "onDone", value.asInstanceOf[js.Any])
      
      inline def setOnDoneFunction0(value: () => Unit): Self = StObject.set(x, "onDone", js.Any.fromFunction0(value))
      
      inline def setOnDoneUndefined: Self = StObject.set(x, "onDone", js.undefined)
      
      inline def setX(value: Boolean): Self = StObject.set(x, "x", value.asInstanceOf[js.Any])
      
      inline def setXUndefined: Self = StObject.set(x, "x", js.undefined)
      
      inline def setY(value: Boolean): Self = StObject.set(x, "y", value.asInstanceOf[js.Any])
      
      inline def setYUndefined: Self = StObject.set(x, "y", js.undefined)
    }
  }
  
  trait VueScrollTo extends StObject {
    
    def scrollTo(element: String): Unit
    def scrollTo(element: String, duration: Double): Unit
    def scrollTo(element: String, duration: Double, options: Options): Unit
    def scrollTo(element: String, options: Options): Unit
    def scrollTo(element: Element): Unit
    def scrollTo(element: Element, duration: Double): Unit
    def scrollTo(element: Element, duration: Double, options: Options): Unit
    def scrollTo(element: Element, options: Options): Unit
    def scrollTo(options: Options): Unit
    @JSName("scrollTo")
    var scrollTo_Original: VueStatic
  }
  object VueScrollTo {
    
    inline def apply(scrollTo: VueStatic): VueScrollTo = {
      val __obj = js.Dynamic.literal(scrollTo = scrollTo.asInstanceOf[js.Any])
      __obj.asInstanceOf[VueScrollTo]
    }
    
    extension [Self <: VueScrollTo](x: Self) {
      
      inline def setScrollTo(value: VueStatic): Self = StObject.set(x, "scrollTo", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait VueStatic extends StObject {
    
    def apply(element: String): Unit = js.native
    def apply(element: String, duration: Double): Unit = js.native
    def apply(element: String, duration: Double, options: Options): Unit = js.native
    def apply(element: String, options: Options): Unit = js.native
    def apply(element: Element): Unit = js.native
    def apply(element: Element, duration: Double): Unit = js.native
    def apply(element: Element, duration: Double, options: Options): Unit = js.native
    def apply(element: Element, options: Options): Unit = js.native
    def apply(options: Options): Unit = js.native
  }
  
  object vueTypesVueAugmentingMod {
    
    trait Vue extends StObject {
      
      @JSName("$scrollTo")
      def $scrollTo(element: String): Unit
      @JSName("$scrollTo")
      def $scrollTo(element: String, duration: Double): Unit
      @JSName("$scrollTo")
      def $scrollTo(element: String, duration: Double, options: Options): Unit
      @JSName("$scrollTo")
      def $scrollTo(element: String, options: Options): Unit
      @JSName("$scrollTo")
      def $scrollTo(element: Element): Unit
      @JSName("$scrollTo")
      def $scrollTo(element: Element, duration: Double): Unit
      @JSName("$scrollTo")
      def $scrollTo(element: Element, duration: Double, options: Options): Unit
      @JSName("$scrollTo")
      def $scrollTo(element: Element, options: Options): Unit
      @JSName("$scrollTo")
      def $scrollTo(options: Options): Unit
      @JSName("$scrollTo")
      var $scrollTo_Original: VueStatic
    }
    object Vue {
      
      inline def apply($scrollTo: VueStatic): Vue = {
        val __obj = js.Dynamic.literal($scrollTo = $scrollTo.asInstanceOf[js.Any])
        __obj.asInstanceOf[Vue]
      }
      
      extension [Self <: Vue](x: Self) {
        
        inline def set$scrollTo(value: VueStatic): Self = StObject.set(x, "$scrollTo", value.asInstanceOf[js.Any])
      }
    }
  }
}
