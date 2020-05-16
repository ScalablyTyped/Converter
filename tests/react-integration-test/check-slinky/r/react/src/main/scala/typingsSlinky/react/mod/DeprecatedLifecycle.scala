package typingsSlinky.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DeprecatedLifecycle[P, S] extends js.Object {
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
  def apply[P, S](
    UNSAFE_componentWillMount: () => Unit = null,
    UNSAFE_componentWillReceiveProps: (/* nextProps */ P, /* nextContext */ js.Any) => Unit = null,
    UNSAFE_componentWillUpdate: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Unit = null,
    componentWillMount: () => Unit = null,
    componentWillReceiveProps: (/* nextProps */ P, /* nextContext */ js.Any) => Unit = null,
    componentWillUpdate: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Unit = null
  ): DeprecatedLifecycle[P, S] = {
    val __obj = js.Dynamic.literal()
    if (UNSAFE_componentWillMount != null) __obj.updateDynamic("UNSAFE_componentWillMount")(js.Any.fromFunction0(UNSAFE_componentWillMount))
    if (UNSAFE_componentWillReceiveProps != null) __obj.updateDynamic("UNSAFE_componentWillReceiveProps")(js.Any.fromFunction2(UNSAFE_componentWillReceiveProps))
    if (UNSAFE_componentWillUpdate != null) __obj.updateDynamic("UNSAFE_componentWillUpdate")(js.Any.fromFunction3(UNSAFE_componentWillUpdate))
    if (componentWillMount != null) __obj.updateDynamic("componentWillMount")(js.Any.fromFunction0(componentWillMount))
    if (componentWillReceiveProps != null) __obj.updateDynamic("componentWillReceiveProps")(js.Any.fromFunction2(componentWillReceiveProps))
    if (componentWillUpdate != null) __obj.updateDynamic("componentWillUpdate")(js.Any.fromFunction3(componentWillUpdate))
    __obj.asInstanceOf[DeprecatedLifecycle[P, S]]
  }
  @scala.inline
  implicit class DeprecatedLifecycleOps[Self[p, s] <: DeprecatedLifecycle[p, s], P, S] (val x: Self[P, S]) extends AnyVal {
    @scala.inline
    def duplicate: Self[P, S] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[P, S]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[P, S]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[P, S]) with Other]
    @scala.inline
    def withUNSAFE_componentWillMount(UNSAFE_componentWillMount: () => Unit): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (UNSAFE_componentWillMount != null) ret.updateDynamic("UNSAFE_componentWillMount")(js.Any.fromFunction0(UNSAFE_componentWillMount))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutUNSAFE_componentWillMount: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "UNSAFE_componentWillMount")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withUNSAFE_componentWillReceiveProps(UNSAFE_componentWillReceiveProps: (/* nextProps */ P, /* nextContext */ js.Any) => Unit): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (UNSAFE_componentWillReceiveProps != null) ret.updateDynamic("UNSAFE_componentWillReceiveProps")(js.Any.fromFunction2(UNSAFE_componentWillReceiveProps))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutUNSAFE_componentWillReceiveProps: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "UNSAFE_componentWillReceiveProps")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withUNSAFE_componentWillUpdate(
      UNSAFE_componentWillUpdate: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Unit
    ): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (UNSAFE_componentWillUpdate != null) ret.updateDynamic("UNSAFE_componentWillUpdate")(js.Any.fromFunction3(UNSAFE_componentWillUpdate))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutUNSAFE_componentWillUpdate: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "UNSAFE_componentWillUpdate")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withComponentWillMount(componentWillMount: () => Unit): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (componentWillMount != null) ret.updateDynamic("componentWillMount")(js.Any.fromFunction0(componentWillMount))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutComponentWillMount: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "componentWillMount")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withComponentWillReceiveProps(componentWillReceiveProps: (/* nextProps */ P, /* nextContext */ js.Any) => Unit): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (componentWillReceiveProps != null) ret.updateDynamic("componentWillReceiveProps")(js.Any.fromFunction2(componentWillReceiveProps))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutComponentWillReceiveProps: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "componentWillReceiveProps")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withComponentWillUpdate(componentWillUpdate: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Unit): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (componentWillUpdate != null) ret.updateDynamic("componentWillUpdate")(js.Any.fromFunction3(componentWillUpdate))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutComponentWillUpdate: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "componentWillUpdate")
        ret.asInstanceOf[Self[P, S]]
    }
  }
  
}

