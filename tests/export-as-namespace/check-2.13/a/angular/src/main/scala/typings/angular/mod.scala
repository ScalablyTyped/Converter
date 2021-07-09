package typings.angular

import org.scalablytyped.runtime.Shortcut
import typings.angular.anon.Instantiable
import typings.angular.mod.auto.IInjectorService
import typings.angular.mod.global.Function
import typings.std.ArrayLike
import typings.std.Document
import typings.std.Element
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod extends Shortcut {
  
  @JSImport("angular", JSImport.Namespace)
  @js.native
  val ^ : IAngularStatic = js.native
  
  ///////////////////////////////////////////////////////////////////////////
  // AngularStatic
  // see http://docs.angularjs.org/api
  ///////////////////////////////////////////////////////////////////////////
  @js.native
  trait IAngularStatic extends StObject {
    
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
  object IAngularStatic {
    
    @scala.inline
    def apply(
      element: /* element */ String | Element | Document | JQuery | ArrayLike[Element] | js.Function0[Unit] => JQLite,
      equals_ : (js.Any, js.Any) => Boolean,
      extend: (js.Any, /* repeated */ js.Any) => js.Any
    ): IAngularStatic = {
      val __obj = js.Dynamic.literal(element = js.Any.fromFunction1(element), extend = js.Any.fromFunction2(extend))
      __obj.updateDynamic("equals")(js.Any.fromFunction2(equals_))
      __obj.asInstanceOf[IAngularStatic]
    }
    
    @scala.inline
    implicit class IAngularStaticMutableBuilder[Self <: IAngularStatic] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setElement(
        value: /* element */ String | Element | Document | JQuery | ArrayLike[Element] | js.Function0[Unit] => JQLite
      ): Self = StObject.set(x, "element", js.Any.fromFunction1(value))
      
      @scala.inline
      def setEquals_(value: (js.Any, js.Any) => Boolean): Self = StObject.set(x, "equals", js.Any.fromFunction2(value))
      
      @scala.inline
      def setExtend(value: (js.Any, /* repeated */ js.Any) => js.Any): Self = StObject.set(x, "extend", js.Any.fromFunction2(value))
      
      @scala.inline
      def setResumeBootstrap(value: /* extraModules */ js.UndefOr[js.Array[String]] => IInjectorService): Self = StObject.set(x, "resumeBootstrap", js.Any.fromFunction1(value))
      
      @scala.inline
      def setResumeBootstrapUndefined: Self = StObject.set(x, "resumeBootstrap", js.undefined)
    }
  }
  
  // All service providers extend this interface
  @js.native
  trait IServiceProvider extends StObject {
    
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
    implicit class IServiceProviderMutableBuilder[Self <: IServiceProvider] (val x: Self) extends AnyVal {
      
      @scala.inline
      def set$get(value: js.Any): Self = StObject.set(x, "$get", value.asInstanceOf[js.Any])
    }
  }
  
  type Injectable[T /* <: Function */] = T | (js.Array[String | T])
  
  type _To = IAngularStatic
  
  /* This means you don't have to write `^`, but can instead just say `mod.foo` */
  override def _to: IAngularStatic = ^
  
  object auto {
    
    ///////////////////////////////////////////////////////////////////////
    // InjectorService
    // see http://docs.angularjs.org/api/AUTO.$injector
    ///////////////////////////////////////////////////////////////////////
    @js.native
    trait IInjectorService extends StObject {
      
      def annotate(fn: Function): js.Array[String] = js.native
      def annotate(fn: Function, strictDi: Boolean): js.Array[String] = js.native
      def annotate(inlineAnnotatedFunction: js.Array[js.Any]): js.Array[String] = js.native
      
      def get[T](name: String): T = js.native
      def get[T](name: String, caller: String): T = js.native
      
      def has(name: String): Boolean = js.native
      
      def instantiate[T](typeConstructor: Instantiable[T]): T = js.native
      def instantiate[T](typeConstructor: Instantiable[T], locals: js.Any): T = js.native
      
      def invoke[T](func: Injectable[Function | (js.Function1[/* repeated */ js.Any, T])]): T = js.native
      def invoke[T](func: Injectable[Function | (js.Function1[/* repeated */ js.Any, T])], context: js.Any): T = js.native
      def invoke[T](
        func: Injectable[Function | (js.Function1[/* repeated */ js.Any, T])],
        context: js.Any,
        locals: js.Any
      ): T = js.native
      def invoke[T](
        func: Injectable[Function | (js.Function1[/* repeated */ js.Any, T])],
        context: Unit,
        locals: js.Any
      ): T = js.native
      
      var strictDi: Boolean = js.native
    }
  }
  
  // Support for painless dependency injection
  object global {
    
    @js.native
    trait Function extends StObject {
      
      @JSName("$inject")
      var $inject: js.UndefOr[js.Array[String]] = js.native
    }
  }
}
