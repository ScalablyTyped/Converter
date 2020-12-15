package typings.angular

import typings.angular.anon.Instantiable
import typings.angular.mod.auto.IInjectorService
import typings.angular.mod.global.Function
import typings.std.ArrayLike
import typings.std.Document
import typings.std.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("angular", JSImport.Namespace)
  @js.native
  val ^ : IAngularStatic = js.native
  
  /* Syntax to write `mod` instead of `mod.^` */
  @scala.inline
  implicit def __is(ignored: mod.type): IAngularStatic = typings.angular.mod.^
  
  ///////////////////////////////////////////////////////////////////////////
  // AngularStatic
  // see http://docs.angularjs.org/api
  ///////////////////////////////////////////////////////////////////////////
  @js.native
  trait IAngularStatic extends js.Object {
    
    /**
      * Wraps a raw DOM element or HTML string as a jQuery element.
      *
      * If jQuery is available, angular.element is an alias for the jQuery function. If jQuery is not available, angular.element delegates to Angular's built-in subset of jQuery, called "jQuery lite" or "jqLite."
      */
    def element(element: String): JQLite = js.native
    def element(element: js.Function0[Unit]): JQLite = js.native
    def element(element: JQuery): JQLite = js.native
    def element(element: ArrayLike[Element]): JQLite = js.native
    def element(element: Document): JQLite = js.native
    def element(element: Element): JQLite = js.native
    /**
      * Wraps a raw DOM element or HTML string as a jQuery element.
      *
      * If jQuery is available, angular.element is an alias for the jQuery function. If jQuery is not available, angular.element delegates to Angular's built-in subset of jQuery, called "jQuery lite" or "jqLite."
      */
    @JSName("element")
    var element_Original: JQueryStatic = js.native
    
    def equals(value1: js.Any, value2: js.Any): Boolean = js.native
    
    def extend(destination: js.Any, sources: js.Any*): js.Any = js.native
    
    /**
      * If window.name contains prefix NG_DEFER_BOOTSTRAP! when angular.bootstrap is called, the bootstrap process will be paused until angular.resumeBootstrap() is called.
      * @param extraModules An optional array of modules that should be added to the original list of modules that the app was about to be bootstrapped with.
      */
    var resumeBootstrap: js.UndefOr[js.Function1[/* extraModules */ js.UndefOr[js.Array[String]], IInjectorService]] = js.native
  }
  
  // All service providers extend this interface
  @js.native
  trait IServiceProvider extends js.Object {
    
    @JSName("$get")
    var $get: js.Any = js.native
  }
  object IServiceProvider {
    
    @scala.inline
    def apply($get: js.Any): IServiceProvider = {
      val __obj = js.Dynamic.literal($get = $get.asInstanceOf[js.Any])
      __obj.asInstanceOf[IServiceProvider]
    }
    
    @scala.inline
    implicit class IServiceProviderOps[Self <: IServiceProvider] (val x: Self) extends AnyVal {
      
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
      def set$get(value: js.Any): Self = this.set("$get", value.asInstanceOf[js.Any])
    }
  }
  
  object auto {
    
    ///////////////////////////////////////////////////////////////////////
    // InjectorService
    // see http://docs.angularjs.org/api/AUTO.$injector
    ///////////////////////////////////////////////////////////////////////
    @js.native
    trait IInjectorService extends js.Object {
      
      def annotate(fn: Function): js.Array[String] = js.native
      def annotate(fn: Function, strictDi: Boolean): js.Array[String] = js.native
      def annotate(inlineAnnotatedFunction: js.Array[_]): js.Array[String] = js.native
      
      def get[T](name: String): T = js.native
      def get[T](name: String, caller: String): T = js.native
      
      def has(name: String): Boolean = js.native
      
      def instantiate[T](typeConstructor: Instantiable[T]): T = js.native
      def instantiate[T](typeConstructor: Instantiable[T], locals: js.Any): T = js.native
      
      def invoke[T](func: Injectable[Function | (js.Function1[/* repeated */ _, T])]): T = js.native
      def invoke[T](
        func: Injectable[Function | (js.Function1[/* repeated */ _, T])],
        context: js.UndefOr[scala.Nothing],
        locals: js.Any
      ): T = js.native
      def invoke[T](func: Injectable[Function | (js.Function1[/* repeated */ _, T])], context: js.Any): T = js.native
      def invoke[T](func: Injectable[Function | (js.Function1[/* repeated */ _, T])], context: js.Any, locals: js.Any): T = js.native
      
      var strictDi: Boolean = js.native
    }
  }
  
  // Support for painless dependency injection
  object global {
    
    @js.native
    trait Function extends js.Object {
      
      @JSName("$inject")
      var $inject: js.UndefOr[js.Array[String]] = js.native
    }
  }
  
  type Injectable[T /* <: Function */] = T | (js.Array[String | T])
}
