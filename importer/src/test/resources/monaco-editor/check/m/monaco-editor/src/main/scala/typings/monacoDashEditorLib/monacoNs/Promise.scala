package typings
package monacoDashEditorLib.monacoNs

import monacoDashEditorLib.Anon_Key
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("monaco.Promise")
@js.native
class Promise[T, TProgress] protected () extends js.Object {
  def this(executor: js.Function3[
        /* resolve */ js.Function1[/* value */ T | js.Thenable[T], Unit], 
        /* reject */ js.Function1[/* reason */ js.Any, Unit], 
        /* progress */ js.Function1[/* progress */ TProgress, Unit], 
        Unit
      ]) = this()
  def this(
    executor: js.Function3[
        /* resolve */ js.Function1[/* value */ T | js.Thenable[T], Unit], 
        /* reject */ js.Function1[/* reason */ js.Any, Unit], 
        /* progress */ js.Function1[/* progress */ TProgress, Unit], 
        Unit
      ],
    oncancel: js.Function0[Unit]
  ) = this()
}

/* static members */
@JSGlobal("monaco.Promise")
@js.native
object Promise extends js.Object {
  def any[T](promises: js.Array[T | js.Thenable[T]]): Promise[Anon_Key[T], _] = js.native
}

