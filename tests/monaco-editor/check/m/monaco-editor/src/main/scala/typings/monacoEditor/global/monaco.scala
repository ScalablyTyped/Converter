package typings.monacoEditor.global

import typings.monacoEditor.anon.Key
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("monaco")
@js.native
object monaco extends js.Object {
  @js.native
  class Promise[T, TProgress] protected ()
    extends typings.monacoEditor.monaco.Promise[T, TProgress] {
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
  @js.native
  object Promise extends js.Object {
    def any[T](promises: js.Array[T | js.Thenable[T]]): typings.monacoEditor.monaco.Promise[Key[T], _] = js.native
  }
  
}

