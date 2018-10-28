package ScalablyTyped
package AngularLib.AngularModule.angularNamespace.autoNamespace

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
  def annotate(fn: js.Function): StdLib.Array[java.lang.String] = js.native
  def annotate(fn: js.Function, strictDi: scala.Boolean): StdLib.Array[java.lang.String] = js.native
  def annotate(inlineAnnotatedFunction: StdLib.Array[_]): StdLib.Array[java.lang.String] = js.native
  def get[T](name: java.lang.String): T = js.native
  def get[T](name: java.lang.String, caller: java.lang.String): T = js.native
  def has(name: java.lang.String): scala.Boolean = js.native
  def instantiate[T](typeConstructor: AngularLib.Anon_Args[T]): T = js.native
  def instantiate[T](typeConstructor: AngularLib.Anon_Args[T], locals: js.Any): T = js.native
  def invoke[T](
    func: AngularLib.AngularModule.angularNamespace.Injectable[js.Function | (js.Function1[/* repeated */_, T])]
  ): T = js.native
  def invoke[T](
    func: AngularLib.AngularModule.angularNamespace.Injectable[js.Function | (js.Function1[/* repeated */_, T])],
    context: js.Any
  ): T = js.native
  def invoke[T](
    func: AngularLib.AngularModule.angularNamespace.Injectable[js.Function | (js.Function1[/* repeated */_, T])],
    context: js.Any,
    locals: js.Any
  ): T = js.native
}

