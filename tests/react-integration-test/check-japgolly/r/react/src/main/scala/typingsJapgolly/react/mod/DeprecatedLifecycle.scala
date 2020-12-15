package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait DeprecatedLifecycle[P, S] extends StObject {
  
  /**
    * Called immediately before mounting occurs, and before `Component#render`.
    * Avoid introducing any side-effects or subscriptions in this method.
    *
    * This method will not stop working in React 17.
    *
    * Note: the presence of getSnapshotBeforeUpdate or getDerivedStateFromProps
    * prevents this from being invoked.
    *
    * @deprecated 16.3, use componentDidMount or the constructor instead
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#initializing-state
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#gradual-migration-path
    */
  var UNSAFE_componentWillMount: js.UndefOr[js.Function0[Unit]] = js.native
  
  /**
    * Called when the component may be receiving new props.
    * React may call this even if props have not changed, so be sure to compare new and existing
    * props if you only want to handle changes.
    *
    * Calling `Component#setState` generally does not trigger this method.
    *
    * This method will not stop working in React 17.
    *
    * Note: the presence of getSnapshotBeforeUpdate or getDerivedStateFromProps
    * prevents this from being invoked.
    *
    * @deprecated 16.3, use static getDerivedStateFromProps instead
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#updating-state-based-on-props
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#gradual-migration-path
    */
  var UNSAFE_componentWillReceiveProps: js.UndefOr[js.Function2[/* nextProps */ P, /* nextContext */ js.Any, Unit]] = js.native
  
  /**
    * Called immediately before rendering when new props or state is received. Not called for the initial render.
    *
    * Note: You cannot call `Component#setState` here.
    *
    * This method will not stop working in React 17.
    *
    * Note: the presence of getSnapshotBeforeUpdate or getDerivedStateFromProps
    * prevents this from being invoked.
    *
    * @deprecated 16.3, use getSnapshotBeforeUpdate instead
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#reading-dom-properties-before-an-update
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#gradual-migration-path
    */
  var UNSAFE_componentWillUpdate: js.UndefOr[
    js.Function3[/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any, Unit]
  ] = js.native
  
  /**
    * Called immediately before mounting occurs, and before `Component#render`.
    * Avoid introducing any side-effects or subscriptions in this method.
    *
    * Note: the presence of getSnapshotBeforeUpdate or getDerivedStateFromProps
    * prevents this from being invoked.
    *
    * @deprecated 16.3, use componentDidMount or the constructor instead; will stop working in React 17
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#initializing-state
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#gradual-migration-path
    */
  var componentWillMount: js.UndefOr[js.Function0[Unit]] = js.native
  
  /**
    * Called when the component may be receiving new props.
    * React may call this even if props have not changed, so be sure to compare new and existing
    * props if you only want to handle changes.
    *
    * Calling `Component#setState` generally does not trigger this method.
    *
    * Note: the presence of getSnapshotBeforeUpdate or getDerivedStateFromProps
    * prevents this from being invoked.
    *
    * @deprecated 16.3, use static getDerivedStateFromProps instead; will stop working in React 17
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#updating-state-based-on-props
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#gradual-migration-path
    */
  var componentWillReceiveProps: js.UndefOr[js.Function2[/* nextProps */ P, /* nextContext */ js.Any, Unit]] = js.native
  
  /**
    * Called immediately before rendering when new props or state is received. Not called for the initial render.
    *
    * Note: You cannot call `Component#setState` here.
    *
    * Note: the presence of getSnapshotBeforeUpdate or getDerivedStateFromProps
    * prevents this from being invoked.
    *
    * @deprecated 16.3, use getSnapshotBeforeUpdate instead; will stop working in React 17
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#reading-dom-properties-before-an-update
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#gradual-migration-path
    */
  var componentWillUpdate: js.UndefOr[
    js.Function3[/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any, Unit]
  ] = js.native
}
object DeprecatedLifecycle {
  
  @scala.inline
  def apply[P, S](): DeprecatedLifecycle[P, S] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[DeprecatedLifecycle[P, S]]
  }
  
  @scala.inline
  implicit class DeprecatedLifecycleMutableBuilder[Self <: DeprecatedLifecycle[_, _], P, S] (val x: Self with (DeprecatedLifecycle[P, S])) extends AnyVal {
    
    @scala.inline
    def setComponentWillMount(value: Callback): Self = StObject.set(x, "componentWillMount", value.toJsFn)
    
    @scala.inline
    def setComponentWillMountUndefined: Self = StObject.set(x, "componentWillMount", js.undefined)
    
    @scala.inline
    def setComponentWillReceiveProps(value: (/* nextProps */ P, /* nextContext */ js.Any) => Callback): Self = StObject.set(x, "componentWillReceiveProps", js.Any.fromFunction2((t0: /* nextProps */ P, t1: /* nextContext */ js.Any) => (value(t0, t1)).runNow()))
    
    @scala.inline
    def setComponentWillReceivePropsUndefined: Self = StObject.set(x, "componentWillReceiveProps", js.undefined)
    
    @scala.inline
    def setComponentWillUpdate(value: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Callback): Self = StObject.set(x, "componentWillUpdate", js.Any.fromFunction3((t0: /* nextProps */ P, t1: /* nextState */ S, t2: /* nextContext */ js.Any) => (value(t0, t1, t2)).runNow()))
    
    @scala.inline
    def setComponentWillUpdateUndefined: Self = StObject.set(x, "componentWillUpdate", js.undefined)
    
    @scala.inline
    def setUNSAFE_componentWillMount(value: Callback): Self = StObject.set(x, "UNSAFE_componentWillMount", value.toJsFn)
    
    @scala.inline
    def setUNSAFE_componentWillMountUndefined: Self = StObject.set(x, "UNSAFE_componentWillMount", js.undefined)
    
    @scala.inline
    def setUNSAFE_componentWillReceiveProps(value: (/* nextProps */ P, /* nextContext */ js.Any) => Callback): Self = StObject.set(x, "UNSAFE_componentWillReceiveProps", js.Any.fromFunction2((t0: /* nextProps */ P, t1: /* nextContext */ js.Any) => (value(t0, t1)).runNow()))
    
    @scala.inline
    def setUNSAFE_componentWillReceivePropsUndefined: Self = StObject.set(x, "UNSAFE_componentWillReceiveProps", js.undefined)
    
    @scala.inline
    def setUNSAFE_componentWillUpdate(value: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Callback): Self = StObject.set(x, "UNSAFE_componentWillUpdate", js.Any.fromFunction3((t0: /* nextProps */ P, t1: /* nextState */ S, t2: /* nextContext */ js.Any) => (value(t0, t1, t2)).runNow()))
    
    @scala.inline
    def setUNSAFE_componentWillUpdateUndefined: Self = StObject.set(x, "UNSAFE_componentWillUpdate", js.undefined)
  }
}
