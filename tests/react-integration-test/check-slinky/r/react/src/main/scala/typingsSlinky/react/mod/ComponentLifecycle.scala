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
  def apply[P, S, SS](): ComponentLifecycle[P, S, SS] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ComponentLifecycle[P, S, SS]]
  }
  @scala.inline
  implicit class ComponentLifecycleOps[Self <: ComponentLifecycle[_, _, _], P, S, SS] (val x: Self with (ComponentLifecycle[P, S, SS])) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withComponentDidCatch(
      value: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, /* errorInfo */ ErrorInfo) => Unit
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentDidCatch")(js.Any.fromFunction2(value))
        ret
    }
    @scala.inline
    def withoutComponentDidCatch: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentDidCatch")(js.undefined)
        ret
    }
    @scala.inline
    def withComponentDidMount(value: () => Unit): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentDidMount")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutComponentDidMount: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentDidMount")(js.undefined)
        ret
    }
    @scala.inline
    def withComponentWillUnmount(value: () => Unit): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentWillUnmount")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutComponentWillUnmount: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentWillUnmount")(js.undefined)
        ret
    }
    @scala.inline
    def withShouldComponentUpdate(value: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("shouldComponentUpdate")(js.Any.fromFunction3(value))
        ret
    }
    @scala.inline
    def withoutShouldComponentUpdate: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("shouldComponentUpdate")(js.undefined)
        ret
    }
  }
  
}

