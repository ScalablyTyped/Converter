package ScalablyTyped
package AngularLib.AngularModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

///////////////////////////////////////////////////////////////////////////////
// ng module (angular.js)
///////////////////////////////////////////////////////////////////////////////
@JSImport("angular", "angular")
@js.native
object angularNamespace extends js.Object {
  ///////////////////////////////////////////////////////////////////////////
  // AngularStatic
  // see http://docs.angularjs.org/api
  ///////////////////////////////////////////////////////////////////////////
  
  trait IAngularStatic extends js.Object {
    /**
             * Wraps a raw DOM element or HTML string as a jQuery element.
             *
             * If jQuery is available, angular.element is an alias for the jQuery function. If jQuery is not available, angular.element delegates to Angular's built-in subset of jQuery, called "jQuery lite" or "jqLite."
             */
    val element: AngularLib.JQueryStatic
    /**
             * If window.name contains prefix NG_DEFER_BOOTSTRAP! when angular.bootstrap is called, the bootstrap process will be paused until angular.resumeBootstrap() is called.
             * @param extraModules An optional array of modules that should be added to the original list of modules that the app was about to be bootstrapped with.
             */
    val resumeBootstrap: js.UndefOr[js.Function1[/* extraModules */ js.UndefOr[StdLib.Array[java.lang.String]], AngularLib.AngularModule.autoNamespace.IInjectorService]] = js.undefined
    def equals(value1: js.Any, value2: js.Any): scala.Boolean
    def extend(destination: js.Any, sources: js.Any*): js.Any
  }
  
  // All service providers extend this interface
  
  trait IServiceProvider extends js.Object {
    @JSName("$get")
    val $get: js.Any
  }
  
  @js.native
  object autoNamespace extends js.Object {
    ///////////////////////////////////////////////////////////////////////
    // InjectorService
    // see http://docs.angularjs.org/api/AUTO.$injector
    ///////////////////////////////////////////////////////////////////////
    @js.native
    trait IInjectorService extends js.Object {
      val strictDi: scala.Boolean = js.native
      def annotate(fn: js.Function): StdLib.Array[java.lang.String] = js.native
      def annotate(fn: js.Function, strictDi: scala.Boolean): StdLib.Array[java.lang.String] = js.native
      def annotate(inlineAnnotatedFunction: StdLib.Array[_]): StdLib.Array[java.lang.String] = js.native
      def get[T](name: java.lang.String): T = js.native
      def get[T](name: java.lang.String, caller: java.lang.String): T = js.native
      def has(name: java.lang.String): scala.Boolean = js.native
      def instantiate[T](typeConstructor: AngularLib.Anon_Args[T]): T = js.native
      def instantiate[T](typeConstructor: AngularLib.Anon_Args[T], locals: js.Any): T = js.native
      def invoke[T](func: AngularLib.AngularModule.angularNamespace.Injectable[js.Function | (js.Function1[/* repeated */_, T])]): T = js.native
      def invoke[T](func: AngularLib.AngularModule.angularNamespace.Injectable[js.Function | (js.Function1[/* repeated */_, T])], context: js.Any): T = js.native
      def invoke[T](func: AngularLib.AngularModule.angularNamespace.Injectable[js.Function | (js.Function1[/* repeated */_, T])], context: js.Any, locals: js.Any): T = js.native
    }
    
  }
  
  type Injectable[T /* <: js.Function */] = T | (StdLib.Array[java.lang.String | T])
}

