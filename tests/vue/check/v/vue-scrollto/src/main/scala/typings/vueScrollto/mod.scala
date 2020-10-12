package typings.vueScrollto

import typings.std.Element
import typings.vue.pluginMod.PluginFunction
import typings.vue.vueMod.Vue
import typings.vue.vueMod.VueConstructor
import typings.vueScrollto.vueScrolltoBooleans.`false`
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* static members */
object mod {
  
  @JSImport("vue-scrollto", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  @JSImport("vue-scrollto", JSImport.Namespace)
  @js.native
  class ^ () extends VueScrollTo
  
  @JSImport("vue-scrollto", "install")
  @js.native
  def install: PluginFunction[scala.Nothing] = js.native
  @scala.inline
  def install_=(x: PluginFunction[scala.Nothing]): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("install")(x.asInstanceOf[js.Any])
  @JSImport("vue-scrollto", "install")
  @js.native
  def install(Vue: VueConstructor[Vue]): Unit = js.native
  @JSImport("vue-scrollto", "install")
  @js.native
  def install(Vue: VueConstructor[Vue], options: scala.Nothing): Unit = js.native
  
  @js.native
  trait Options extends js.Object {
    
    // Indicates if user can cancel the scroll or not. Default: true
    var cancelable: js.UndefOr[Boolean] = js.native
    
    // The container that has to be scrolled. Default: body
    var container: js.UndefOr[String | Element] = js.native
    
    // The duration (in milliseconds) of the scrolling animation. Default: 500
    var duration: js.UndefOr[Double] = js.native
    
    // The easing to be used when animating. Default: ease
    var easing: js.UndefOr[String] = js.native
    
    // The element you want to scroll to.
    var el: js.UndefOr[String | Element] = js.native
    
    var element: js.UndefOr[String | Element] = js.native
    
    // The offset that should be applied when scrolling. Default: 0
    var offset: js.UndefOr[Double] = js.native
    
    // A callback function that should be called when scrolling has been aborted by the user (user scrolled, clicked
    // etc.). Default: noop
    var onCancel: js.UndefOr[js.Function0[Unit] | `false`] = js.native
    
    // A callback function that should be called when scrolling has ended. Default: noop
    var onDone: js.UndefOr[js.Function0[Unit] | `false`] = js.native
    
    // Whether or not we want scrolling on the x axis. Default: true
    var x: js.UndefOr[Boolean] = js.native
    
    // Whether or not we want scrolling on the y axis. Default: true
    var y: js.UndefOr[Boolean] = js.native
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
      def setCancelable(value: Boolean): Self = this.set("cancelable", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteCancelable: Self = this.set("cancelable", js.undefined)
      
      @scala.inline
      def setContainer(value: String | Element): Self = this.set("container", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteContainer: Self = this.set("container", js.undefined)
      
      @scala.inline
      def setDuration(value: Double): Self = this.set("duration", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteDuration: Self = this.set("duration", js.undefined)
      
      @scala.inline
      def setEasing(value: String): Self = this.set("easing", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteEasing: Self = this.set("easing", js.undefined)
      
      @scala.inline
      def setEl(value: String | Element): Self = this.set("el", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteEl: Self = this.set("el", js.undefined)
      
      @scala.inline
      def setElement(value: String | Element): Self = this.set("element", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteElement: Self = this.set("element", js.undefined)
      
      @scala.inline
      def setOffset(value: Double): Self = this.set("offset", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteOffset: Self = this.set("offset", js.undefined)
      
      @scala.inline
      def setOnCancelFunction0(value: () => Unit): Self = this.set("onCancel", js.Any.fromFunction0(value))
      
      @scala.inline
      def setOnCancel(value: js.Function0[Unit] | `false`): Self = this.set("onCancel", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteOnCancel: Self = this.set("onCancel", js.undefined)
      
      @scala.inline
      def setOnDoneFunction0(value: () => Unit): Self = this.set("onDone", js.Any.fromFunction0(value))
      
      @scala.inline
      def setOnDone(value: js.Function0[Unit] | `false`): Self = this.set("onDone", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteOnDone: Self = this.set("onDone", js.undefined)
      
      @scala.inline
      def setX(value: Boolean): Self = this.set("x", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteX: Self = this.set("x", js.undefined)
      
      @scala.inline
      def setY(value: Boolean): Self = this.set("y", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteY: Self = this.set("y", js.undefined)
    }
  }
  
  @js.native
  trait VueScrollTo extends js.Object {
    
    def scrollTo(element: String): Unit = js.native
    def scrollTo(element: String, duration: Double): Unit = js.native
    def scrollTo(element: String, duration: Double, options: Options): Unit = js.native
    def scrollTo(element: String, options: Options): Unit = js.native
    def scrollTo(element: Element): Unit = js.native
    def scrollTo(element: Element, duration: Double): Unit = js.native
    def scrollTo(element: Element, duration: Double, options: Options): Unit = js.native
    def scrollTo(element: Element, options: Options): Unit = js.native
    def scrollTo(options: Options): Unit = js.native
    @JSName("scrollTo")
    var scrollTo_Original: VueStatic = js.native
  }
  
  @js.native
  trait VueStatic extends js.Object {
    
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
    
    @js.native
    trait Vue extends js.Object {
      
      @JSName("$scrollTo")
      def $scrollTo(element: String): Unit = js.native
      @JSName("$scrollTo")
      def $scrollTo(element: String, duration: Double): Unit = js.native
      @JSName("$scrollTo")
      def $scrollTo(element: String, duration: Double, options: Options): Unit = js.native
      @JSName("$scrollTo")
      def $scrollTo(element: String, options: Options): Unit = js.native
      @JSName("$scrollTo")
      def $scrollTo(element: Element): Unit = js.native
      @JSName("$scrollTo")
      def $scrollTo(element: Element, duration: Double): Unit = js.native
      @JSName("$scrollTo")
      def $scrollTo(element: Element, duration: Double, options: Options): Unit = js.native
      @JSName("$scrollTo")
      def $scrollTo(element: Element, options: Options): Unit = js.native
      @JSName("$scrollTo")
      def $scrollTo(options: Options): Unit = js.native
      @JSName("$scrollTo")
      var $scrollTo_Original: VueStatic = js.native
    }
  }
}
