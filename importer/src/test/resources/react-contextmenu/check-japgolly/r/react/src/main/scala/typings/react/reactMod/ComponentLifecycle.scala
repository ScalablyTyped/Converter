package typings.react.reactMod

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
trait ComponentLifecycle[P, S, SS]
  extends NewLifecycle[P, S, SS]
     with DeprecatedLifecycle[P, S] {
  /**
    * Catches exceptions generated in descendant components. Unhandled exceptions will cause
    * the entire component tree to unmount.
    */
  var componentDidCatch: js.UndefOr[
    js.Function2[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, 
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
    js.Function3[/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any, Boolean]
  ] = js.undefined
}

object ComponentLifecycle {
  @scala.inline
  def apply[P, S, SS](
    UNSAFE_componentWillMount: js.UndefOr[Callback] = js.undefined,
    UNSAFE_componentWillReceiveProps: js.UndefOr[(P, /* nextContext */ js.Any) => Callback] = js.undefined,
    UNSAFE_componentWillUpdate: js.UndefOr[(P, S, /* nextContext */ js.Any) => Callback] = js.undefined,
    componentDidCatch: js.UndefOr[
      (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, /* errorInfo */ ErrorInfo) => Callback
    ] = js.undefined,
    componentDidMount: js.UndefOr[Callback] = js.undefined,
    componentDidUpdate: js.UndefOr[(P, S, /* snapshot */ js.UndefOr[SS]) => Callback] = js.undefined,
    componentWillMount: js.UndefOr[Callback] = js.undefined,
    componentWillReceiveProps: js.UndefOr[(P, /* nextContext */ js.Any) => Callback] = js.undefined,
    componentWillUnmount: js.UndefOr[Callback] = js.undefined,
    componentWillUpdate: js.UndefOr[(P, S, /* nextContext */ js.Any) => Callback] = js.undefined,
    getSnapshotBeforeUpdate: js.UndefOr[(P, S) => CallbackTo[SS | Null]] = js.undefined,
    shouldComponentUpdate: js.UndefOr[
      (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => CallbackTo[Boolean]
    ] = js.undefined
  ): ComponentLifecycle[P, S, SS] = {
    val __obj = js.Dynamic.literal()
    UNSAFE_componentWillMount.foreach(p => __obj.updateDynamic("UNSAFE_componentWillMount")(js.Any.fromFunction0((() => p.runNow()))))
    UNSAFE_componentWillReceiveProps.foreach(p => __obj.updateDynamic("UNSAFE_componentWillReceiveProps")(js.Any.fromFunction2(((t0: P, t1: /* nextContext */ js.Any) => p(t0, t1).runNow()))))
    UNSAFE_componentWillUpdate.foreach(p => __obj.updateDynamic("UNSAFE_componentWillUpdate")(js.Any.fromFunction3(((t0: P, t1: S, t2: /* nextContext */ js.Any) => p(t0, t1, t2).runNow()))))
    componentDidCatch.foreach(p => __obj.updateDynamic("componentDidCatch")(js.Any.fromFunction2(((t0: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, t1: /* errorInfo */ typings.react.reactMod.ErrorInfo) => p(t0, t1).runNow()))))
    componentDidMount.foreach(p => __obj.updateDynamic("componentDidMount")(js.Any.fromFunction0((() => p.runNow()))))
    componentDidUpdate.foreach(p => __obj.updateDynamic("componentDidUpdate")(js.Any.fromFunction3(((t0: P, t1: S, t2: /* snapshot */ js.UndefOr[SS]) => p(t0, t1, t2).runNow()))))
    componentWillMount.foreach(p => __obj.updateDynamic("componentWillMount")(js.Any.fromFunction0((() => p.runNow()))))
    componentWillReceiveProps.foreach(p => __obj.updateDynamic("componentWillReceiveProps")(js.Any.fromFunction2(((t0: P, t1: /* nextContext */ js.Any) => p(t0, t1).runNow()))))
    componentWillUnmount.foreach(p => __obj.updateDynamic("componentWillUnmount")(js.Any.fromFunction0((() => p.runNow()))))
    componentWillUpdate.foreach(p => __obj.updateDynamic("componentWillUpdate")(js.Any.fromFunction3(((t0: P, t1: S, t2: /* nextContext */ js.Any) => p(t0, t1, t2).runNow()))))
    getSnapshotBeforeUpdate.foreach(p => __obj.updateDynamic("getSnapshotBeforeUpdate")(js.Any.fromFunction2(((t0: P, t1: S) => p(t0, t1).runNow()))))
    shouldComponentUpdate.foreach(p => __obj.updateDynamic("shouldComponentUpdate")(js.Any.fromFunction3(((t0: /* nextProps */ P, t1: /* nextState */ S, t2: /* nextContext */ js.Any) => p(t0, t1, t2).runNow()))))
    __obj.asInstanceOf[ComponentLifecycle[P, S, SS]]
  }
}

