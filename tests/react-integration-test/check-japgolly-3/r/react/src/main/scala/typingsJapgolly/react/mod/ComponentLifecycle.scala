package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import typingsJapgolly.react.Readonly
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

//
// Component Specs and Lifecycle
// ----------------------------------------------------------------------
// This should actually be something like `Lifecycle<P, S> | DeprecatedLifecycle<P, S>`,
// as React will _not_ call the deprecated lifecycle methods if any of the new lifecycle
// methods are present.
trait ComponentLifecycle[P, S, SS]
  extends StObject
     with NewLifecycle[P, S, SS]
     with DeprecatedLifecycle[P, S] {
  
  /**
    * Catches exceptions generated in descendant components. Unhandled exceptions will cause
    * the entire component tree to unmount.
    */
  var componentDidCatch: js.UndefOr[
    js.Function2[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Error */ /* error */ Any, 
      /* errorInfo */ ErrorInfo, 
      Unit
    ]
  ] = js.undefined
  
  /**
    * Called immediately after a component is mounted. Setting state here will trigger re-rendering.
    */
  var componentDidMount: js.UndefOr[js.Function0[Unit]] = js.undefined
  
  /**
    * Called immediately before a component is destroyed. Perform any necessary cleanup in this method, such as
    * cancelled network requests, or cleaning up any DOM elements created in `componentDidMount`.
    */
  var componentWillUnmount: js.UndefOr[js.Function0[Unit]] = js.undefined
  
  /**
    * Called to determine whether the change in props and state should trigger a re-render.
    *
    * `Component` always returns true.
    * `PureComponent` implements a shallow comparison on props and state and returns true if any
    * props or states have changed.
    *
    * If false is returned, `Component#render`, `componentWillUpdate`
    * and `componentDidUpdate` will not be called.
    */
  var shouldComponentUpdate: js.UndefOr[
    js.Function3[
      /* nextProps */ Readonly[P], 
      /* nextState */ Readonly[S], 
      /* nextContext */ Any, 
      Boolean
    ]
  ] = js.undefined
}
object ComponentLifecycle {
  
  inline def apply[P, S, SS](): ComponentLifecycle[P, S, SS] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ComponentLifecycle[P, S, SS]]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: ComponentLifecycle[?, ?, ?], P, S, SS] (val x: Self & (ComponentLifecycle[P, S, SS])) extends AnyVal {
    
    inline def setComponentDidCatch(
      value: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Error */ /* error */ Any, /* errorInfo */ ErrorInfo) => Callback
    ): Self = StObject.set(x, "componentDidCatch", js.Any.fromFunction2((t0: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Error */ /* error */ Any, t1: /* errorInfo */ ErrorInfo) => (value(t0, t1)).runNow()))
    
    inline def setComponentDidCatchUndefined: Self = StObject.set(x, "componentDidCatch", js.undefined)
    
    inline def setComponentDidMount(value: Callback): Self = StObject.set(x, "componentDidMount", value.toJsFn)
    
    inline def setComponentDidMountUndefined: Self = StObject.set(x, "componentDidMount", js.undefined)
    
    inline def setComponentWillUnmount(value: Callback): Self = StObject.set(x, "componentWillUnmount", value.toJsFn)
    
    inline def setComponentWillUnmountUndefined: Self = StObject.set(x, "componentWillUnmount", js.undefined)
    
    inline def setShouldComponentUpdate(
      value: (/* nextProps */ Readonly[P], /* nextState */ Readonly[S], /* nextContext */ Any) => Boolean
    ): Self = StObject.set(x, "shouldComponentUpdate", js.Any.fromFunction3(value))
    
    inline def setShouldComponentUpdateUndefined: Self = StObject.set(x, "shouldComponentUpdate", js.undefined)
  }
}
