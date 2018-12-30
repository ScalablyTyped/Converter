package typings
package angularLib.angularMod.angularNs.autoNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

///////////////////////////////////////////////////////////////////////
// InjectorService
// see http://docs.angularjs.org/api/AUTO.$injector
///////////////////////////////////////////////////////////////////////
@js.native
trait IInjectorService extends js.Object {
  var strictDi: scala.Boolean = js.native
  def annotate(fn: angularLib.angularMod.Global.Function): js.Array[java.lang.String] = js.native
  def annotate(fn: angularLib.angularMod.Global.Function, strictDi: scala.Boolean): js.Array[java.lang.String] = js.native
  def annotate(inlineAnnotatedFunction: js.Array[_]): js.Array[java.lang.String] = js.native
  def get[T](name: java.lang.String): T = js.native
  def get[T](name: java.lang.String, caller: java.lang.String): T = js.native
  def has(name: java.lang.String): scala.Boolean = js.native
  def instantiate[T](typeConstructor: angularLib.Anon_Args[T]): T = js.native
  def instantiate[T](typeConstructor: angularLib.Anon_Args[T], locals: js.Any): T = js.native
  def invoke[T](
    func: angularLib.angularMod.angularNs.Injectable[angularLib.angularMod.Global.Function | (js.Function1[/* repeated */ _, T])]
  ): T = js.native
  def invoke[T](
    func: angularLib.angularMod.angularNs.Injectable[angularLib.angularMod.Global.Function | (js.Function1[/* repeated */ _, T])],
    context: js.Any
  ): T = js.native
  def invoke[T](
    func: angularLib.angularMod.angularNs.Injectable[angularLib.angularMod.Global.Function | (js.Function1[/* repeated */ _, T])],
    context: js.Any,
    locals: js.Any
  ): T = js.native
}

