package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

//
// Component Specs and Lifecycle
// ----------------------------------------------------------------------
// This should actually be something like `Lifecycle<P, S> | DeprecatedLifecycle<P, S>`,
// as React will _not_ call the deprecated lifecycle methods if any of the new lifecycle
// methods are present.
@js.native
trait ComponentLifecycle[P, S, SS]
  extends NewLifecycle[P, S, SS]
     with DeprecatedLifecycle[P, S] {
  /**
    * Catches exceptions generated in descendant components. Unhandled exceptions will cause
    * the entire component tree to unmount.
    */
  var componentDidCatch: js.UndefOr[
    js.Function2[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, 
      /* errorInfo */ ErrorInfo, 
      Unit
    ]
  ] = js.native
  /**
    * Called immediately after a component is mounted. Setting state here will trigger re-rendering.
    */
  var componentDidMount: js.UndefOr[js.Function0[Unit]] = js.native
  /**
    * Called immediately before a component is destroyed. Perform any necessary cleanup in this method, such as
    * cancelled network requests, or cleaning up any DOM elements created in `componentDidMount`.
    */
  var componentWillUnmount: js.UndefOr[js.Function0[Unit]] = js.native
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
    js.Function3[/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any, Boolean]
  ] = js.native
}

object ComponentLifecycle {
  @scala.inline
  def apply[P, S, SS](
    UNSAFE_componentWillMount: js.UndefOr[Callback] = js.undefined,
    UNSAFE_componentWillReceiveProps: (P, /* nextContext */ js.Any) => Callback = null,
    UNSAFE_componentWillUpdate: (P, S, /* nextContext */ js.Any) => Callback = null,
    componentDidCatch: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, /* errorInfo */ ErrorInfo) => Callback = null,
    componentDidMount: js.UndefOr[Callback] = js.undefined,
    componentDidUpdate: (P, S, /* snapshot */ js.UndefOr[SS]) => Callback = null,
    componentWillMount: js.UndefOr[Callback] = js.undefined,
    componentWillReceiveProps: (P, /* nextContext */ js.Any) => Callback = null,
    componentWillUnmount: js.UndefOr[Callback] = js.undefined,
    componentWillUpdate: (P, S, /* nextContext */ js.Any) => Callback = null,
    getSnapshotBeforeUpdate: (P, S) => CallbackTo[SS | Null] = null,
    shouldComponentUpdate: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => CallbackTo[Boolean] = null
  ): ComponentLifecycle[P, S, SS] = {
    val __obj = js.Dynamic.literal()
    UNSAFE_componentWillMount.foreach(p => __obj.updateDynamic("UNSAFE_componentWillMount")(p.toJsFn))
    if (UNSAFE_componentWillReceiveProps != null) __obj.updateDynamic("UNSAFE_componentWillReceiveProps")(js.Any.fromFunction2((t0: P, t1: /* nextContext */ js.Any) => UNSAFE_componentWillReceiveProps(t0, t1).runNow()))
    if (UNSAFE_componentWillUpdate != null) __obj.updateDynamic("UNSAFE_componentWillUpdate")(js.Any.fromFunction3((t0: P, t1: S, t2: /* nextContext */ js.Any) => UNSAFE_componentWillUpdate(t0, t1, t2).runNow()))
    if (componentDidCatch != null) __obj.updateDynamic("componentDidCatch")(js.Any.fromFunction2((t0: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, t1: /* errorInfo */ typingsJapgolly.react.mod.ErrorInfo) => componentDidCatch(t0, t1).runNow()))
    componentDidMount.foreach(p => __obj.updateDynamic("componentDidMount")(p.toJsFn))
    if (componentDidUpdate != null) __obj.updateDynamic("componentDidUpdate")(js.Any.fromFunction3((t0: P, t1: S, t2: /* snapshot */ js.UndefOr[SS]) => componentDidUpdate(t0, t1, t2).runNow()))
    componentWillMount.foreach(p => __obj.updateDynamic("componentWillMount")(p.toJsFn))
    if (componentWillReceiveProps != null) __obj.updateDynamic("componentWillReceiveProps")(js.Any.fromFunction2((t0: P, t1: /* nextContext */ js.Any) => componentWillReceiveProps(t0, t1).runNow()))
    componentWillUnmount.foreach(p => __obj.updateDynamic("componentWillUnmount")(p.toJsFn))
    if (componentWillUpdate != null) __obj.updateDynamic("componentWillUpdate")(js.Any.fromFunction3((t0: P, t1: S, t2: /* nextContext */ js.Any) => componentWillUpdate(t0, t1, t2).runNow()))
    if (getSnapshotBeforeUpdate != null) __obj.updateDynamic("getSnapshotBeforeUpdate")(js.Any.fromFunction2((t0: P, t1: S) => getSnapshotBeforeUpdate(t0, t1).runNow()))
    if (shouldComponentUpdate != null) __obj.updateDynamic("shouldComponentUpdate")(js.Any.fromFunction3((t0: /* nextProps */ P, t1: /* nextState */ S, t2: /* nextContext */ js.Any) => shouldComponentUpdate(t0, t1, t2).runNow()))
    __obj.asInstanceOf[ComponentLifecycle[P, S, SS]]
  }
}

