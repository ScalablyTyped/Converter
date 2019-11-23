package typings.angular.angularMod

import typings.angular.Anon_Args
import typings.angular.angularMod._Global_.Function
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("angular", "auto")
@js.native
object auto extends js.Object {
  ///////////////////////////////////////////////////////////////////////
  // InjectorService
  // see http://docs.angularjs.org/api/AUTO.$injector
  ///////////////////////////////////////////////////////////////////////
  @js.native
  trait IInjectorService extends js.Object {
    var strictDi: Boolean = js.native
    def annotate(fn: Function): js.Array[String] = js.native
    def annotate(fn: Function, strictDi: Boolean): js.Array[String] = js.native
    def annotate(inlineAnnotatedFunction: js.Array[_]): js.Array[String] = js.native
    def get[T](name: String): T = js.native
    def get[T](name: String, caller: String): T = js.native
    def has(name: String): Boolean = js.native
    def instantiate[T](typeConstructor: Anon_Args[T]): T = js.native
    def instantiate[T](typeConstructor: Anon_Args[T], locals: js.Any): T = js.native
    def invoke[T](func: Injectable[Function | (js.Function1[/* repeated */ _, T])]): T = js.native
    def invoke[T](func: Injectable[Function | (js.Function1[/* repeated */ _, T])], context: js.Any): T = js.native
    def invoke[T](func: Injectable[Function | (js.Function1[/* repeated */ _, T])], context: js.Any, locals: js.Any): T = js.native
  }
  
}

