package typingsSlinky.react.mod

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
    UNSAFE_componentWillMount: () => Unit = null,
    UNSAFE_componentWillReceiveProps: (P, /* nextContext */ js.Any) => Unit = null,
    UNSAFE_componentWillUpdate: (P, S, /* nextContext */ js.Any) => Unit = null,
    componentDidCatch: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, /* errorInfo */ ErrorInfo) => Unit = null,
    componentDidMount: () => Unit = null,
    componentDidUpdate: (P, S, /* snapshot */ js.UndefOr[SS]) => Unit = null,
    componentWillMount: () => Unit = null,
    componentWillReceiveProps: (P, /* nextContext */ js.Any) => Unit = null,
    componentWillUnmount: () => Unit = null,
    componentWillUpdate: (P, S, /* nextContext */ js.Any) => Unit = null,
    getSnapshotBeforeUpdate: (P, S) => SS | Null = null,
    shouldComponentUpdate: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Boolean = null
  ): ComponentLifecycle[P, S, SS] = {
    val __obj = js.Dynamic.literal()
    if (UNSAFE_componentWillMount != null) __obj.updateDynamic("UNSAFE_componentWillMount")(js.Any.fromFunction0(UNSAFE_componentWillMount))
    if (UNSAFE_componentWillReceiveProps != null) __obj.updateDynamic("UNSAFE_componentWillReceiveProps")(js.Any.fromFunction2(UNSAFE_componentWillReceiveProps))
    if (UNSAFE_componentWillUpdate != null) __obj.updateDynamic("UNSAFE_componentWillUpdate")(js.Any.fromFunction3(UNSAFE_componentWillUpdate))
    if (componentDidCatch != null) __obj.updateDynamic("componentDidCatch")(js.Any.fromFunction2(componentDidCatch))
    if (componentDidMount != null) __obj.updateDynamic("componentDidMount")(js.Any.fromFunction0(componentDidMount))
    if (componentDidUpdate != null) __obj.updateDynamic("componentDidUpdate")(js.Any.fromFunction3(componentDidUpdate))
    if (componentWillMount != null) __obj.updateDynamic("componentWillMount")(js.Any.fromFunction0(componentWillMount))
    if (componentWillReceiveProps != null) __obj.updateDynamic("componentWillReceiveProps")(js.Any.fromFunction2(componentWillReceiveProps))
    if (componentWillUnmount != null) __obj.updateDynamic("componentWillUnmount")(js.Any.fromFunction0(componentWillUnmount))
    if (componentWillUpdate != null) __obj.updateDynamic("componentWillUpdate")(js.Any.fromFunction3(componentWillUpdate))
    if (getSnapshotBeforeUpdate != null) __obj.updateDynamic("getSnapshotBeforeUpdate")(js.Any.fromFunction2(getSnapshotBeforeUpdate))
    if (shouldComponentUpdate != null) __obj.updateDynamic("shouldComponentUpdate")(js.Any.fromFunction3(shouldComponentUpdate))
    __obj.asInstanceOf[ComponentLifecycle[P, S, SS]]
  }
  @scala.inline
  implicit class ComponentLifecycleOps[Self[p, s, ss] <: ComponentLifecycle[p, s, ss], P, S, SS] (val x: Self[P, S, SS]) extends AnyVal {
    @scala.inline
    def duplicate: Self[P, S, SS] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[P, S, SS]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[P, S, SS]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[P, S, SS]) with Other]
    @scala.inline
    def withComponentDidCatch(
      componentDidCatch: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, /* errorInfo */ ErrorInfo) => Unit
    ): Self[P, S, SS] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (componentDidCatch != null) ret.updateDynamic("componentDidCatch")(js.Any.fromFunction2(componentDidCatch))
        ret.asInstanceOf[Self[P, S, SS]]
    }
    @scala.inline
    def withoutComponentDidCatch: Self[P, S, SS] = {
        val ret = this.duplicate
        js.special.delete(ret, "componentDidCatch")
        ret.asInstanceOf[Self[P, S, SS]]
    }
    @scala.inline
    def withComponentDidMount(componentDidMount: () => Unit): Self[P, S, SS] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (componentDidMount != null) ret.updateDynamic("componentDidMount")(js.Any.fromFunction0(componentDidMount))
        ret.asInstanceOf[Self[P, S, SS]]
    }
    @scala.inline
    def withoutComponentDidMount: Self[P, S, SS] = {
        val ret = this.duplicate
        js.special.delete(ret, "componentDidMount")
        ret.asInstanceOf[Self[P, S, SS]]
    }
    @scala.inline
    def withComponentWillUnmount(componentWillUnmount: () => Unit): Self[P, S, SS] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (componentWillUnmount != null) ret.updateDynamic("componentWillUnmount")(js.Any.fromFunction0(componentWillUnmount))
        ret.asInstanceOf[Self[P, S, SS]]
    }
    @scala.inline
    def withoutComponentWillUnmount: Self[P, S, SS] = {
        val ret = this.duplicate
        js.special.delete(ret, "componentWillUnmount")
        ret.asInstanceOf[Self[P, S, SS]]
    }
    @scala.inline
    def withShouldComponentUpdate(shouldComponentUpdate: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Boolean): Self[P, S, SS] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (shouldComponentUpdate != null) ret.updateDynamic("shouldComponentUpdate")(js.Any.fromFunction3(shouldComponentUpdate))
        ret.asInstanceOf[Self[P, S, SS]]
    }
    @scala.inline
    def withoutShouldComponentUpdate: Self[P, S, SS] = {
        val ret = this.duplicate
        js.special.delete(ret, "shouldComponentUpdate")
        ret.asInstanceOf[Self[P, S, SS]]
    }
  }
  
}

