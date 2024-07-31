package typings.monacoEditor

import _root_.typings.monacoEditor.anon.Key
import _root_.typings.std.PromiseLike
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object monaco {
    
    @JSGlobal("monaco.Promise")
    @js.native
    open class Promise[T, TProgress] protected ()
      extends StObject
         with _root_.typings.monacoEditor.monaco.Promise[T, TProgress] {
      def this(executor: js.Function3[
                /* resolve */ js.Function1[/* value */ T | PromiseLike[T], Unit], 
                /* reject */ js.Function1[/* reason */ Any, Unit], 
                /* progress */ js.Function1[/* progress */ TProgress, Unit], 
                Unit
              ]) = this()
      def this(
        executor: js.Function3[
                /* resolve */ js.Function1[/* value */ T | PromiseLike[T], Unit], 
                /* reject */ js.Function1[/* reason */ Any, Unit], 
                /* progress */ js.Function1[/* progress */ TProgress, Unit], 
                Unit
              ],
        oncancel: js.Function0[Unit]
      ) = this()
    }
    /* static members */
    object Promise {
      
      @JSGlobal("monaco.Promise")
      @js.native
      val ^ : js.Any = js.native
      
      inline def any[T](promises: js.Array[T | PromiseLike[T]]): _root_.typings.monacoEditor.monaco.Promise[Key[T], Any] = ^.asInstanceOf[js.Dynamic].applyDynamic("any")(promises.asInstanceOf[js.Any]).asInstanceOf[_root_.typings.monacoEditor.monaco.Promise[Key[T], Any]]
    }
  }
}
