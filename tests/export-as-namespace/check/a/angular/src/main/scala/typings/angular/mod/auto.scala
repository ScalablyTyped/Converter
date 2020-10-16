package typings.angular.mod

import typings.angular.anon.Instantiable
import typings.angular.mod.global.Function
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("angular", "auto")
@js.native
object auto extends js.Object {
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

