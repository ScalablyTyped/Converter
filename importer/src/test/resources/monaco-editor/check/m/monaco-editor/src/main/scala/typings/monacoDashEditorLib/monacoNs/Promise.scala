package typings
package monacoDashEditorLib.monacoNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("monaco.Promise")
@js.native
class Promise[T, TProgress] protected () extends js.Object {
  def this(executor: js.Function3[
      /* resolve */ js.Function1[/* value */ T | js.Thenable[T], scala.Unit], 
      /* reject */ js.Function1[/* reason */ js.Any, scala.Unit], 
      /* progress */ js.Function1[/* progress */ TProgress, scala.Unit], 
      scala.Unit
    ]) = this()
  def this(executor: js.Function3[
      /* resolve */ js.Function1[/* value */ T | js.Thenable[T], scala.Unit], 
      /* reject */ js.Function1[/* reason */ js.Any, scala.Unit], 
      /* progress */ js.Function1[/* progress */ TProgress, scala.Unit], 
      scala.Unit
    ], oncancel: js.Function0[scala.Unit]) = this()
}

@JSGlobal("monaco.Promise")
@js.native
object Promise extends js.Object {
  def any[T](promises: js.Array[T | js.Thenable[T]]): monacoDashEditorLib.monacoNs.Promise[monacoDashEditorLib.Anon_KeyValue[T], _] = js.native
}

